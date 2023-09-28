package com.lamell.padelkarin.services;

import com.lamell.padelkarin.exceptions.ResourceNotFoundException;

import com.lamell.padelkarin.model.Timeslot;
import com.lamell.padelkarin.repositories.TimeslotRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Qualifier("timeslot")
@Service
public class TimeslotService implements TimeslotServiceInterface{

    @Autowired
    private TimeslotRepository timeslotRepository;

    private static final Logger logger = LogManager.getLogger(TimeslotService.class);


    @Override
    public Timeslot saveTimeslot(Timeslot timeslot) {
        return timeslotRepository.save(timeslot);
    }

    @Override
    public ResponseEntity<Timeslot> getAllTimeslots() {
        return (ResponseEntity<Timeslot>) timeslotRepository.findAll();
    }

    @Override
    public List<Timeslot> getAvailableTimeslots() {
        try {
            List<Timeslot> timeslots = new ArrayList<>();
            timeslotRepository.findAll().forEach(timeslot -> {
                if (timeslot.isAvailable()) {
                    timeslots.add(timeslot);
                }
            });
            return timeslots;
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public Timeslot getTimeslotById(int timeslotId) {
        Optional<Timeslot> timeslot = timeslotRepository.findById(timeslotId);
        if (timeslot.isPresent()) {
            return timeslot.get();
        } else {
            throw new ResourceNotFoundException("Slot-time", "Id", timeslot);
        }
    }

    @Override
    public Timeslot updateTimeslot(Timeslot timeslot, int timeslotId) {
        Timeslot s = timeslotRepository.findById(timeslotId).orElseThrow(()->new ResourceNotFoundException("Slot-time", "Id", timeslot));
        s.setSlotDate(timeslot.getSlotDate());
        s.setSlotTime(timeslot.getSlotTime());
        s.setAvailable(timeslot.isAvailable());
        timeslotRepository.save(s);
        return s;
    }

    @Override
    public void deleteTimeslot(int timeslotId) {

        timeslotRepository.findById(timeslotId).orElseThrow(()->new ResourceNotFoundException("Slot-time", "Id", timeslotId));
        timeslotRepository.deleteById(timeslotId);
    }
}
