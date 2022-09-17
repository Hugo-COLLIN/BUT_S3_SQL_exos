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


        ResultSet rS = st.executeQuery("SELECT nomemp, prenomemp, salaire FROM empUL");

        ResultSetMetaData rSMeta = rS.getMetaData();
        final int COL_NUM = rSMeta.getColumnCount();
        showColsName(rSMeta, COL_NUM);

        //rS.next(); //show 1st element
        //rS.last(); //Show last element
        //show(rS);


        int count = 0;
        boolean trouve = false;
        while(rS.next() && !trouve)
            if (++ count == 3)
                showRows(rS, COL_NUM);



    }

    public static void showRows(ResultSet rS, final int NUM) throws SQLException
    {
        for (int i = 1; i <= NUM ; i ++)
            System.out.print(rS.getString(i) + "\t");
        System.out.println("");
    }

    public static void showColsName(ResultSetMetaData rSMeta, final int NUM) throws SQLException
    {
        for (int i = 1; i <= NUM ; i ++)
            System.out.print(rSMeta.getColumnName(i) + "\t");
        System.out.println("");
    }
}
