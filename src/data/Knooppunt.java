package data;

import java.io.Serializable;

/**
 * Deze klasse stelt een knooppunt van het fietsknooppuntennetwerk voor.
 * @author Stijn Walcarius
 */
public class Knooppunt implements Serializable{

    private int knooppuntId;
    private int nummerBord;
    private String gemeente;
    private String omschrijving;

    /**
     * Constructor van de klasse Knooppunt
     * @param knooppuntId uniek identificatienummer van knooppunt
     * @param nummerBord nummer vermeld op het bord
     * @param gemeente gemeente waar het knooppunt zich situeert
     * @param omschrijving extra info van het knooppunt
     */
    public Knooppunt(int knooppuntId, int nummerBord, String gemeente, String omschrijving) {
        this.knooppuntId = knooppuntId;
        this.nummerBord = nummerBord;
        this.gemeente = gemeente;
        this.omschrijving = omschrijving;
    }

    /**
     * Geeft de naam van de gemeente terug
     * @return naam van de gemeente
     */
    public String getGemeente() {
        return gemeente;
    }


    /**
     * Geeft het unieke identificatienummer van knooppunt terug
     * @return identificatienummer van knooppunt
     */
    public int getKnooppuntId() {
        return knooppuntId;
    }


    /**
     * Geeft het volgnummer van het bord terug
     * @return volgnummer van het bord
     */
    public int getNummerBord() {
        return nummerBord;
    }


    /**
     * Geeft extra informatie over knooppunt terug
     * @return omschrijving over knooppunt
     */
    public String getOmschrijving() {
        return omschrijving;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Knooppunt other = (Knooppunt) obj;
        if (this.knooppuntId != other.knooppuntId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.knooppuntId;
        return hash;
    }

    @Override
    public String toString() {
        return "Knooppunt   " +this.getNummerBord() +   "  [" + gemeente  +  " - " +this.getOmschrijving()    +" ]";
    }




}
