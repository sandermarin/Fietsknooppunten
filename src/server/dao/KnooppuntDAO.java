package server.dao;

import data.Knooppunt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *  Deze klasse bevat databasemethodes mbt de klasse Knooppunt.
 * @author Stijn Walcarius
 */
public class KnooppuntDAO {

    /**
     * Deze methode haalt alle knooppunten uit de database op.
     * @return list met objecten van de klasse Knooppunt
     * @throws SQLException database-foutmelding
     */
    public static List<Knooppunt> laadAlleKnooppunten() throws SQLException {
        List<Knooppunt> knooppunten = new ArrayList<Knooppunt>();
        String sql = "Select * FROM knooppunt";
        Connection con = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = con.prepareCall(sql);

        ResultSet res = ps.executeQuery();
        while (res.next()) {
            int idKnooppunt = res.getInt(1);
            int knooppuntnummer = res.getInt(2);
            String gemeente = res.getString(3);
            String omschrijving = res.getString(4);
            Knooppunt knooppunt = new Knooppunt(idKnooppunt, knooppuntnummer, gemeente, omschrijving);
            knooppunten.add(knooppunt);
        }

        return knooppunten;
    }

    /**
     * Deze methode haalt ahv idVanKnooppunt de informatie van een specifiek knooppunt op.
     * @param idKnooppunt uniek identificatienummer van knooppunt. Dit is niet het vermelde nummer op het bord zelf.
     * @return object van de klasse Knooppunt
     * @throws SQLException Database foutmelding
     */
    public static Knooppunt haalKnooppuntOp(int idKnooppunt) throws SQLException {
        String sql = "Select * FROM knooppunt WHERE idKnooppunt=?";
        Connection con = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = con.prepareCall(sql);
        ps.setInt(1, idKnooppunt);

        ResultSet res = ps.executeQuery();

        while (res.next()) {
            int knooppuntnummer = res.getInt(2);
            String gemeente = res.getString(3);
            String omschrijving = res.getString(4);
            Knooppunt k = new Knooppunt(idKnooppunt, knooppuntnummer, gemeente, omschrijving);
            return k;
        }

        return null;
    }

}
