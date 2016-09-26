import java.util.Scanner;

/**
 * Created by MUSAB on 26.9.2016.
 */
public class Admin {

    public String[][] ogrenciler = new String[2][5];

    public  void sorgula() {
        Scanner input = new Scanner(System.in);
        System.out.println("Admin islemleri icin 1,ogrenci islemleri icin 2 giriniz:");
        int sayi = input.nextInt();

        if (sayi == 1) {
            System.out.println("Sifre giriniz: ");
            String girilen=input.next();
            if (girilen.equals("12345")) {
                adminisl();
            } else {
                System.out.println("Sifre yanlis girildi yeniden giriniz...");
                sorgula();
            }
        }

        if (sayi == 2) {
            Ogrenci ogrenci=new Ogrenci();
            ogrenci.IslemYap();
        }

    }
    public void adminisl() {

        Scanner islem = new Scanner(System.in);
        System.out.print("ogrenci ekle: (1) " + "\n" + "ogrenci sil: (2)" + "\n" + "ogrenci listele: (3)\nAna Menü: (4)");
        int sayi1 = islem.nextInt();

        if (sayi1 == 1) {

            ogrenciekle();

        } else if (sayi1 == 2) {

           // ogrencisil();
        } else if (sayi1 == 3) {

        //    ogrencilistele();
        }
        else if(sayi1==4)
            sorgula();
    }

    public  void ogrenciekle() {

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
}
