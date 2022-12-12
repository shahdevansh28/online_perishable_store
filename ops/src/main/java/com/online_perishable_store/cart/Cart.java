package com.online_perishable_store.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    public Long cartid;
    @Column(name = "orderitemid")
    public Long orderItemId;
    @Column(name = "userid")
    public Long userId;
    public void setCartid(Long cartid) {
        this.cartid = cartid;
    }
    public Long getCartid() {
        return cartid;
    }
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }
    public Long getOrderItemId() {
        return orderItemId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return userId;
    }
    @Override
    public String toString() {
        return "cartid=" + cartid + ", userid=" + userId + ", orderItemId=" + orderItemId + ",";
    }
}
