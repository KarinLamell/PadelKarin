package com.lamell.padelkarin.services;

import com.lamell.padelkarin.exceptions.ResourceNotFoundException;
import com.lamell.padelkarin.model.Booking;
import com.lamell.padelkarin.model.Timeslot;
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

    @Autowired
    private TimeslotService timeslotService;

    @Autowired
    private CustomerService customerService;


    public BookingService() {
    }

    @Override
    public Booking saveBooking(Booking booking) {
        for (Timeslot time: booking.getTimeslot()
             ) {
            time.setAvailable(false);
            timeslotService.saveTimeslot(time);
        }

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingById(int customerId) {
        List<Booking> bookings = bookingRepository.getBookingsByCustomer_CustomerId(customerId);

            return bookings;
        }


    @Override
    public Booking updateBooking(Booking booking, int bookingId) {
        Booking b = bookingRepository.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking", "Id", booking));
        b.setTotalBookingPriceSEK(booking.getTotalBookingPriceSEK());
        b.setCourt(booking.getCourt());
        b.setTimeslot(booking.getTimeslot());
        bookingRepository.save(b);
        return b;
    }

    @Override
    public void deleteBooking(int bookingId) {

        bookingRepository.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking", "Id", bookingId));
        bookingRepository.deleteById(bookingId);
    }
}
