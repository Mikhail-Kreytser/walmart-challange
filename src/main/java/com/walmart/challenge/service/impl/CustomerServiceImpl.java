package com.walmart.challenge.service.impl;

import com.walmart.challenge.model.Customer;
import com.walmart.challenge.repository.CustomerRepository;
import com.walmart.challenge.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository _customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        _customerRepository = customerRepository;
    }

    @Override
    public Customer get(long customerId) {
        Optional<Customer> maybeCustomer = _customerRepository.findById(customerId);
        if (maybeCustomer.isPresent()) {
            return maybeCustomer.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Customer with customerId: %d is not found", customerId));
    }

    @Override
    public Customer save(Customer customer) {
        customer.removeId();
        return _customerRepository.save(customer);
    }

    @Override
    public Customer partialUpdate(long customerId, Customer customer) {
        Customer existingCustomer = this.get(customerId);
        existingCustomer.setName(customer.getName());
        return _customerRepository.save(existingCustomer);
    }
}
