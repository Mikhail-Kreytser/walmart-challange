package com.walmart.challenge.controller;

import com.walmart.challenge.model.Order;
import com.walmart.challenge.model.OrderLine;
import com.walmart.challenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class OrderController {

    @Autowired
    private final OrderService _orderService;

    public OrderController(OrderService customerService) {
        _orderService = customerService;
    }

    @GetMapping("/order")
    public ResponseEntity<Order> get(@RequestParam(value = "orderId") long orderId) {
        return ResponseEntity.ok(_orderService.get(orderId));
    }

    @PostMapping("/order")
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return ResponseEntity.ok(_orderService.create(order));
    }

    @PutMapping("/order/addItem")
    public ResponseEntity<OrderLine> addItem(@RequestParam(value = "orderId") long orderId,
                                             @RequestParam(value = "itemId") long itemId,
                                             @RequestBody long qty) {
        return ResponseEntity.ok(_orderService.addItem(orderId, itemId, qty));
    }

    @PutMapping("/order/removeItem")
    public ResponseEntity<OrderLine> removeItem(@RequestParam(value = "orderId") long orderId,
                                                @RequestParam(value = "itemId") long itemId,
                                                @RequestBody long qty) {
        OrderLine orderLine = _orderService.removeItem(orderId, itemId, qty);
        if (orderLine != null) {
            return ResponseEntity.ok(orderLine);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
}
