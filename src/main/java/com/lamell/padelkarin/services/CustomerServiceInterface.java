package com.lamell.padelkarin.services;

import com.lamell.padelkarin.model.Customer;

import java.util.List;

public interface CustomerServiceInterface {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(int customerId);

    Customer updateCustomer(Customer customer, int customerId);

    void deleteCustomer(int customerId);
}
