import java.util.Scanner;

public class Ogrenci {

     String[][] dersler=new String[5][5];
     String[][] ogrenciler = new String[2][5];
     Scanner giris=new Scanner(System.in);

     String isim;
     int sayac=0;



    public void IslemYap() {



            System.out.print("Adınızı giriniz:");
            isim = giris.next();

            for (int i = 0; i < 5; i++) {

                if (dersler[0][i].equals(isim)) {

                    System.out.println("Ders Ekle----- 1\nDers Sil------ 2\nDersler Gör--- 3\nAna Menü------ 4");
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
                        default:
                            System.out.println("Lütfen Geçerli bir seçim yapınız...!!!\n");
                            IslemYap();
                            break;
                    }
                }
            }
        System.out.print("Kayıtlı isim bulunamadı...!!!");
        IslemYap();
    }


    public void DersEkle(){

     // giriste isim yazılan ogrenciler dizideki ismi bulmak için
        for(int i=0;i<5;i++) {
            if (dersler[0][i].equals(isim)){
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

    public void DersSil(){

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

    public void DersleriGoruntule(){

        /*dersler dizisinden verileri çek*/
      /*  for(int i=0;i<5;i++) {
            if (dersler[i][0].equals(adi[i])){
                sayac=i;
                break;
            }
        }*/

        System.out.println("Alınan Dersler");
            for(int j=0;j<6;j++)
                System.out.println(dersler[sayac][j]);

    }


    /*ısimCek fonsiyonunu MAİN DE KULLAN*/
    public void IsimCek(){

        for(int i=0;i<5;i++)
            dersler[0][i]=ogrenciler[0][i];
    }



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
                System.out.println("Şifre yanlış girildi yeniden giriniz...");
                sorgula();
            }
        }

        if (sayi == 2) {

           IslemYap();
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


        Scanner ekle = new Scanner(System.in);

        for(int j=0;j<5;j++) {

            System.out.print("Kişi ismi: ");
            ogrenciler[0][j]=ekle.next();
            dersler[0][j]=ogrenciler[0][j];
            System.out.print("Numara: ");
            ogrenciler[1][j]=ekle.next();

        }

        for(int i=0;i<5;i++)
            dersler[0][i]=ogrenciler[0][i];


        adminisl();



    }


    public static void main(String[] args){

        Ogrenci ogrenci=new Ogrenci();
        ogrenci.sorgula();


    }
}


 /* public  void GirisSecim(){

        System.out.println("Admin---- 1\nÖğrenci-- 2");
        System.out.print("Seçiminiz:");
        int sec1=giris.nextInt();

        switch (sec1){
            case 1:
                System.out.print("Sifre giriniz: ");
                String girilen=giris.next();
                if(!girilen.equals("admin")) {
                    System.out.println("Yanlış şifre !!!");
                    GirisSecim();
                }
                else {
                    System.out.print("Öğrenci Ekle---------- 1\nÖğrenci Sil----------- 2\nÖğrencileri Görüntüle- 3\n");
                    System.out.print("Seçiminiz:");
                    int sec2=giris.nextInt();
                    switch (sec2){
                        case 1:
                        //    OgrenciEkle();
                            break;
                        case 2:
                        //    OgrenciSil();
                            break;
                        case 3:
                         //   OgrenciGoruntule();
                            break;
                        default:
                            System.out.println("Lütfen Geçerli bir seçim yapınız...!!!");
                            break;
                    }
                }
                break;
            case 2:
                IslemYap();
                break;
            default:
                System.out.println("Geçerli seçim yapınız!!!");
                GirisSecim();
                break;
        }
    }

*/