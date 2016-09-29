package com.company;

import java.util.Scanner;

public class derskayit {
    static String[][] dersler = new String[5][5];
    static String[][] ogrenciler = new String[2][5];

    Scanner giris = new Scanner(System.in);

    String isim;
    int sayac = 0;

    public static void main(String[] args) {

        derskayit ogrenci = new derskayit();
        ogrenci.sorgula();
    }


    void Dogrula(){
        System.out.print("Adınızı giriniz:");
        isim = giris.next();
        int say=0;
        while(!dersler[say][0].equals(isim))
        {
            say++;
            if(say==5){
                say--;
                break;
            }
        }

        if(dersler[say][0].equals(isim))
            IslemYap();
        else {
            System.out.println("Geçerli isim girmediniz.Tekrar deneyiniz...");
            Dogrula();
        }


        /*for (int i = 0; i < 5; i++) {
            if (dersler[0][i].equals(isim)) {
                IslemYap();
            }
        }*/
    }

    void IslemYap(){

        System.out.println("Ders Ekle------ 1\nDers Sil------- 2\nDersleri Gör--- 3\nAna Menü------- 4");
        System.out.print("Seçiminiz: ");
        int secim = giris.nextInt();

        switch (secim) {

            case 1:
                DersEkle();
                break;
            case 2:
                DersSil();
                break;
            case 3:
                DersleriGoruntule();
                break;
            case 4:
                sorgula();
                break;
            default:
                System.out.println("Lütfen Geçerli bir seçim yapınız...!!!\n");
                IslemYap();
                break;

        }
    }


    void DersEkle(){

        // giriste isim yazılan ogrenciler dizideki ismi bulmak için
        for(int i=0;i<5;i++) {
            if (dersler[i][0].equals(isim)){
                sayac=i;
                break;
            }
        }

        System.out.println(isim+" dersleri giriniz..");
        if(sayac==0){
            for(int i=1;i<5;i++) {
                System.out.print(i +".ders:");
                dersler[sayac][i] = giris.next();

            }
        }

        else if(sayac==1){
            for(int i=1;i<5;i++) {
                System.out.print(i +".ders:");
                dersler[sayac][i] = giris.next();
            }
        }

        else if(sayac==2){
            for(int i=1;i<5;i++) {
                System.out.print(i +".ders:");
                dersler[sayac][i] = giris.next();
            }
        }

        else if(sayac==3){
            for(int i=1;i<5;i++) {
                System.out.print(i +".ders:");
                dersler[sayac][i] = giris.next();
            }
        }

        else if(sayac==4){
            for(int i=1;i<5;i++) {
                System.out.print(i +".ders:");
                dersler[sayac][i] = giris.next();
            }
        }

        sayac=0;
        IslemYap();
    }

    void DersSil(){


        for(int i=0;i<5;i++) {
            if (dersler[i][0].equals(isim)){
                sayac=i;
                break;
            }
        }
        if(dersler[sayac][1]!=null) {
            System.out.print("silinecek dersi girin:");
            String dersSil = giris.next();
            for (int i = 1; i < 5; i++) {
                if (dersler[sayac][i].equals(dersSil))
                    dersler[sayac][i] = "";

                if (dersler[sayac][i].isEmpty()) {
                    System.out.print("Silinen dersin yerine ders ekleyiniz:");
                    dersler[sayac][i] = giris.next();
                }
            }
        }
        else {
            System.out.println("Lütfen önce ders giriniz...");
            IslemYap();
        }


        sayac=0;
        IslemYap();
    }

    void DersleriGoruntule(){

        /*dersler dizisinden verileri çek*/
        for(int i=0;i<5;i++) {
            if (dersler[i][0].equals(isim)){
                sayac=i;
                break;
            }
        }

        System.out.println(isim.toUpperCase()+" Alınan Dersler");
        for(int j=1;j<5;j++)
            System.out.println(dersler[sayac][j]);

        sayac=0;
        IslemYap();
    }


