import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by MUSAB on 4.10.2016.
 */
public class OgrenciIslemleri {

   // OgrenciBilgileri ogrenciBilgileri=new OgrenciBilgileri();
    Scanner giris = new Scanner(System.in);

    static String isim;
    static int index;


    Ders ders;
    Ogrenci ogrenci;

    public  int getIndex() {
        return index;
    }

    public  void setIndex(int index) {
        this.index = index;
    }
    public void setIsim(String isim){
        this.isim=isim;
    }
    public String getIsim(){
        return isim;
    }

    void dogrula(){
        ogrenci=new Ogrenci();

        if(!ogrenci.list.isEmpty()) {
            System.out.print("Adınızı giriniz:");
            String ad = giris.next();
            setIsim(ad);

            int say=0;
            for (int i = 0; i < ogrenci.list.size(); i++) {
                if (ogrenci.list.get(i).equals(getIsim())) {
                    say = i;
                    break;
                }
            }
            if(ogrenci.list.get(say).equals(getIsim())){

                setIndex(say);
                islemYap();
            }
            else {
                System.out.println("Geçerli isim girmediniz.Tekrar deneyiniz...");
                dogrula();
            }
        }
        else {
            System.out.println("Sistemde kayıtlı öğrenci yoktur.");
            AdminIslemleri admin=new AdminIslemleri();
            admin.sorgula();
        }



    }

    void islemYap(){

        ders=new Ders();
        System.out.println("Ders Ekle------ 1\nDers Sil------- 2\nDersleri Gör--- 3\nAna Menü------- 4");
        System.out.print("Seçiminiz: \n");

        try {

            int secim = giris.nextInt();
            switch (secim) {
                case 1:
                    ders.dersEkle();
                    break;
                case 2:
                    ders.dersSil();
                    break;
                case 3:
                    ders.dersleriGoruntule();
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
        catch (StackOverflowError s){
            islemYap();
        }
    }

}