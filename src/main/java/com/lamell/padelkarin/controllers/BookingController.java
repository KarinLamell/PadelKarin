package com.lamell.padelkarin.controllers;

import com.lamell.padelkarin.model.Booking;
import com.lamell.padelkarin.services.BookingService;
import com.lamell.padelkarin.services.CustomerService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v5")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    public BookingController() {
    }



    private static final Logger logger = LogManager.getLogger(BookingController.class);

    @PostMapping("/booking")
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
        logger.info("User registered new booking");
        return new ResponseEntity<>(bookingService.saveBooking(booking), HttpStatus.CREATED);
    }



    @GetMapping("/mybookings/{id}")
    public ResponseEntity<List<Booking>> getBookingById(@PathVariable("id") int customerId){
        return new ResponseEntity<>(bookingService.getBookingById(customerId), HttpStatus.CREATED);
    }

    @GetMapping("allbookings")
    public List<Booking>getAllBookings(){
        return bookingService.getAllBookings();
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
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>("Booking deleted!", HttpStatus.OK);
    }


}
