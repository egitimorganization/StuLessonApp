package com.company;

import java.util.Scanner;

public class Main {


   static String[][] ogrenciler = new String[2][5];

    public static void main(String[] args) {

        System.out.println("Admin islemleri icin 1,ogrenci islemleri icin 2 giriniz:");

        sorgula();
    }

    public static void sorgula() {
        Scanner input = new Scanner(System.in);
        int sayi = input.nextInt();

        if (sayi == 1) {
            System.out.println("Sifre giriniz: ");
            int  girilen = input.nextInt();
            if (girilen ==12345) {
                adminisl();
            } else {
                System.out.println("Sifre yanlis girildi yeniden giriniz...");
                sorgula();

            }

        }

        if (sayi == 2) {

        }

    }


    public static void adminisl() {

        Scanner islem = new Scanner(System.in);
        System.out.print("ogrenci ekle: (1) " + "\n" + "ogrenci sil: (2)" + "\n" + "ogrenci listele: (3)");
        int sayi1 = islem.nextInt();

        if (sayi1 == 1) {

            ogrenciekle();

        } else if (sayi1 == 2) {

            ogrencisil();
        } else if (sayi1 == 3) {

            ogrencilistele();
        }
    }

    public static void ogrenciekle() {

        int i = 0;
        Scanner ekle = new Scanner(System.in);
        System.out.println("Kisi ismini ve numarasını giriniz: ");
        String isim = ekle.next();
        String numara = ekle.next();
         do
        {
            if(ogrenciler[0][i]==null &&ogrenciler[1][i]==null)
            {ogrenciler[0][i] = isim;
            ogrenciler[1][i] = numara;

            adminisl();}

            else
                i++;

        } while (i<5);


    }

    public static void ogrencisil() {
        Scanner sil = new Scanner(System.in);
        System.out.println("Kaç numaralı öğrenciyi silmek isiyorsunuz? (1-5): ");
        int numara = sil.nextInt();

        ogrenciler[0][numara] = null;
        ogrenciler[1][numara] = null;


    }

    public static void ogrencilistele() {

        for (int j = 0; j < 5; j++) {

            if ( ogrenciler[0][j]!= null && ogrenciler[1][j]!=null) {
                System.out.println("isim: " + ogrenciler[0][j] + "numara: " + ogrenciler[1][j]);
            }

        }


    }
}




