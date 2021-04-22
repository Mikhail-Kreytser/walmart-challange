package com.walmart.challenge.service.impl;

import com.walmart.challenge.model.Order;
import com.walmart.challenge.model.OrderLine;
import com.walmart.challenge.model.OrderLinePK;
import com.walmart.challenge.repository.CustomerRepository;
import com.walmart.challenge.repository.ItemRepository;
import com.walmart.challenge.repository.OrderLineRepository;
import com.walmart.challenge.repository.OrderRepository;
import com.walmart.challenge.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final CustomerRepository _customerRepository;
    private final ItemRepository _itemRepository;
    private final OrderRepository _orderRepository;
    private final OrderLineRepository _orderLineRepository;

    public OrderServiceImpl(
            CustomerRepository customerRepository,
            ItemRepository itemRepository,
            OrderRepository orderRepository,
            OrderLineRepository orderLineRepository) {

        _customerRepository = customerRepository;
        _itemRepository = itemRepository;
        _orderRepository = orderRepository;
        _orderLineRepository = orderLineRepository;
    }

    @Override
    public Order get(long orderId) {
        Optional<Order> maybeOrder = _orderRepository.findById(orderId);
        if (maybeOrder.isPresent()) {
            return maybeOrder.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Order with orderId: %d is not found", orderId));
    }

    @Override
    public Order create(Order order) {
        boolean validCustomer = _customerRepository.existsById(order.getCustomerId());
        if (validCustomer) {
            order.removeId();
            return _orderRepository.save(order);
        }

        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
                String.format("Customer: %d is invalid", order.getCustomerId()));
    }

    @Override
    public OrderLine addItem(long orderId, long itemId, long qty) {
        boolean validOrder = _orderRepository.existsById(orderId);
        boolean validItem = _itemRepository.existsById(itemId);

        // Make sure order and item ids exist
        if (validOrder && validItem) {
            OrderLinePK orderLinePk = new OrderLinePK(orderId, itemId);

            // Find an existing order line or generate a new order line
            OrderLine orderLine = _orderLineRepository.findById(orderLinePk)
                    .orElse(new OrderLine(orderLinePk, 0));

            // Update new qty
            long newQty = orderLine.getQty() + qty;
            orderLine.setQty(newQty);
            return _orderLineRepository.save(orderLine);
        }

        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
                String.format("OrderLine with orderId: %d and itemId: %d is invalid", orderId, itemId));
    }

    @Override
    public OrderLine removeItem(long orderId, long itemId, long qty) {
        OrderLinePK orderLinePk = new OrderLinePK(orderId, itemId);

        // Find an existing order line
        Optional<OrderLine> maybeOrderLine = _orderLineRepository.findById(orderLinePk);
        if (maybeOrderLine.isPresent()) {
            // Delete the order line if the new qty is 0 or less
            // Update the order line qty if qty is grater then 0
            long newQty = maybeOrderLine.get().getQty() - qty;
            if(newQty <= 0) {
                _orderLineRepository.deleteById(orderLinePk);
                return null;
            } else {
                maybeOrderLine.get().setQty(newQty);
                return _orderLineRepository.save(maybeOrderLine.get());
            }
        }

        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
                String.format("OrderLine with orderId: %d and itemId: %d is invalid", orderId, itemId));
    }
}
