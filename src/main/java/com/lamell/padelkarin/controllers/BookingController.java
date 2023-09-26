package com.lamell.padelkarin.controllers;

import com.lamell.padelkarin.model.Booking;
import com.lamell.padelkarin.services.BookingService;
import com.lamell.padelkarin.services.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v5")
public class BookingController {

    private BookingService bookingService;

    private CustomerService customerService;

    public BookingController() {
    }

    private static final Logger logger = LogManager.getLogger(BookingService.class);

    @PostMapping("/bookings")
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
        logger.info("User registered new booking");
        return new ResponseEntity<>(bookingService.saveBooking(booking), HttpStatus.CREATED);
    }

    @GetMapping("/mybookings/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") int customerId){
        return new ResponseEntity<>(bookingService.getBookingById(customerId), HttpStatus.CREATED);
    }

    @PutMapping("/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") int bookingId, @RequestBody Booking booking){
        logger.info("Admin updated booking");
        return ResponseEntity.ok(bookingService.updateBooking(booking, bookingId));
    }

    @DeleteMapping("/deletebooking/{id}")
    ResponseEntity<String>deleteBooking(int bookingId){
        bookingService.deleteBooking(bookingId);
        logger.info("Admin deleted booking");
        return new ResponseEntity<>("Booking deleted", HttpStatus.OK);
    }


}
