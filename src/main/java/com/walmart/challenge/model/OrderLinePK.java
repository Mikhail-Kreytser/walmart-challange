package com.walmart.challenge.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class OrderLinePK implements Serializable {
    private long orderId;
    private long itemId;

    public OrderLinePK() {
    }

    public OrderLinePK(long orderId, long itemId) {
        this.itemId = itemId;
        this.orderId = orderId;
    }

    public long getItemId() {
        return itemId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLinePK that = (OrderLinePK) o;
        return orderId == that.orderId && itemId == that.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemId);
    }
}