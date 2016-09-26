import java.util.Scanner;

/**
 * Created by MUSAB on 25.9.2016.
 */

public class Ogrenci {

    static String[][] dersler=new String[5][6];
  //  static String[] adi=new String[5];
    static Scanner giris=new Scanner(System.in);

    static int sayac=0;

    public static void IslemYap(){

        System.out.println("Ders Ekle----- 1\nDers Sil------ 2\nDersler Gör--- 3");
        System.out.print("Seçiminiz: ");

        int secim=giris.nextInt();

        switch (secim){
            case 1:
                DersEkle();
                break;
            case 2:
                DersSil();
                break;
            case 3:
                DersleriGoruntule();
                break;
            default :
                System.out.println("Lütfen Geçerli bir seçim yapınız...!!!");
                IslemYap();
                break;
        }
    }

    public static void DersEkle(){

        System.out.println("");

        /*
           İSİMLERİ AKTAR
        for(int i=0;i<5;i++)
            dersler[i][0]=

        */


        //Adminden eklenen ogrenciler ile giriste isim yazılan ogrenciler
        for(int i=0;i<5;i++) {
            if (dersler[i][0].equals(adi[i])){
                sayac=i;
                break;
            }
        }

        System.out.println("dersleri giriniz");
        if(sayac==0){
            for(int i=0;i<5;i++) {
                System.out.print(i+1 +".ders:");
                dersler[sayac][i] = giris.nextLine();
                System.out.print("\n");
            }
        }

        else if(sayac==1){
            for(int i=0;i<5;i++) {
                System.out.print(i+1 +".ders:");
                dersler[sayac][i] = giris.nextLine();
                System.out.print("\n");
            }
        }

        else if(sayac==2){
            for(int i=0;i<5;i++) {
                System.out.print(i+1 +".ders:");
                dersler[sayac][i] = giris.nextLine();
                System.out.print("\n");
            }
        }

        else if(sayac==3){
            for(int i=0;i<5;i++) {
                System.out.print(i+1 +".ders:");
                dersler[sayac][i] = giris.nextLine();
                System.out.print("\n");
            }
        }

        else if(sayac==4){
            for(int i=0;i<5;i++) {
                System.out.print(i+1 +".ders:");
                dersler[sayac][i] = giris.nextLine();
                System.out.print("\n");
            }
        }

        sayac=0;
        IslemYap();
    }

    public static void DersSil(){

     /*   System.out.print("silinecek dersi girin:");
        String dersSil=giris.nextLine();

        for(int i=0;i<5;i++){
            if(!(b[i].equals(ders)))
                System.out.print("Lütfen geçerli ders giriniz.");
        }
        ders=scan.nextLine();
        for (int i=0;i<5;i++) {
            if (b[i].equals(ders))
                b[i]="";

            if(b[i].isEmpty()){
                System.out.print("ders ekleyiniz:");
                b[i]=scan.nextLine();
            }
        }
*/
    }

    public static void DersleriGoruntule(){

        /*dersler dizisinden verileri çek*/
        for(int i=0;i<5;i++) {
            if (dersler[i][0].equals(adi[i])){
                sayac=i;
                break;
            }
        }

        System.out.println("Alınan Dersler");
            for(int j=0;j<6;j++)
               System.out.println(dersler[sayac][j]);

    }

    public static void main(String[] args){



       /* for (int i=0;i<5;i++)
            adi[i]=giris.nextLine();
        */

       IslemYap();

    }
}