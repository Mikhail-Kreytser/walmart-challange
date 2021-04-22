package com.walmart.challenge.repository;

import com.walmart.challenge.model.OrderLine;
import com.walmart.challenge.model.OrderLinePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, OrderLinePK> {

}
