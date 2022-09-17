import java.sql.*;
public class SimpleJDBC
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        //Reprendre joueur
        //1. Charger le driver JDBC
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded");
        //2. Etablir une connexion
        String url = "jdbc:oracle:thin:@charlemagne.iutnc.univ-lorraine.fr:1521:infodb";
        Connection co = DriverManager.getConnection(url, args[0], args[1]);
        System.out.println("Database conected");
        //3. Creer une instruction
        Statement st = co.createStatement();
        //4. Exec une instruction
        ResultSet rS = st.executeQuery("SELECT prenom, nom FROM Joueur");
        //5. Parcourir les resultats
        while (rS.next())
            System.out.println(rS.getString(1) + "\t" + rS.getString(2));
    }
}
