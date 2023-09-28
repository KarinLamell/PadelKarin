package com.lamell.padelkarin.model;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    private long TotalBookingPriceSEK;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Court court;

    @OneToMany
    private List<Timeslot> timeslot;

    //Constructors


    public Booking() {
    }

    public Booking(int bookingId, long totalBookingPriceSEK, Customer customer, Court court, List<Timeslot> timeslot) {
        this.bookingId = bookingId;
        TotalBookingPriceSEK = totalBookingPriceSEK;
        this.customer = customer;
        this.court = court;
        this.timeslot = timeslot;
    }

    //Getters&Setters


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public long getTotalBookingPriceSEK() {

        return timeslot.size()*court.getPricePerHourSEK();
    }

    public void setTotalBookingPriceSEK(long totalBookingPriceSEK) {
        TotalBookingPriceSEK = totalBookingPriceSEK;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public List<Timeslot> getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(List<Timeslot> timeslot) {
        this.timeslot = timeslot;
    }
}
