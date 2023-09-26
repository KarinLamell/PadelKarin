package com.lamell.padelkarin.services;

import com.lamell.padelkarin.model.Timeslot;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeslotServiceInterface {

    Timeslot saveTimeslot(Timeslot timeslot);

    ResponseEntity<Timeslot> getAllTimeslots();

    List<Timeslot> getAvailableTimeslots();

    Timeslot getTimeslotById(int timeslotId);

    Timeslot updateTimeslot(Timeslot timeslot, int timeslotId);

    void deleteTimeslot(int timeslotId);
}
