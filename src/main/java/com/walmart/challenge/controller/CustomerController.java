package com.walmart.challenge.controller;

import com.walmart.challenge.model.Customer;
import com.walmart.challenge.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private final CustomerService _customerService;

    public CustomerController(CustomerService customerService) {
        _customerService = customerService;
    }

    @GetMapping("/customer")
    public ResponseEntity<Customer> get(@RequestParam(value = "customerId") long customerId) {
        return ResponseEntity.ok(_customerService.get(customerId));
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.ok(_customerService.save(customer));
    }

    @PatchMapping("/customer")
    public ResponseEntity<Customer> partialUpdate(@RequestParam(value = "customerId") long customerId,
                                                  @RequestBody Customer customer) {
        return ResponseEntity.ok(_customerService.partialUpdate(customerId, customer));
    }
}
