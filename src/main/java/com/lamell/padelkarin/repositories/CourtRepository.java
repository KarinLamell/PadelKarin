package com.lamell.padelkarin.repositories;


import com.lamell.padelkarin.model.Court;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("court")
@Repository
public interface CourtRepository extends JpaRepository<Court, Integer> {
}
