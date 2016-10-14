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


     public void setIsim(String isim) {
         this.isim = isim;
     }

     public String getIsim()
     {return isim;}

     public void setSoyisim(String soyisim) {
         this.soyisim = soyisim;
     }

     public String getSoyisim() {
         return soyisim;
     }

     public void setNumara(int numara) {
         this.numara = numara;
     }

     public int getNumara() {
         return numara;
     }

     public void setBolum(String bolum) {
         this.bolum = bolum;
     }

     public String getBolum() {
         return bolum;
     }

     public void setSınıf(int sınıf) {
         this.sınıf = sınıf;
     }

     public int getSınıf() {
         return sınıf;
     }
 }

 class Ders {


    private String derskodu;
    private String dersadi;
    private String hocaadi;
    private String hocasoyadi;
    private String derssube;
    private String derskredi;

    public void setDerskodu(String derskodu) {
        this.derskodu = derskodu;
    }

    public String getDerskodu() {
        return derskodu;
    }

    public void setDersadi(String dersadi) {
        this.dersadi = dersadi;
    }

    public String getDersadi() {
        return dersadi;
    }

    public void setHocaadi(String hocaadi) {
        this.hocaadi = hocaadi;
    }

    public String getHocaadi() {
        return hocaadi;
    }

    public void setHocasoyadi(String hocasoyadi) {
        this.hocasoyadi = hocasoyadi;
    }

    public String getHocasoyadi() {
        return hocasoyadi;
    }

    public void setDerssube(String derssube) {
        this.derssube = derssube;
    }

    public String getDerssube() {
        return derssube;
    }

    public void setDerskredi(String derskredi) {
        this.derskredi = derskredi;
    }

    public String getDerskredi() {
        return derskredi;
    }
}


class AdminIslemleri {
    Ogrenci stu =new Ogrenci();

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
        String ad=ekle.next();
                stu.setIsim(ad);
        System.out.print("Soyad giriniz: ");
        String soyad=ekle.next();
                stu.setSoyisim(soyad);
        System.out.print("Numara giriniz: ");
        int numara=ekle.nextInt();
                stu.setNumara(numara);
        System.out.print("Bölüm giriniz: ");
        String bolum=ekle.next();
                stu.setBolum(bolum);
        System.out.print("Sınıf giriniz: ");
        int sınıf=ekle.nextInt();
                stu.setSınıf(sınıf);


        System.out.println("Ekleme basarili...\n");
        adminIslem();

    }

    void ogrenciSil() {

      stu.setIsim(null);
        stu.setSoyisim(null);
        stu.setNumara(0);
        stu.setBolum(null);
        stu.setSınıf(0);

        System.out.println("Silme basarili...\n");

        adminIslem();
    }

    void ogrenciListele() {


        System.out.print("Öğrenci Adı:  "+stu.getIsim());
        System.out.print("  Öğrenci Soyadı:  "+stu.getSoyisim());
        System.out.print("  Öğrenci Numara:  "+stu.getNumara());
        System.out.print("  Öğrenci Bölüm:  "+stu.getBolum());
        System.out.print("  Öğrenci Sınıf:  "+stu.getSınıf());

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

    Scanner giris = new Scanner(System.in);

    Ogrenci ogrenci;
    AdminIslemleri admin;
    Ders ders;

    void dogrula(){

        ogrenci=new Ogrenci();

       /* if(!ogrenci.getIsim().isEmpty()) {

            System.out.print("Öğrenci No:");
            String ogrno=giris.next();
            System.out.print("Adınızı Giriniz:");
            String ad = giris.next();

            if(ogrenci.getNumara().equals(ogrno) && ogrenci.getIsim().equals(ad)){
                islemYap();
            }
            else {
                System.out.println("Eşleşmeye kullanıcı adı ya da şifre..");
                dogrula();
            }
        }
        else {
            System.out.println("Sistemde kayıtlı öğrenci yoktur.");
            admin=new AdminIslemleri();
            admin.sorgula();
        }*/
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
                    admin=new AdminIslemleri();
                    admin.sorgula();
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

        ders=new Ders();

        System.out.print("Ders Kodu:");
        String derskodu=giris.next();
        ders.setDerskodu(derskodu);

        System.out.print("Ders Adı:");
        String dersadi=giris.next();
        ders.setDersadi(dersadi);

        System.out.print("Hoca Adı:");
        String dershocaad=giris.next();
        ders.setHocaadi(dershocaad);

        System.out.print("Hoca Soyadı:");
        String dershocasoyad=giris.next();
        ders.setHocasoyadi(dershocasoyad);

        System.out.print("Ders Şubesi:");
        String derssube=giris.next();
        ders.setDerssube(derssube);

        System.out.print("Ders Kredisi:");
        String derskredi=giris.next();
        ders.setDerskredi(derskredi);

        islemYap();
    }

    void dersSil(){
        ders.setDerskodu(null);
        ders.setDersadi(null);
        ders.setHocaadi(null);
        ders.setHocasoyadi(null);
        ders.setDerssube(null);
        ders.setDerskredi(null);

    }

    void dersleriGoruntule(){

        System.out.print("Ders Kodu: "+ders.getDerskodu());
        System.out.print("Ders Adı: "+ders.getDersadi());
        System.out.print("Hoca Adı: "+ders.getHocaadi());
        System.out.print("Hoca Soyadı: "+ders.getHocasoyadi());
        System.out.print("Ders Şubesi: "+ders.getDerssube());
        System.out.print("Ders Kredisi:"+ders.getDerskredi());

        islemYap();
    }
}
