package data;

import java.io.Serializable;

/**
 * Deze klasse stelt een route tussen twee knooppunten op het fietsknooppuntennetwerk voor. In deze klasse is er sprake van een "start" en een
 * "stop" knooppunt. Dit is puur naamgeving. In werkelijkheid kan men uiteraard  de route in beide richtingen doorlopen.
 * @author Stijn Walcarius
 */
public class Route implements Serializable {

    private int routeId = -1;
    private Knooppunt startKnooppunt;
    private Knooppunt eindKnooppunt;
    private int aantalKm;
    private String info;

    /**
     * Constructor voor de klasse Route
     * @param routeId uniek identificatienummer van de route
     * @param startKnooppuntId start knooppunt van de route
     * @param eindKnooppuntId eind knooppunt van de route
     * @param aantalKm aantal km tussen beide knooppunten
     * @param info extra informatie over de route
     */
    public Route(int routeId, Knooppunt startKnooppuntId, Knooppunt eindKnooppuntId, int aantalKm, String info) {
        this.startKnooppunt = startKnooppuntId;
        this.eindKnooppunt = eindKnooppuntId;
        this.aantalKm = aantalKm;
        this.info = info;
        this.routeId = routeId;
    }

    /**
     * Geeft het aantal km terug
     * @return aantal km van de route tussen start en eind knooppunt.
     */
    public int getAantalKm() {
        return aantalKm;
    }


    /**
     * Geeft eindknooppunt terug
     * @return knooppunt dat einde voorstelt
     */
    public Knooppunt getEindKnooppunt() {
        return eindKnooppunt;
    }

    /**
     * Geeft extra informatie over de route terug
     * @return info over route
     */
    public String getInfo() {
        return info;
    }

    /**
     * Geeft uniek identificatienummer van route terug
     * @return uniek identificatienummer van route
     */
    public int getRouteId() {
        return routeId;
    }


    /**
     * Geeft startpunt van route terug.
     * @return startpunt
     */
    public Knooppunt getStartKnooppunt() {
        return startKnooppunt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Route other = (Route) obj;
        if (this.routeId != other.routeId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.routeId;
        return hash;
    }

    @Override
    public String toString() {
        return "Route "  + startKnooppunt + " -> " + eindKnooppunt;
    }



}
