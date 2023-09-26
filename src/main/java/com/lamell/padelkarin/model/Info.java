package com.lamell.padelkarin.model;

import jakarta.persistence.*;

@Entity
@Table
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int infoId;

    private String infotext;

    public Info() {
    }

    public Info(int infoId, String infotext) {
        this.infoId = infoId;
        this.infotext = infotext;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getInfotext() {
        return infotext;
    }

    public void setInfotext(String infotext) {
        this.infotext = infotext;
    }
}
