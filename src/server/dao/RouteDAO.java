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
 * Deze klasse bevat databasemethodes mbt de klasse Route.
 * @author Stijn Walcarius
 */
public class RouteDAO {

    /**
     * Deze methode haalt alle routes vertrekkende vanuit een welbepaald knooppunt op. Het doorgegeven knooppunt wordt als startpunt van de opgehaalde route
     * ingesteld.
     * @param idKnooppunt identificatienummer van knooppunt
     * @return list met objecten van de klasse Route
     * @throws SQLException Database foutmelding
     */
    public static List<Route> haalRoutesVanuitKnooppuntOp(int idKnooppunt) throws SQLException {
        List<Route> routes = new ArrayList<Route>();
        String sql = "Select * FROM Route WHERE startKnooppuntId=? OR eindKnooppuntId=?";
        Connection con = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, idKnooppunt);
        ps.setInt(2, idKnooppunt);
        ResultSet res = ps.executeQuery();

        while (res.next()) {
            int idRoute = res.getInt(1);
            int startKnooppuntId = res.getInt(2);
            int eindKnooppuntId = res.getInt(3);
            int aantalKm = res.getInt(4);
            String info = res.getString(5);

            Route r = maakRoute(idKnooppunt, idRoute, startKnooppuntId, eindKnooppuntId, aantalKm, info);
            routes.add(r);
        }

        return routes;
    }

    private static Route maakRoute(int referentieKnooppuntId, int idRoute, int startKnooppuntId, int eindKnooppuntId, int aantalKm, String info) throws SQLException {
        Knooppunt startKnooppunt = KnooppuntDAO.haalKnooppuntOp(startKnooppuntId);
        Knooppunt eindKnooppunt = KnooppuntDAO.haalKnooppuntOp(eindKnooppuntId);

        Route r = null;
        if (startKnooppunt.getKnooppuntId() == referentieKnooppuntId) {
            r = new Route(idRoute, startKnooppunt, eindKnooppunt, aantalKm, info);
        } else {
            r = new Route(idRoute, eindKnooppunt, startKnooppunt, aantalKm, info);
        }
        return r;

    }

    /**
     * Deze methode haalt alle routes van een fietstocht op. De routes worden aanéénsluitend opgehaald: het eindknooppunt van een route is het startknooppunt van de volgende route.
     * @param tocht De fietstocht waarvan de routes moeten opgehaald worden.
     * @throws SQLException Database foutmelding
     */
    public static void haalRoutesUitFietstochtOp(Fietstocht tocht) throws SQLException {
        String sql = "SELECT route.idRoute, route.startKnooppuntId, route.eindKnooppuntId, route.aantalKm, route.info "
                + "FROM route, routesinfietstocht WHERE route.idRoute = routesinfietstocht.idRoute "
                + "AND routesinfietstocht.idFietstocht = " + tocht.getFietstochtId();

        Connection con = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet res = ps.executeQuery(sql);

        int startReferentiepuntId = tocht.getStartKnooppunt().getKnooppuntId();
        while (res.next()) {
            int idRoute = res.getInt(1);
            int startKnooppuntId = res.getInt(2);
            int eindKnooppuntId = res.getInt(3);
            int aantalKm = res.getInt(4);
            String info = res.getString(5);

            Route r = maakRoute(startReferentiepuntId, idRoute, startKnooppuntId, eindKnooppuntId, aantalKm, info);
            tocht.voegRouteToe(r);
            startReferentiepuntId = eindKnooppuntId;
        }
    }

}
