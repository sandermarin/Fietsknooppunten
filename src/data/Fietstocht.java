/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Deze klasse stelt een fietstocht op basis van het fietsknooppuntennetwerk voor.
 * @author Stijn Walcarius
 */
public class Fietstocht implements Serializable{

    private int fietstochtId = -1;
    private Knooppunt startKnooppunt;
    private String naamFietstocht;
    private String info;
    private List<Route> routes = new ArrayList<Route>();

    /**
     * Constructor voor de klasse Fietstocht
     * @param naamFietstocht de naam van een fietstocht gegeven door de ontwerper
     * @param info extra informatie over de fietstocht
     */
    public Fietstocht(String naamFietstocht, String info) {
        this.naamFietstocht = naamFietstocht;
        this.info = info;
    }

    /**
     * Constructor voor de klasse Fietstocht
     * @param fietstochtId uniek identificatienummer van fietstocht
     * @param naamFietstocht naam van de fietstocht
     * @param info extra informatie mbt fietstocht
     */
    public Fietstocht(int fietstochtId, String naamFietstocht, String info) {
        this.fietstochtId = fietstochtId;
        this.naamFietstocht = naamFietstocht;
        this.info = info;
    }

    /**
     * Geeft het start knooppunt terug
     * @return object van de klasse Knooppunt
     */
    public Knooppunt getStartKnooppunt() {
        return startKnooppunt;
    }

    /**
     * Geeft het uniek identificatienummer van de fietstocht terug
     * @return identificatienummer van fietstocht
     */
    public int getFietstochtId() {
        return fietstochtId;
    }

    /**
     * Geeft algemene informatie over de fietstocht terug.
     * @return de informatie van de fietstocht
     */
    public String getInfo() {
        return info;
    }

    /**
     * Geeft de naam van de fietstocht terug
     * @return naam van fietstocht.
     */
    public String getNaamFietstocht() {
        return naamFietstocht;
    }


    /**
     * Geeft alle routes van een fietstocht opeenvolgend terug.
     * @return list met objecten van de klasse Route
     */
    public List<Route> getRoutes() {
        return routes;
    }

    /**
     * Geeft het totale aantal km terug.
     * @return de som van alle afstanden van de routes die bij deze fietstocht horen
     */
    public int getTotaalAantalKm() {
        int totaal = 0;
        for (Route route : routes) {
            totaal += route.getAantalKm();
        }
        return totaal;
    }

    /**
     * Stelt een knooppunt als startplaats in
     * @param startKnooppunt knooppunt dat de startplaats voorstelt van de fietstocht
     */
    public void setStartKnooppunt(Knooppunt startKnooppunt) {
        this.startKnooppunt = startKnooppunt;
    }

    /**
     * Stelt het identificatienummer van een fietstocht in
     * @param fietstochtId identificatienummer van fietstocht
     */
    public void setFietstochtId(int fietstochtId) {
        this.fietstochtId = fietstochtId;
    }

    /**
     * Stelt algemene informatie over de fietstocht in
     * @param info informatie over de fietstocht
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Stelt de naam van de fietstocht in
     * @param naamFietstocht de naam van de fietstocht
     */
    public void setNaamFietstocht(String naamFietstocht) {
        this.naamFietstocht = naamFietstocht;
    }

    /**
     * Voegt een route aan de fietstocht toe. Deze route wordt achteraan de lijst met routes toegevoegd. Er is geen controle of het startpunt van de
     * toegevoegde route overeen komt het eindpunt van de laatst aanwezige route.
     * @param route nieuwe route toe te voegen aan fietstocht.
     */
    public void voegRouteToe(Route route) {
        if (!routes.contains(route)) {
            routes.add(route);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fietstocht other = (Fietstocht) obj;
        if (this.fietstochtId != other.fietstochtId) {
            return false;
        }
        if ((this.naamFietstocht == null) ? (other.naamFietstocht != null) : !this.naamFietstocht.equals(other.naamFietstocht)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.fietstochtId;
        hash = 43 * hash + (this.naamFietstocht != null ? this.naamFietstocht.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return naamFietstocht;
    }
}
