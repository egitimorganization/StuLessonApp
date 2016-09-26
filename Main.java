package com.company;

import java.util.Scanner;

public class Main {

    static Scanner input=new Scanner(System.in);

    public static void main(String[] args) {

        String  adminsifre="admn";

        System.out.println("Admin islemleri icin 1,ogrenci islemleri icin 2 giriniz:");

        sorgula();
    }

    public static void sorgula(){

        int sayi=input.nextInt();

        if(sayi==1){
            System.out.println("Sifre giriniz: ");
            String girilen=input.next();
            if(girilen=="admin") {
                adminislemleri.adminsecenek();
            }

            else
            {
                System.out.println("Sifre yanlis girildi yeniden giriniz...");
                sorgula();

            }

        }

        if(sayi==2){



        }

    }
}


  public class adminislemleri{

      public static String [][] ogrenciler= new String[2][5];

    public void adminisl(){
        Scanner islem=new Scanner(System.in);
        System.out.print("ogrenci ekle: (1) "+ "\n" +"ogrenci sil: (2)" + "\n" + "ogrenci listele: (3)");
        int sayi1=islem.nextInt();

        if(sayi1==1){

            ogrenciekle();

        }

        else if(sayi1==2){

            ogrencisil();
        }

        else if(sayi1==3){

            ogrencilistele();

        }
    }
    public void ogrenciekle(){




        Scanner ekle=new Scanner(System.in);
       System.out.println("Kisi ismini ve numarasını giriniz: ");
       String isim=ekle.next();
       String numara=ekle.next();

       while(i!=null){
           ogrenciler[0][i]=isim;
           ogrenciler[1][i]=numara;
       }


    }
    public void ogrencisil(){
        Scanner sil=new Scanner(System.in);
        System.out.println("Kaç numaralı öğrenciyi silmek isiyorsunuz? (1-5): ");
        int numara=sil.nextInt();

        ogrenciler[0][numara]=null;
        ogrenciler[1][numara]=null;


    }

    public void ogrencilistele(){

            for(j=0;j<5;j++) {

                if(i!=null || j!=null)
                { System.out.println("isim: "+ogrenciler[0][j] + "numara: " + ogrenciler[1][j]);
            }

    }



}


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



          }
      }

