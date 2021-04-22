package com.walmart.challenge.service;

import com.walmart.challenge.model.Order;
import com.walmart.challenge.model.OrderLine;

public interface OrderService {

    /**
     * Get an order.
     * @param orderId of the order to get.
     * @return the order.
     */
    Order get(long orderId);

    /**
     * Create a new order.
     * @param order to create.
     * @return Order that was created.
     */
    Order create(Order order);

    /**
     * @param orderId of the order associated to the order line.
     * @param itemId of the item  associated to the order line.
     * @param qty of items being added to the order line.
     * @return updated order line.
     */
    OrderLine addItem(long orderId, long itemId, long qty);

    /**
     * @param orderId of the order associated to the order line.
     * @param itemId of the item  associated to the order line.
     * @param qty of items being removed to the order line.
     * @return updated order line. null if the order line is deleted due to the qty being < 0.
     */
    OrderLine removeItem(long orderId, long itemId, long qty);
}
