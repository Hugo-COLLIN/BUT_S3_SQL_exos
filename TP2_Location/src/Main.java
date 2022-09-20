import java.sql.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AccessData ad = new AccessData(args[0], args[1]);

        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose an action :\n1. List of available vehicles");
        int choice = sc.nextInt();
        //int choice = 1;
        sc.nextLine();

        switch (choice)
        {
            case 1:
                System.out.print("--- List of available vehicles ---");
                System.out.print("Category :");
                String c = sc.nextLine();
                System.out.print("Start date (DD/MM/YYYY) :");
                String stDate = sc.nextLine();
                System.out.print("End date (DD/MM/YYYY) :");
                String endDate = sc.nextLine();
                System.out.println(ad.listeVehic(c,stDate,endDate));
        }
    }

}
