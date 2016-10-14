package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


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





