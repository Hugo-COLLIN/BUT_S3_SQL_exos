import java.sql.*;

public class Exercice2
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded");

        String url = "jdbc:oracle:thin:@charlemagne.iutnc.univ-lorraine.fr:1521:infodb";
        Connection co = DriverManager.getConnection(url, args[0], args[1]);
        System.out.println("Successfully connected to the database :)");

        int type = ResultSet.TYPE_SCROLL_INSENSITIVE;
        int mode = ResultSet.CONCUR_UPDATABLE;
        Statement st = co.createStatement(type, mode);




        /*
        //show 1st element
        ResultSet rS = st.executeQuery("SELECT * FROM empUL");
        rS.next();
        show(rS);
         */

        //Show last element
        ResultSet rS = st.executeQuery("SELECT * FROM empUL");
        rS.last();
        show(rS);

        /*
        while(rS.next()) {
            if(rS.isLast()) {
                show(rS);
            }
        }

         */

        /*
        boolean suivant = true;
        ResultSet rSTrouve = null;
        while (rS != null)
        {
            rSTrouve = rS;
            suivant = rS.next();
            if (rS == null)
                show(rSTrouve);
        }
                 */





    }

    public static void show(ResultSet rS) throws SQLException {
        System.out.println(
                rS.getString(1) + "\t" +
                        rS.getString(2) + "\t" +
                        rS.getString(3) + "\t" +
                        rS.getString(4) + "\t" +
                        rS.getString(5) + "\t");
    }
}
