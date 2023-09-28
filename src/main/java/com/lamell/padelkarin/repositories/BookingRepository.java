package com.lamell.padelkarin.repositories;

import com.lamell.padelkarin.model.Booking;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("booking")
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    public List<Booking> getBookingsByCustomer_CustomerId(int customerId);
}
