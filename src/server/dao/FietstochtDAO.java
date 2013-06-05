/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dao;

import data.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Deze klasse bevat databasemethodes mbt de klasse Fietstocht.
 * @author stijn.walcarius
 */
public class FietstochtDAO {

    /**
     * Deze methode haalt alle aanwezige fietstochten uit de database op. Van elke fietstocht worden ook de resp. routes opgehaald.
     * @return list met objecten van de klasse Fietstocht
     * @throws SQLException
     */
    public static List<Fietstocht> haalAlleFietstochtenOp() throws SQLException {
        List<Fietstocht> fietstochten = new ArrayList<Fietstocht>();

        String sql = "SELECT * FROM fietstocht";
        Connection con = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet res = ps.executeQuery(sql);
        while (res.next()) {
            int fietstochtId = res.getInt(1);
            String naamFietstocht = res.getString(2);
            String info = res.getString(4);
            int startKnooppuntId = res.getInt(5);
            Fietstocht tocht = new Fietstocht(naamFietstocht, info);
            tocht.setFietstochtId(fietstochtId);
            tocht.setStartKnooppunt(KnooppuntDAO.haalKnooppuntOp(startKnooppuntId));
            fietstochten.add(tocht);

            //routes uit fietstocht ophalen
            RouteDAO.haalRoutesUitFietstochtOp(tocht);
        }

        return fietstochten;
    }

    /**
     * Deze methode slaat een fietstocht in de database op. Van elke fietstocht wordt naast de algemene informatie, ook de bijhorende routes tussen de knooppunten  opgeslagen.
     * @param fietstocht object van de klasse Fietstocht
     * @throws SQLException Database foutmelding
     */
    public static void bewaarFietstocht(Fietstocht fietstocht) throws SQLException {
        //zelf aan te vullen!
        //maak gebruik van transacties.
    }
}
