package com.lamell.padelkarin.repositories;

import com.lamell.padelkarin.model.Info;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("info")
@Repository
public interface InfoRepository extends JpaRepository<Info, Integer> {
}
