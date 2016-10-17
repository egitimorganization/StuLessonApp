import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by MUSAB on 4.10.2016.
 */
public class AdminIslemleri {

    void adminLogin() {

        Scanner input = new Scanner(System.in);

        System.out.print("Sifre giriniz: ");
        String girilen = input.next();
        if (girilen.equals("12345")) {
            adminIslem();
        } else {
            System.out.println("Şifre yanlış girildi yeniden giriniz...");
            adminLogin();
        }

    }

    void adminIslem() {

        Scanner islem = new Scanner(System.in);
        System.out.print("Öğrenci Ekle----- 1 " + "\n" + "Öğrenci sil------ 2" + "\n" +
                "Öğrenci Listele-- 3" + "\n" + "Ana Menü--------- 4");

        System.out.print("\nSeçiminiz:");

        try {
            int sayi1 = islem.nextInt();
            switch (sayi1) {
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
                    Main main = new Main();
                    main.loginSecim();
                    break;
                default:
                    System.out.print("1 ile 4 arasında sayı giriniz.\n");
                    break;
            }
        } catch (InputMismatchException i) {
            System.out.print("1 ile 4 arasında sayı giriniz.\n");
        }
        adminIslem();
    }

    void ogrenciEkle() {

        Ogrenci student = new Ogrenci();

        Scanner ekle = new Scanner(System.in);

        System.out.print("Öğrenci Adı: ");
        student.setOgrenciadi(ekle.next());

        System.out.print("Öğrenci Soyad: ");
        student.setOgrencisoyadi(ekle.next());

        System.out.print("Öğrenci No: ");
        student.setOgrencino(ekle.next());

        System.out.print("Öğrencinin Bölümü: ");
        student.setOgrencibolum(ekle.next());

        System.out.print("Öğrenci Sınıfı: ");
        student.setOgrencisinif(ekle.next());

        System.out.println("Ekleme basarili...\n");

    }

    void ogrenciSil() {
        Ogrenci stu = new Ogrenci();
        Ders ders = new Ders();
        stu.setOgrenciadi(null);
        stu.setOgrencisoyadi(null);
        stu.setOgrencino(null);
        stu.setOgrencibolum(null);
        stu.setOgrencisinif(null);

        ders.setDerskredi(null);
        ders.setDerssube(null);
        ders.setHocasoyadi(null);
        ders.setHocaadi(null);
        ders.setDerskodu(null);


        System.out.println("Silme basarili...\n");

    }

    void ogrenciListele() {

        Ogrenci stu = new Ogrenci();

        System.out.println("Öğrenci Adı: " + stu.getOgrenciadi());
        System.out.println("Öğrenci Soyadı: " + stu.getOgrencisoyadi());
        System.out.println("Öğrenci Numara: " + stu.getOgrencino());
        System.out.println("Öğrenci Bölüm: " + stu.getOgrencibolum());
        System.out.println("Öğrenci Sınıf: " + stu.getOgrencisinif());

    }


}