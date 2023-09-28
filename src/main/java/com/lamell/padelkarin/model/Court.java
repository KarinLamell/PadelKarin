package com.lamell.padelkarin.model;


import jakarta.persistence.*;

@Entity
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courtId;

    private String courtName;

    private int numberOfPlayers;

    private long pricePerHourSEK;

    //Constructors

    public Court() {
    }

    public Court(int courtId, String courtName, int numberOfPlayers, long pricePerHourSEK) {
        this.courtId = courtId;
        this.courtName = courtName;
        this.numberOfPlayers = numberOfPlayers;
        this.pricePerHourSEK = pricePerHourSEK;
    }

    //Setters&Getters


    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public long getPricePerHourSEK() {
        return pricePerHourSEK;
    }

    public void setPricePerHourSEK(long pricePerHourSEK) {
        this.pricePerHourSEK = pricePerHourSEK;
    }
}
