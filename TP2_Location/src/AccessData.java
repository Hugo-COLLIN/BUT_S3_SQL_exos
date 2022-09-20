import java.sql.*;

public class AccessData
{
    private Connection co;
    private String lastView;

    private int TYPE = ResultSet.TYPE_SCROLL_INSENSITIVE;
    private int MODE = ResultSet.CONCUR_UPDATABLE;

    public AccessData(String lgn, String pwd) throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded");

        String url = "jdbc:oracle:thin:@charlemagne.iutnc.univ-lorraine.fr:1521:infodb";
        this.co = DriverManager.getConnection(url, lgn, pwd);
        System.out.println("Successfully connected to the database :)");
    }

    public String listeVehic(String categ, String stDate, String endDate) throws SQLException
    {
        PreparedStatement pst = this.co.prepareStatement("SELECT distinct Vehicule.no_imm, Vehicule.modele \n" +
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

    public void pstSet(PreparedStatement pst, Object params[]) throws SQLException
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
