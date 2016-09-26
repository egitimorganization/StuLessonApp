import java.util.Scanner;

public class Ogrenci {

     public String[][] dersler=new String[5][5];
     Scanner giris=new Scanner(System.in);

    public String isim;
     int sayac=0;

    public void IslemYap() {

        if (!dersler[0][0].isEmpty() || !dersler[0][1].isEmpty() || !dersler[0][2].isEmpty() || !dersler[0][3].isEmpty() || !dersler[0][4].isEmpty()) {

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
                            Admin admin =new Admin();
                            admin.sorgula();
                        default:
                            System.out.println("Lütfen Geçerli bir seçim yapınız...!!!");
                            IslemYap();
                            break;
                    }
                }
            }
            System.out.print("Kayıtlı isim bulunamadı...!!!");
        }
        else{
            System.out.print("");
        }
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
        Admin admin=new Admin();
        for(int i=0;i<5;i++)
            dersler[0][i]=admin.ogrenciler[0][i];
    }


    public static void main(String[] args){

        Admin admin=new Admin();
        admin.sorgula();


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