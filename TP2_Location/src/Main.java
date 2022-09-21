import java.sql.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AccessData ad = new AccessData(args[0], args[1]);

        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose an action :\n1. List of available vehicles\n2. MAJ booking calendar");
        int choice = sc.nextInt();
        //int choice = 1;
        sc.nextLine();

        String p1,p2,p3;
        switch (choice)
        {
            case 1:
                System.out.print("--- List of available vehicles ---");
                System.out.print("Category :");
                p1 = sc.nextLine();
                System.out.print("Start date (DD/MM/YYYY) :");
                p2 = sc.nextLine();
                System.out.print("End date (DD/MM/YYYY) :");
                p3 = sc.nextLine();
                System.out.println(ad.listeVehic(p1,p2,p3));
                break;
            case 2:
                System.out.print("Start date (DD/MM/YYYY) :");
                p1 = sc.nextLine();
                System.out.print("End date (DD/MM/YYYY) :");
                p2 = sc.nextLine();
                System.out.print("Immat :");
                p3 = sc.nextLine();
                System.out.println(ad.majCal(p1, p2, p3));
                ad.show();
                break;
            default:
                break;
        }
    }

}
