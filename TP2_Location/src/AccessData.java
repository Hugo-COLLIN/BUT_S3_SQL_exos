import java.sql.*;

public class AccessData
{
    private Connection co;
    private PreparedStatement pst;
    private String lastView;

    private final int TYPE = ResultSet.TYPE_SCROLL_INSENSITIVE;
    private final int MODE = ResultSet.CONCUR_UPDATABLE;

    public AccessData() throws ClassNotFoundException
    {

    }

    public String loadDriver() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return "Driver loaded";
    }

    public String connection(String lgn, String pwd) throws SQLException {
        String url = "jdbc:oracle:thin:@charlemagne.iutnc.univ-lorraine.fr:1521:infodb";
        this.co = DriverManager.getConnection(url, lgn, pwd);
        return "Successfully connected to the database :)";
    }

    public String listeVehic(String categ, String stDate, String endDate) throws SQLException
    {
        this.pst = this.co.prepareStatement("SELECT distinct Vehicule.no_imm, Vehicule.modele \n" +
                "FROM Vehicule, Dossier\n" +
                "WHERE code_categ = ?\n" +
                "    AND (date_retrait < ? OR dossier.date_retour > ?)\n" +
                "    AND Vehicule.no_imm = Dossier.no_imm",
                TYPE, MODE);

        /*this.pstSet(pst, new String[]{categ, stDate, endDate});*/
        pst.setString(1, categ);
        pst.setString(2, stDate);
        pst.setString(3, endDate);

        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rSMeta = rs.getMetaData();
        final int NUM = rSMeta.getColumnCount();

        StringBuilder sb = new StringBuilder();

        sb.append(showColsName(rSMeta, NUM));
        while (rs.next())
            sb.append(showRow(rs, NUM));
        return sb.toString();
    }

    public String majCal(String immat, String stDate, String endDate, int loc) throws SQLException
    {
        this.pst = this.co.prepareStatement("UPDATE Calendrier \n" +
                "SET paslibre = ?\n" +
                "WHERE no_imm = ?\n" +
                "    AND datejour BETWEEN ? AND ?", TYPE, MODE);

        if (loc == 1) pst.setString(1, "x");
        else pst.setNull(1, Types.VARCHAR);
        pst.setString(2, immat);
        pst.setString(3, stDate);
        pst.setString(4, endDate);


        pst.executeUpdate();
        return "Executed";
    }

    public void show() throws SQLException {
        Statement st = co.createStatement();
        ResultSet rS = st.executeQuery("SELECT * FROM Calendrier");
        System.out.println("Résultats : ");
        while (rS.next())
            System.out.println(
                    rS.getString(1) + "\t" +
                            rS.getString(2) + "\t" +
                            rS.getString(3) + "\t");
    }

    public String showRow(ResultSet rS, final int NUM) throws SQLException
    {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= NUM ; i ++)
            res.append(rS.getString(i) + "\t");
        res.append("\n");
        return res.toString();
    }

    public String showColsName(ResultSetMetaData rSMeta, final int NUM) throws SQLException
    {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= NUM ; i ++)
            res.append(rSMeta.getColumnName(i) + "\t");
        res.append("\n");
        return res.toString();
    }

    public void pstSet(PreparedStatement pst, Object[] params) throws SQLException
    {
        for (int i = 0 ; i < params.length ; i ++)
            pst.setObject(i, params[i]);
    }

    public Connection getCo() {
        return co;
    }

    @Override
    public String toString() {
        return "AccessData{" +
                "lastView='" + lastView + '\'' +
                '}';
    }
}
