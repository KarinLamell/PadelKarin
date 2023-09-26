package com.lamell.padelkarin.controllers;

import com.lamell.padelkarin.model.Timeslot;
import com.lamell.padelkarin.services.CourtService;
import com.lamell.padelkarin.services.TimeslotService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v5")
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    public TimeslotController(TimeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }

    private static final Logger logger = LogManager.getLogger(TimeslotService.class);

    @GetMapping("/availability")
    public ResponseEntity<Timeslot> getAllTimeslots(){
        return timeslotService.getAllTimeslots();
    }


}
