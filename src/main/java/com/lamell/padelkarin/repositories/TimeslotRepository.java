package com.lamell.padelkarin.repositories;

import com.lamell.padelkarin.model.Timeslot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("Timeslot")
@Repository
public interface TimeslotRepository extends JpaRepository<Timeslot, Integer> {
}
