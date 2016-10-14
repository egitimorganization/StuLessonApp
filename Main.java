package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        AdminIslemleri admin=new AdminIslemleri();
        admin.sorgula();

    }

}

 class Ogrenci{



    private String isim;
    private String soyisim;
    private int numara;
    private String bolum;
    private int sınıf;

     Ogrenci (String  i,String so,int n,String b,int sı) {

         isim=i;
         soyisim=so;
         numara=n;
         bolum=b;
         sınıf=sı;
     }

     public void setOgrenci(String  i,String so,int n,String b,int sı) {

         isim=i;
         soyisim=so;
         numara=n;
         bolum=b;
         sınıf=sı;
     }

     public String getIsim()
     {return isim;}

     public String getSoyisim() {
         return soyisim;
     }

     public int getNumara() {
         return numara;
     }

     public String getBolum() {
         return bolum;
     }

     public int getSınıf() {
         return sınıf;
     }
 }

class Dersler{


}


class AdminIslemleri {
    ArrayList <Ogrenci > ogr=new ArrayList<Ogrenci>();

    OgrenciBilgileri ogrenciBilgileri=new OgrenciBilgileri();

    void sorgula() {

        Scanner input = new Scanner(System.in);
        System.out.println("Admin işlemleri---- 1\n Öğrenci işlemleri-- 2");
        System.out.print("Seçiminiz: ");

        try {
            int sayi = input.nextInt();

            switch (sayi){
                case 1:
                    System.out.print("Sifre giriniz: ");
                    String girilen = input.next();
                    if (girilen.equals("12345")) {
                        adminIslem();
                    } else {
                        System.out.println("Şifre yanlış girildi yeniden giriniz...");
                        sorgula();
                    }
                    break;
                case 2:
                    OgrenciIslemleri ogrenciIslemleri=new OgrenciIslemleri();
                    ogrenciIslemleri.dogrula();
                    break;
                default:
                    System.out.print("\nYalnızca 1 ve 2 yi seçebilirsiniz.\n");
                    sorgula();
                    break;
            }
        }catch (InputMismatchException ime){
            System.out.println("\nLütfen geçerli seçim yapınız...");
            sorgula();
        }

    }

    void adminIslem() {

        Scanner islem = new Scanner(System.in);
        System.out.print("Öğrenci Ekle----- 1 " + "\n" + "Öğrenci sil------ 2" + "\n" +
                "Öğrenci Listele-- 3" + "\n" + "Ana Menü--------- 4");
        System.out.print("\nSeçiminiz:");
        try {
            int sayi1 = islem.nextInt();
            switch (sayi1){
                case 1:
                    ogrenciEkle();
                    break;
                case 2:
                    ogrenciSil();
                    break;
                case 3:
                    ogrenciListele();
                    break;
                case 4:
                    sorgula();
                    break;
                default:
                    System.out.print("1 ile 4 arasında sayı giriniz.\n" );
                    adminIslem();
                    break;
            }
        }catch (InputMismatchException i){
            System.out.print("1 ile 4 arasında sayı giriniz.\n");
            adminIslem();
        }
    }

    void ogrenciEkle() {
        Scanner ekle = new Scanner(System.in);
        System.out.print("Ad giriniz: ");
        String a=ekle.next();
        System.out.print("Soyad giriniz: ");
        String so=ekle.next();
        System.out.print("Numara giriniz: ");
        int n=ekle.nextInt();
        System.out.print("Bölüm giriniz: ");
        String b=ekle.next();
        System.out.print("Sınıf giriniz: ");
        int sı=ekle.nextInt();
        ogr.add(new Ogrenci(a,so,n,b,sı));

        System.out.println("Ekleme basarili...\n");
        adminIslem();

    }

    void ogrenciSil() {

        Scanner sil = new Scanner(System.in);

        System.out.println("Kaç numaralı kişiyi silmek istiyorsunuz? :");
       int silinecekno=sil.nextInt();

        ogr.remove(silinecekno-1);

        System.out.println("Silme basarili...\n");

        adminIslem();
    }

    void ogrenciListele() {


       // ogr.list();
        Scanner sıra = new Scanner(System.in);
        System.out.println("Derslerini görüntülemek istediğiniz ogrenci sırasını giriniz: ");
        int giris = sıra.nextInt();

        adminIslem();
    }

}



class OgrenciBilgileri {

    //ogrenci ve dersleri tutar
    static String[][] dersler = new String[5][5];
    //ogrenci ve numaraları tutar
    static String[][] ogrenciler = new String[2][5];

}


