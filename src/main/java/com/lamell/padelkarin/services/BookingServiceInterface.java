package com.lamell.padelkarin.services;

import com.lamell.padelkarin.model.Booking;

import java.util.List;

public interface BookingServiceInterface {

    Booking saveBooking(Booking booking);

    List<Booking> getAllBookings();

    List<Booking> getBookingById(int customerId);

    Booking updateBooking(Booking booking, int bookingId);

    void deleteBooking(int bookingId);
}
