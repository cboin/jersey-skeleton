package fr.iutinfo.skeleton.api;

import java.util.Date;

/**
 * Created by Pierre on 29/03/2016.
 */
public class EventDto {
    private int duree;
    private int heure;
    private Date date;

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
