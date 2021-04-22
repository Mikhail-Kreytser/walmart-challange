package com.walmart.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderLines")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderLine {
    @EmbeddedId
    private OrderLinePK orderLinePK;

    @Column(name = "qty")
    private long qty;

    public OrderLine() {
    }

    public OrderLine(OrderLinePK orderLinePK, long qty){
        this.orderLinePK = orderLinePK;
        this.qty = qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }

    public void setOrderLinePK(OrderLinePK orderLinePK) {
        this.orderLinePK = orderLinePK;
    }

    public long getQty() {
        return qty;
    }

    public OrderLinePK getOrderLinePK() {
        return orderLinePK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return qty == orderLine.qty && Objects.equals(orderLinePK, orderLine.orderLinePK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLinePK, qty);
    }
}
