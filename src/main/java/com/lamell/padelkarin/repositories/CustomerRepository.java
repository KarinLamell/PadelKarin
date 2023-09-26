package com.lamell.padelkarin.repositories;

import com.lamell.padelkarin.model.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("customer")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
