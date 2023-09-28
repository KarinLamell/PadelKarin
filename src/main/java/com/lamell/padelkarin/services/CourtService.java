package com.lamell.padelkarin.services;

import com.lamell.padelkarin.exceptions.ResourceNotFoundException;
import com.lamell.padelkarin.model.Court;
import com.lamell.padelkarin.repositories.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Qualifier("court")
@Service
public class CourtService implements CourtServiceInterface{

    @Autowired
    private CourtRepository courtRepository;

    @Override
    public Court saveCourt(Court court) {
        return courtRepository.save(court);
    }

    @Override
    public List<Court> getAllCourts() {
        return courtRepository.findAll();
    }

    @Override
    public Court getCourtById(int courtId) {
        Optional<Court> court = courtRepository.findById(courtId);
        if (court.isPresent()) {
            return court.get();
        } else {
            throw new ResourceNotFoundException("Court", "Id", court);
        }
    }

    @Override
    public Court updateCourt(Court court, int courtId) {
        Court c = courtRepository.findById(courtId).orElseThrow(()->new ResourceNotFoundException("Court", "Id", court));
        c.setCourtName(court.getCourtName());
        c.setPricePerHourSEK(court.getPricePerHourSEK());
        c.setNumberOfPlayers(court.getNumberOfPlayers());
        courtRepository.save(c);
        return c;
    }

    @Override
    public void deleteCourt(int courtId) {
        courtRepository.findById(courtId).orElseThrow(()->new ResourceNotFoundException("Court", "Id", courtId));
        courtRepository.deleteById(courtId);
    }
}
