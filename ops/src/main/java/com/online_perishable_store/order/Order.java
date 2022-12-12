package com.online_perishable_store.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cust_order")
public class Order {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    public Long orderid;
    @Column(name="userid")
    public Long userId;
    @Column(name="total_amount")
    public Long totalAmount;
    @Column(name="order_date")
    public Date orderDate;
    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }
    public Long getOrderid() {
        return orderid;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return userId;
    }
    public Long getTotalAmount(){
        return totalAmount;
    }
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    @Override
    public String toString() {
        return "{ orderid: " + orderid + ", userid: " + userId+ ",totalAmount: "+totalAmount + ",orderDate: " + orderDate+"}";
    }
}
