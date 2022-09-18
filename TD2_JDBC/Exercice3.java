import java.sql.*;

public class Exercice3
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded");

        String url = "jdbc:oracle:thin:@charlemagne.iutnc.univ-lorraine.fr:1521:infodb";
        Connection co = DriverManager.getConnection(url, args[0], args[1]);
        System.out.println("Successfully connected to the database :)");


        //3.1
        //https://mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
        //PreparedStatement prepSt = co.prepareStatement("INSERT INTO empUL (numemp, nomemp, prenomemp, emploi, salaire) VALUES (?,?,?,?,?)");

        /*
        prepSt.setInt(1, 10);
        prepSt.setString(2, "Mori");
        prepSt.setString(3, "Enrico");
        prepSt.setString(4, "FINANCES");
        prepSt.setInt(5, 10);
         */
        /*
        prepSt.setInt(1, 11);
        prepSt.setString(2, "Blu");
        prepSt.setString(3, "Shine");
        prepSt.setString(4, "FINANCES");
        prepSt.setInt(5, 51500);
        */

        //3.2
        /*
        PreparedStatement prepSt = co.prepareStatement("UPDATE empUL SET salaire = ? WHERE numemp = ?");
        prepSt.setString(1, "65000");
        prepSt.setInt(2, 1);
        */

        /*prepSt.executeUpdate(); //3.1 and 3.2
        System.out.println("Operation performed");*/

        int type = ResultSet.TYPE_SCROLL_INSENSITIVE;
        int mode = ResultSet.CONCUR_UPDATABLE;
        PreparedStatement prepSt = co.prepareStatement("SELECT * FROM empUL WHERE emploi = ?", type, mode);
        prepSt.setString(1, "FINANCES");

        ResultSet rS = prepSt.executeQuery();
        ResultSetMetaData rSMeta = rS.getMetaData();

        final int NUM = rSMeta.getColumnCount();
        //while (rS.next()) showRow(rS, NUM);

        rS.afterLast();
        while (rS.previous()) showRow(rS, NUM);

        co.close();
    }

    public static void showRow(ResultSet rS, final int NUM) throws SQLException
    {
        for (int i = 1; i <= NUM ; i ++)
            System.out.print(rS.getString(i) + "\t");
        System.out.println("");
    }
}
