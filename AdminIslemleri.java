import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by MUSAB on 4.10.2016.
 */
public class AdminIslemleri {

    Ogrenci stu =new Ogrenci();

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

        System.out.print("Öğrenci Adı: ");
        stu.setOgrenciadi(ekle.next());

        System.out.print("Öğrenci Soyad: ");
        stu.setOgrencisoyadi(ekle.next());

        System.out.print("Öğrenci No: ");
        stu.setOgrencino(ekle.next());

        System.out.print("Öğrencinin Bölümü: ");
        stu.setOgrencibolum(ekle.next());

        System.out.print("Öğrenci Sınıfı: ");
        stu.setOgrencisinif(ekle.next());

        System.out.println("Ekleme basarili...\n");
        adminIslem();
    }

    void ogrenciSil() {

        stu.setOgrenciadi(null);
        stu.setOgrencisoyadi(null);
        stu.setOgrencino(null);
        stu.setOgrencibolum(null);
        stu.setOgrencisinif(null);

        System.out.println("Silme basarili...\n");

        adminIslem();
    }

    void ogrenciListele() {


        System.out.println("Öğrenci Adı: "+stu.getOgrenciadi());
        System.out.println("Öğrenci Soyadı: "+stu.getOgrencisoyadi());
        System.out.println("Öğrenci Numara: "+stu.getOgrencino());
        System.out.println("Öğrenci Bölüm: "+stu.getOgrencibolum());
        System.out.println("Öğrenci Sınıf: "+stu.getOgrencisinif());

        adminIslem();
    }
















}