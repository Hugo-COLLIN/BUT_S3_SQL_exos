import java.sql.*;

public class Exercice3
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded");

        String url = "jdbc:oracle:thin:@charlemagne.iutnc.univ-lorraine.fr:1521:infodb";
        Connection co = DriverManager.getConnection(url, args[0], args[1]);
        System.out.println("Successfully connected to the database :)");

        PreparedStatement prepSt = co.prepareStatement("INSERT INTO empUL (numemp, nomemp, prenomemp, emploi, salaire) VALUES (?,?,?,?,?)");

        //prepSt.setString("(10, 'Mori', 'Enrico', 'FINANCES', 31000)");

        //https://mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
        /*
        prepSt.setInt(1, 10);
        prepSt.setString(2, "Mori");
        prepSt.setString(3, "Enrico");
        prepSt.setString(4, "FINANCES");
        prepSt.setInt(5, 10);
         */

        prepSt.setInt(1, 11);
        prepSt.setString(2, "Blu");
        prepSt.setString(3, "Shine");
        prepSt.setString(4, "FINANCES");
        prepSt.setInt(5, 51500);
        prepSt.executeUpdate();

        System.out.println("Insert OK");
        co.close();
    }
}
