import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by MUSAB on 4.10.2016.
 */
public class Main {

    public static void main(String[] args) {

        Main main=new Main();
        main.loginSecim();

    }

    void loginSecim(){

        Scanner secim=new Scanner(System.in);
        AdminIslemleri adminIslemleri=new AdminIslemleri();

        System.out.println("Admin işlemleri---- 1\nÖğrenci işlemleri-- 2");
        System.out.print("Seçiminiz: ");

        try {
            int sayi = secim.nextInt();

            switch (sayi){
                case 1:
                    adminIslemleri.adminLogin();
                    break;
                case 2:
                    OgrenciIslemleri ogrenciIslemleri=new OgrenciIslemleri();
                    ogrenciIslemleri.ogreciLogin();
                    break;
                default:
                    System.out.print("\nYalnızca 1 ve 2 yi seçebilirsiniz.\n");
                    loginSecim();
                    break;
            }
        }catch (InputMismatchException ime){
            System.out.println("\nLütfen geçerli seçim yapınız...");
            loginSecim();
        }
    }
}