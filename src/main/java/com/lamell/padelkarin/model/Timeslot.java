package com.lamell.padelkarin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class Timeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timeslotId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date slotDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HHmm")
    private String slotTime;

    private boolean available;

    //Constructors

    public Timeslot() {
    }

    public Timeslot(int timeslotId, Date slotDate, String slotTime, boolean available) {
        this.timeslotId = timeslotId;
        this.slotDate = slotDate;
        this.slotTime = slotTime;
        this.available = available;
    }

    //Getters&Setters


    public int getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    public Date getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(Date slotDate) {
        this.slotDate = slotDate;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}