class OgrenciIslemleri {

    OgrenciBilgileri ogrenciBilgileri=new OgrenciBilgileri();
    Scanner giris = new Scanner(System.in);

    String isim;
    int sayac = 0;

    AdminIslemleri adminIslemleri=new AdminIslemleri();

    void dogrula(){

        if(ogrenciBilgileri.dersler[0][0]!=null||ogrenciBilgileri.dersler[1][0]!=null||ogrenciBilgileri.dersler[2][0]!=null||
                ogrenciBilgileri.dersler[3][0]!=null||ogrenciBilgileri.dersler[4][0]!=null) {

            System.out.print("Adınızı giriniz:");
            isim = giris.next();
            int say = 0;

            for(int i=0;i<5;i++){
                if(ogrenciBilgileri.dersler[say][0].equals(isim)) {
                    say = i;
                    break;
                }
            }

            if (ogrenciBilgileri.dersler[say][0].equals(isim))
                islemYap();
            else {
                System.out.println("Geçerli isim girmediniz.Tekrar deneyiniz...");
                dogrula();
            }
        }else {
            System.out.println("Sistemde kayıtlı öğrenci yoktur.");
            adminIslemleri.sorgula();
        }
    }

    void islemYap(){


        System.out.println("Ders Ekle------ 1\nDers Sil------- 2\nDersleri Gör--- 3\nAna Menü------- 4");
        System.out.print("Seçiminiz: \n");

        try {

            int secim = giris.nextInt();
            switch (secim) {
                case 1:
                    dersEkle();
                    break;
                case 2:
                    dersSil();
                    break;
                case 3:
                    dersleriGoruntule();
                    break;
                case 4:
                    AdminIslemleri adminIslemleri = new AdminIslemleri();
                    adminIslemleri.sorgula();
                    break;
                default:
                    System.out.println("1 ile 4 arasında sayı giriniz...\n");
                    islemYap();
                    break;
            }
        }catch (InputMismatchException i){
            System.out.print("1 ile 4 arasında sayı giriniz...");
            islemYap();
        }

    }

    void dersEkle(){

        // giriste isim yazılan ogrenciler dizideki ismi bulmak için
        for(int i=0;i<5;i++) {
            if (ogrenciBilgileri.dersler[i][0].equals(isim)){
                sayac=i;
                break;
            }
        }

        System.out.println(isim+" dersleri giriniz..");
        if(sayac==0 ||sayac==1 || sayac==2  ||sayac==3 || sayac==4  ){
            for(int i=1;i<5;i++) {
                System.out.print(i +".ders:");
                ogrenciBilgileri.dersler[sayac][i] = giris.next();

            }
        }

        sayac=0;
        islemYap();
    }

    void dersSil(){

        for(int i=0;i<5;i++) {
            if (ogrenciBilgileri.dersler[i][0].equals(isim)){
                sayac=i;
                break;
            }
        }
        if(ogrenciBilgileri.dersler[sayac][1]!=null) {
            System.out.print("silinecek dersi girin:");
            String dersSil = giris.next();
            for (int i = 1; i < 5; i++) {
                if (ogrenciBilgileri.dersler[sayac][i].equals(dersSil))
                    ogrenciBilgileri.dersler[sayac][i] = "";

                if (ogrenciBilgileri.dersler[sayac][i].isEmpty()) {
                    System.out.print("Silinen dersin yerine ders ekleyiniz:");
                    ogrenciBilgileri.dersler[sayac][i] = giris.next();
                }
            }
        }
        else {
            System.out.println("Lütfen önce ders giriniz...");
            islemYap();
        }

        sayac=0;
        islemYap();
    }

    void dersleriGoruntule(){

        for(int i=0;i<5;i++) {
            if (ogrenciBilgileri.dersler[i][0].equals(isim)){
                sayac=i;
                break;
            }
        }

        int nullsayac=0;
        for(int i=1;i<5;i++){
            if(ogrenciBilgileri.dersler[sayac][i]==null)
                nullsayac++;
        }

        if(nullsayac==4) {
            System.out.print("Hiç ders alınmamış.\n");
        }
        else {
	        /*dersler dizisinden verileri çek*/
            System.out.println(isim.toUpperCase() + " Alınan Dersler");
            for (int j = 1; j < 5; j++)
                System.out.println(ogrenciBilgileri.dersler[sayac][j]);
        }
        sayac=0;
        islemYap();
    }
}

