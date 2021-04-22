package com.walmart.challenge.service;

import com.walmart.challenge.model.Customer;

public interface CustomerService {

    /**
     * @param customerId of the customer.
     * @return the customer.
     */
    Customer get(long customerId);

    /**
     * @param customer being created.
     * @return customer that was created.
     */
    Customer save(Customer customer);

    /**
     * @param customerId of the customer.
     * @param customer data that is being updated.
     * @return customer that was updated.
     */
    Customer partialUpdate(long customerId, Customer customer);
}
