import java.util.Random;

public class MineSweeper {

    static String[][] area;//Mayın tarlası boyutunu tutuyor
    static String[][] mineArea; //Mayınların yerini tutuyor
    static int height;
    static int width;
    static int mayinSayisi;

    MineSweeper(int height, int width) {
        this.height = height;
        this.width = width;
        area = new String[this.height][this.width];
        mineArea = new String[this.height][this.width];
        area=doldur(area);
        mineArea=doldur(mineArea);
        mineArea=mayinYerlestir(mineArea);

    }
    public static String[][] doldur(String[][] arr){//bu methot mayıntarlasını tüm alanlarını "-" ile doldurur
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j]="-";
            }
        }
        return arr;
    }

    public static String[][] mayinYerlestir(String[][] arr) {//bu merhot tarlaya rastgele mayın ekiyor
        mayinSayisi = (height * width) / 4;
        System.out.println(mayinSayisi+" adet mayın yerleşti");
        Random rnd = new Random();
        for (int i = 0; i < mayinSayisi; i++) {
            int sat = rnd.nextInt(arr.length);
            int sut = rnd.nextInt(arr[0].length);
            if (!mayinKontrol(arr,sat,sut)){
                arr[sat][sut] = "*";
            } else {//aynı yere mayın yerleşmesini engeller
                i--;
            }


        }
    return arr;
    }

    public static boolean mayinKontrol(String[][] arr, int sat, int sut) {
        if (arr[sat][sut].equals("*")){
            return true;
        }else return false;
    }

    public static void yaz(String[][] arr) {
        System.out.println("====================");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("====================");

    }

    public static boolean snrKontrol(int a, int b) {
        boolean control=false;
        if (a<0) control=true;
        if (a>=height) control=true;
        if (b<0) control=true;
        if (b>=width) control=true;

        return control;
    }

    public static int etrafKontrol(String[][] arr, int a, int b) {
        int count=0;
        for (int i = a-1; i <a+2 ; i++) {
            for (int j = b-1; j <b+2 ; j++) {
                if (i<0 || j<0 ){
                   count=count;
                } else {
                    if (i<height && j<width ){
                        if (mayinKontrol(arr,i,j)){
                            count++;
                        }
                    }

                }
            }
        }
       return count;
    }


}
