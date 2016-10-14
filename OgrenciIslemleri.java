
import java.util.InputMismatchException;
import java.util.Scanner;

public class OgrenciIslemleri {

    Scanner giris = new Scanner(System.in);

    Ogrenci ogrenci;
    AdminIslemleri admin;
    Ders ders;

    void dogrula(){

       ogrenci=new Ogrenci();

        if(ogrenci.getOgrenciadi()!=null) {

            System.out.print("Öğrenci No:");
            String ogrno=giris.next();
            System.out.print("Adınızı Giriniz:");
            String ad = giris.next();

            if(ogrenci.getOgrencino().equals(ogrno) && ogrenci.getOgrenciadi().equals(ad)){
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
        ders.setDerskodu(giris.next());

        System.out.print("Ders Adı:");
        ders.setDersadi(giris.next());

        System.out.print("Hoca Adı:");
        ders.setHocaadi(giris.next());

        System.out.print("Hoca Soyadı:");
        ders.setHocasoyadi(giris.next());

        System.out.print("Ders Şubesi:");
        ders.setDerssube(giris.next());

        System.out.print("Ders Kredisi:");
        ders.setDerskredi(giris.next());

        islemYap();
    }

    void dersSil(){
        if (ders.getDersadi()!=null) {
            ders.setDerskodu(null);
            ders.setDersadi(null);
            ders.setHocaadi(null);
            ders.setHocasoyadi(null);
            ders.setDerssube(null);
            ders.setDerskredi(null);
        }
        else
            System.out.println("Ders ekleyiniz..");

        islemYap();
    }

    void dersleriGoruntule(){

        if(ders.getDersadi()!=null) {
            System.out.println("Ders Kodu: " + ders.getDerskodu());
            System.out.println("Ders Adı: " + ders.getDersadi());
            System.out.println("Hoca Adı: " + ders.getHocaadi());
            System.out.println("Hoca Soyadı: " + ders.getHocasoyadi());
            System.out.println("Ders Şubesi: " + ders.getDerssube());
            System.out.println("Ders Kredisi:" + ders.getDerskredi());
        }
        else
            System.out.println("Ders ekleyiniz..");
        islemYap();
    }
}