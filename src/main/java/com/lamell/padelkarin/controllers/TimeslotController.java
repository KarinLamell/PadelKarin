package com.lamell.padelkarin.controllers;

import com.lamell.padelkarin.model.Timeslot;
import com.lamell.padelkarin.services.TimeslotService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v5")
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    public TimeslotController(TimeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }

    private static final Logger logger = LogManager.getLogger(TimeslotController.class);

    @GetMapping("/availability")
    public Collection<Timeslot> getAvailableTimeslots(){
        return timeslotService.getAvailableTimeslots();
    }


}
