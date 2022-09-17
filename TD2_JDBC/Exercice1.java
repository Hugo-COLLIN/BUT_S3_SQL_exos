import java.sql.*;

public class Exercice1
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded");

        String url = "jdbc:oracle:thin:@charlemagne.iutnc.univ-lorraine.fr:1521:infodb";
        Connection co = DriverManager.getConnection(url, args[0], args[1]);
        System.out.println("Database connected");

        Statement st = co.createStatement();

        /*
        boolean createAndFill = st.execute("CREATE TABLE empUL (NUMEMP NUMBER PRIMARY KEY,\n" +
                "NOMEMP VARCHAR2(30), PRENOMEMP VARCHAR2(30)," +
                "EMPLOI VARCHAR2(30)," +
                "SALAIRE NUMBER(8,2))" +
                "insert into empUL values (1,'Bidon','Dindon','PROGRAMMEUER',21000)" +
                "insert into empUL values (2,'Lepine','David','PROGRAMMEUER',45000)" +
                "insert into empUL values (3,'Valente','Olivier','PROGRAMMEUER',45000)" +
                "insert into empUL values (4,'Patoche','Alain','PROGRAMMEUER',45000)" +
                "insert into empUL values (5,'Proulx','William','PROGRAMMEUER',45000)" +
                "insert into empUL values (6,'Paquette','Nathalie','FINANCES',35000)" +
                "insert into empUL values (7,'Poitras','Clara','FINANCES',35000)" +
                "insert into empUL values (9,'Lechat','Remi','FINANCES',35000)");

         */


        int update1 = st.executeUpdate("UPDATE EmpUl\n" +
                "SET salaire = 52000\n" +
                "WHERE nomemp = 'Lepine'\n" +
                "AND prenomEmp = 'David'");

        int update2 = st.executeUpdate("UPDATE EmpUl\n" +
                "SET salaire = 50000\n" +
                "WHERE nomemp = 'Valente'\n" +
                "AND prenomEmp = 'Olivier'");

        ResultSet rS = st.executeQuery("SELECT * FROM empUL");
        System.out.println("Résultats : ");
        while (rS.next())
            System.out.println(
                    rS.getString(1) + "\t" +
                    rS.getString(2) + "\t" +
                    rS.getString(3) + "\t" +
                    rS.getString(4) + "\t" +
                    rS.getString(5) + "\t");
    }
}
