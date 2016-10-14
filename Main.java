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



