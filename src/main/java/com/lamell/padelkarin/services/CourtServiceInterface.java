package com.lamell.padelkarin.services;

import com.lamell.padelkarin.model.Court;

import java.util.List;

public interface CourtServiceInterface {

    Court saveCourt(Court court);

    List<Court> getAllCourts();

    Court getCourtById(int courtId);

    Court updateCourt(Court court, int courtId);

    void deleteCourt(int courtId);
}
