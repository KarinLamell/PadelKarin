package com.lamell.padelkarin.services;

import com.lamell.padelkarin.exceptions.ResourceNotFoundException;
import com.lamell.padelkarin.model.Booking;
import com.lamell.padelkarin.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Qualifier("booking")
@Service
public class BookingService implements BookingServiceInterface{

    @Autowired
    private BookingRepository bookingRepository;

    public BookingService() {
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(int bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            return booking.get();
        } else {
            throw new ResourceNotFoundException("Booking", "Id", booking);
        }
    }

    @Override
    public Booking updateBooking(Booking booking, int bookingId) {
        Booking b = bookingRepository.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking", "Id", booking));
        b.setTotalBookingPriceSEK(booking.getTotalBookingPriceSEK());
        b.setCourt(b.getCourt());
        b.setTimeslot(booking.getTimeslot());
        bookingRepository.save(b);
        return b;
    }

    @Override
    public void deleteBooking(int bookingId) {

        Booking b = bookingRepository.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking", "Id", bookingId));
    }
}
