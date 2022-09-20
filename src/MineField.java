import java.util.Scanner;
import java.util.Random;


public class MineField {


    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Mayın tarlası Oyununa Hoşgeldin\nOynamak istediğin alan ölçüleri ne olsun" +
                "\nSatır sayısını gir");
        int satir=input.nextInt();
        System.out.println("Sütun sayısını gir");
        int sutun=input.nextInt();
        //Mayın tarlasını oluşturdu
        MineSweeper mTarla= new MineSweeper(satir,sutun);

        //aşağıdaki satırı kontrol amaçlı yazdım
        MineSweeper.yaz(MineSweeper.mineArea);
        int conut=0;//Kareleri dolaştıkça 1 artırıyoruz ve sayısı alan-Mayın sayısına eşit olunca tüm kareleri
                    //gezdiğini anlayıp oyunu kazandınız yazıyor
        boolean kontrol=true;
        do {
            conut++;
            System.out.print("Satır=");
            int sat=input.nextInt()-1;
            System.out.print("Sütun=");
            int sut=input.nextInt()-1;//Dizi index değerini 1 den başlatmayı sağlar
            if(MineSweeper.snrKontrol(sat,sut)){
                System.out.println("Sınırların dışına çıktın tekrar giriş yap");
                //System.out.println(MineSweeper.snrKontrol(sat,sut));
                conut--;//yanlış giriş yapmışsa gereksiz kazanmasını önlüyoruz
            }else{
                if (MineSweeper.mayinKontrol(mTarla.mineArea,sat,sut)){
                    System.out.println("Mayına bastın");
                    kontrol=false;
                    MineSweeper.yaz(MineSweeper.area);
                    break;
                } else{

                    mTarla.area[sat][sut]=String.valueOf(MineSweeper.etrafKontrol(mTarla.mineArea,sat,sut));
                    //girilen karenin etrafında kaç tane mayın varsa onu stringe çevirir ve yazar
                    MineSweeper.yaz(MineSweeper.area);
                }
            }
            if (conut==(MineSweeper.height*MineSweeper.width)-(MineSweeper.height*MineSweeper.width/4)){
                System.out.println("you vin=kazandınız");
                kontrol=false;
            }
        }while (kontrol);
    }
}