    public void sorgula() {
        Scanner input = new Scanner(System.in);
        System.out.println("Admin islemleri icin 1,ogrenci islemleri icin 2 giriniz:");
        int sayi = input.nextInt();

        if (sayi == 1) {
            System.out.println("Sifre giriniz: ");
            String girilen = input.next();
            if (girilen.equals("12345")) {
                adminisl();
            } else {
                System.out.println("Şifre yanlış girildi yeniden giriniz...");
                sorgula();
            }
        }

        if (sayi == 2) {

            Dogrula();
        } else {
            System.out.print("Lütfen geçerli seçim yapınız...");
            sorgula();
        }
    }

    public void adminisl() {

        Scanner islem = new Scanner(System.in);
        System.out.print("ogrenci ekle: (1) " + "\n" + "ogrenci sil: (2)" + "\n" + "ogrenci listele: (3)" + "\n" + "Ana Menü: (4)");
        int sayi1 = islem.nextInt();

        if (sayi1 == 1) {

            ogrenciekle();

        } else if (sayi1 == 2) {

            ogrencisil();
        } else if (sayi1 == 3) {


            ogrencilistele();
        } else if (sayi1 == 4) {
            sorgula();
        }
    }

    public void ogrenciekle() {


        Scanner ekle = new Scanner(System.in);
        int j=0;

        do {
            if (ogrenciler[0][j] == null && ogrenciler[1][j] == null) {
                System.out.print("Kişi ismi: \n");
                ogrenciler[0][j] = ekle.next();
                dersler[0][j] = ogrenciler[0][j];
                System.out.print("Numara: ");
                ogrenciler[1][j] = ekle.next();

                System.out.println("Ekleme basarili...");

                adminisl();
            }

            else if(ogrenciler[0][j] != null && ogrenciler[1][j] != null){
                j++;
            }

            else {
                System.out.println("Ogrenci kontenjani dolu..");

            }

        }while(j<5);




        for (int i = 0; i < 5; i++) {
            dersler[0][i] = ogrenciler[0][i];
        }


        adminisl();
    }

    public void ogrencisil() {
        Scanner sil = new Scanner(System.in);
        for (int j = 0; j < 5; j++) {

            if (ogrenciler[0][j] != null && ogrenciler[1][j] != null) {
                System.out.println((j+1)+ ".ogrenci: "+ " isim: " + ogrenciler[0][j] + " numara: " + ogrenciler[1][j]+ "\n");
            }

        }
        System.out.println("Kaç numaralı öğrenciyi silmek isiyorsunuz? (1-5): ");


        int numara = sil.nextInt();

        ogrenciler[0][numara-1] = null;
        ogrenciler[1][numara-1] = null;

        for(int d=0;d<5;d++) {

                dersler[numara-1][d]=null;
        }

        System.out.println("Silme basarili...");

        adminisl();

    }


    public void ogrencilistele() {

        Scanner sıra = new Scanner(System.in);

        int giris;

        for (int j = 0; j < 5; j++) {

            if (ogrenciler[0][j] != null && ogrenciler[1][j] != null) {
                System.out.println((j + 1) + ".ogrenci: " + " isim: " + ogrenciler[0][j] + " numara: " + ogrenciler[1][j] + "\n");
            }
            else if (ogrenciler[0][j] == null && ogrenciler[1][j] == null) {
                System.out.println((j + 1) + ".kontenjan boş...");
            }

        }
            System.out.println("Derslerini görüntülemek istediğiniz ogrenci sırasını giriniz: ");
            giris = sıra.nextInt();

            for (int m = 1; m < 5; m++) {
                if(dersler[giris-1][m]!=null){
                System.out.println(dersler[giris-1][m] + "\n");}

                else if(dersler[giris-1][m]==null){
                    System.out.println(m+ ".ders alınmamış...");
                }
            }


            adminisl();

    }

}
