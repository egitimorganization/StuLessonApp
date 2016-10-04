import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by MUSAB on 4.10.2016.
 */
public class AdminIslemleri {

    OgrenciBilgileri ogrenciBilgileri=new OgrenciBilgileri();

    void sorgula() {

        Scanner input = new Scanner(System.in);
        System.out.println("Admin işlemleri---- 1\nÖğrenci işlemleri-- 2");
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
        int j=0;

        do {
            if (ogrenciBilgileri.ogrenciler[0][j] == null && ogrenciBilgileri.ogrenciler[1][j] == null) {
                System.out.print("Kişi ismi: ");
                ogrenciBilgileri.ogrenciler[0][j] = ekle.next();
                ogrenciBilgileri.dersler[j][0]=ogrenciBilgileri.ogrenciler[0][j];

                System.out.print("Numara: ");
                ogrenciBilgileri.ogrenciler[1][j] = ekle.next();

                System.out.println("Ekleme basarili...\n");

                adminIslem();
            }

            else if(ogrenciBilgileri.ogrenciler[0][j] != null && ogrenciBilgileri.ogrenciler[1][j] != null){
                j++;
            }

            else {
                System.out.println("Ogrenci kontenjani dolu..\n");
            }

        }while(j<5);


        adminIslem();
    }

    void ogrenciSil() {

        Scanner sil = new Scanner(System.in);
        for (int j = 0; j < 5; j++) {

            if (ogrenciBilgileri.ogrenciler[0][j] != null && ogrenciBilgileri.ogrenciler[1][j] != null) {
                System.out.println((j+1)+ ".ogrenci: "+ " isim: " + ogrenciBilgileri.ogrenciler[0][j] +
                        " numara: " + ogrenciBilgileri.ogrenciler[1][j]+ "\n");
            }

        }
        System.out.println("Kaç numaralı öğrenciyi silmek isiyorsunuz? (1-5): ");

        int numara = sil.nextInt();

        ogrenciBilgileri.ogrenciler[0][numara-1] = null;
        ogrenciBilgileri.ogrenciler[1][numara-1] = null;

        for(int d=0;d<5;d++) {

            ogrenciBilgileri.dersler[numara-1][d]=null;
        }

        System.out.println("Silme basarili...\n");

        adminIslem();
    }

    void ogrenciListele() {

        Scanner sıra = new Scanner(System.in);

        int giris;

        for (int j = 0; j < 5; j++) {

            if (ogrenciBilgileri.ogrenciler[0][j] != null && ogrenciBilgileri.ogrenciler[1][j] != null) {
                System.out.println((j + 1) + ".ogrenci: " + " isim: " + ogrenciBilgileri.ogrenciler[0][j] + " numara: "
                        + ogrenciBilgileri.ogrenciler[1][j] + "\n");
            }
            else if (ogrenciBilgileri.ogrenciler[0][j] == null && ogrenciBilgileri.ogrenciler[1][j] == null) {
                System.out.println((j + 1) + ".kontenjan boş...");
            }
        }

        System.out.println("Derslerini görüntülemek istediğiniz ogrenci sırasını giriniz: ");
        giris = sıra.nextInt();

        for (int m = 1; m < 5; m++) {
            if(ogrenciBilgileri.dersler[giris-1][m]!=null){
                System.out.println(ogrenciBilgileri.dersler[giris-1][m]);}

            else if(ogrenciBilgileri.dersler[giris-1][m]==null){
                System.out.println(m+ ".ders alınmamış...");
            }
        }
        adminIslem();
    }

}