import java.util.Scanner;

public class Ogrenci {

     String[][] dersler=new String[5][5];
     String[][] ogrenciler = new String[2][5];
     Scanner giris=new Scanner(System.in);

     String isim;
     int sayac=0;


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

        System.out.println(isim.toUpperCase()+" Aldığın Dersler");
            for(int j=1;j<5;j++)
                System.out.println(dersler[sayac][j]);

        sayac=0;
        IslemYap();
    }

        /*↓↓↓↓↓   ADMİN FONKSİYONLARI  ↓↓↓↓↓*/



    void sorgula() {
        Scanner input = new Scanner(System.in);
        System.out.println("Admin islemleri icin 1,ogrenci islemleri icin 2 giriniz:");
        int sayi = input.nextInt();

        switch (sayi){
            case 1:

                System.out.println("Sifre giriniz: ");
                String girilen=input.next();

                if (girilen.equals("12345")) {
                        adminisl();
                }
                else {
                    System.out.println("Şifre yanlış girildi yeniden giriniz...");
                    sorgula();
                }
                break;
            case 2:
                Dogrula();
                break;
            default:
                System.out.print("Lütfen geçerli seçim yapınız...");
                sorgula();
                break;
        }
    }
    void adminisl() {

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

    void ogrenciekle() {


        Scanner ekle = new Scanner(System.in);

        for(int j=0;j<5;j++) {

            System.out.print("Kişi ismi: ");
            ogrenciler[0][j]=ekle.next();
            System.out.print("Numara: ");
            ogrenciler[1][j]=ekle.next();

        }

        for(int i=0;i<5;i++)
            dersler[i][0]=ogrenciler[0][i];


        adminisl();



    }


    public static void main(String[] args){

        Ogrenci ogrenci=new Ogrenci();
        ogrenci.sorgula();

    }
}