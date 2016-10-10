import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by MUSAB on 6.10.2016.
 */
public class Ogrenci {

    static List<String> list=new ArrayList();

    AdminIslemleri admin=new AdminIslemleri();

    Ders ders;

    public void ogrenciEkle() {

        Scanner ekle = new Scanner(System.in);
        if(list.size()<5) {

            System.out.print("Öğrenci Adı: ");
            String ad = ekle.next();
            list.add(ad);
            System.out.println("Ekleme basarili...\n");
        }else
            System.out.println("Ogrenci kontenjanı dolu.");

        admin.adminIslem();
    }

    public void ogrenciSil() {

        ders=new Ders();
        Scanner sil = new Scanner(System.in);
        System.out.print("Silinecek Öğrenci adı:");
        String silad=sil.next();

        int silid=list.indexOf(silad);
        list.remove(silad);
        try {
            if(!ders.dersler.get(silid).isEmpty())
                ders.dersler.remove(silid);
        }catch (IndexOutOfBoundsException i){}

        if(list.isEmpty()){
            System.out.println("Liste boş.Önce ekleme yapın...");
        }

        admin.adminIslem();
    }

    public void ogrenciListele() {
        ders=new Ders();
        Scanner kisino=new Scanner(System.in);
        if(!list.isEmpty()){

            for (int i = 0; i < list.size(); i++) {
                System.out.println(i+1 + ".Öğrenci : " + list.get(i));
            }
            try {
                System.out.print("Dersi görüntülenecek kişi no:");
                int no=kisino.nextInt();
                System.out.print(ders.dersler.get(no-1));

            }catch (IndexOutOfBoundsException i){}
            catch (InputMismatchException e){}
        }
        else
            System.out.println("Liste boş...");

        System.out.println();
        admin.adminIslem();
    }
}