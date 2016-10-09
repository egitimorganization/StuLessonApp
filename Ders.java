import jdk.nashorn.internal.objects.annotations.Getter;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by MUSAB on 6.10.2016.
 */
public class Ders {

    static List<List<String>> dersler=new ArrayList<List<String>>();

    OgrenciIslemleri ogrenciIslemleri=new OgrenciIslemleri();


    void dersEkle(){
        try {
            List<String> ders=new ArrayList<>();
            Scanner ekle=new Scanner(System.in);
            System.out.print("Kaç ders eklenecek :");
            int derssayisi=ekle.nextInt();

            for(int i=0;i<derssayisi;i++){
                System.out.print(i+1 +".Ders:");
                String derskayit=ekle.next();
                ders.add(derskayit);
            }

            dersler.add(ogrenciIslemleri.getIndex(),ders);
        }catch (InputMismatchException e){

        }


        ogrenciIslemleri.islemYap();
    }

    void dersSil(){

        try {
            Scanner derssil=new Scanner(System.in);
            System.out.print("Silinecek dersi girin:");
            String delete=derssil.next();

            dersler.get(ogrenciIslemleri.getIndex()).remove(delete);
        }catch (IndexOutOfBoundsException e){}

        ogrenciIslemleri.islemYap();
    }

   void dersleriGoruntule(){

       try {
           if(!dersler.get(ogrenciIslemleri.getIndex()).isEmpty()) {
               System.out.println(ogrenciIslemleri.getIsim().toUpperCase() + " Aldığın dersler");
               System.out.println(dersler.get(ogrenciIslemleri.getIndex()));
           }
           else{
               System.out.print("Önce ders alınız...");
           }
       }catch (IndexOutOfBoundsException e){}

       ogrenciIslemleri.islemYap();
    }

}
