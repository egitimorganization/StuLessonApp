import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by MUSAB on 4.10.2016.
 */
public class OgrenciIslemleri {

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