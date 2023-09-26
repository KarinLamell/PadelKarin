package com.lamell.padelkarin.services;

import com.lamell.padelkarin.exceptions.ResourceNotFoundException;
import com.lamell.padelkarin.model.Customer;
import com.lamell.padelkarin.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Qualifier("customer")
@Service
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new ResourceNotFoundException("Customer", "Id", customer);
        }
    }

    @Override
    public Customer updateCustomer(Customer customer, int customerId) {
        Customer c = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", customer));
        c.setFirstName((customer.getFirstName()));
        c.setLastName((customer.getLastName()));
        c.setUserName((customer.getUserName()));
        c.setStreet((customer.getStreet()));
        c.setPostalCode((customer.getPostalCode()));
        c.setCity((customer.getCity()));
        c.setEMail((customer.getEMail()));
        c.setPhone((customer.getPhone()));
        customerRepository.save(c);
        return c;
    }

    @Override
    public void deleteCustomer(int customerId) {
        Customer c = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer", "Id", customerId));
    }
}
