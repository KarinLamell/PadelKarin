package com.lamell.padelkarin.controllers;

import com.lamell.padelkarin.model.Court;
import com.lamell.padelkarin.services.CourtService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v5")
public class CourtController {
    @Autowired
    private CourtService courtService;

    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

    private static final Logger logger = LogManager.getLogger(CourtController.class);

    @GetMapping("/courts")
    public List<Court> getAllCourts() {
        return courtService.getAllCourts();
    }

    @PutMapping("/updateinfo")
    public ResponseEntity<Court> updateCourt(@RequestBody Court court){
        logger.info("Admin updated court");
        return ResponseEntity.ok(courtService.updateCourt(court, court.getCourtId()));
    }

    @DeleteMapping("deletecourt/{id}")
    public ResponseEntity<String> deleteCourt(@PathVariable("id") int courtId){
        courtService.deleteCourt(courtId);
        logger.info("Admin deleted court");
        return new ResponseEntity<>(("Court deleted!"), HttpStatus.OK);
    }
}
