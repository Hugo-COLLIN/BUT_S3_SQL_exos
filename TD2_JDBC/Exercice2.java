import java.sql.*;

public class Exercice2
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded");

        String url = "jdbc:oracle:thin:@charlemagne.iutnc.univ-lorraine.fr:1521:infodb";
        Connection co = DriverManager.getConnection(url, args[0], args[1]);
        System.out.println("Successfully connected to the database :)");

        Statement st = co.createStatement();

        ResultSet rS = st.executeQuery("SELECT * FROM empUL");

        /*
        rS.next(); //show 1st element
        System.out.println(
                rS.getString(1) + "\t" +
                        rS.getString(2) + "\t" +
                        rS.getString(3) + "\t" +
                        rS.getString(4) + "\t" +
                        rS.getString(5) + "\t");
        */

        /*
        boolean trouve = false;
        /*
        while (!trouve)
        {
            rSTrouve = rS;
            if (!rS.next()) trouve = true;
        }*/

        /*
        ResultSet rSTrouve = null;
        do if (!trouve) rSTrouve = rS;
        while (trouve = rS.next());

        System.out.println(
                rSTrouve.getString(1) + "\t" +
                        rSTrouve.getString(2) + "\t" +
                        rSTrouve.getString(3) + "\t" +
                        rSTrouve.getString(4) + "\t" +
                        rSTrouve.getString(5) + "\t");
                     */
    }
}
