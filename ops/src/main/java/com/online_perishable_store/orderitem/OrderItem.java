package com.online_perishable_store.orderitem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderitem")
public class OrderItem {
    @Id
    @GeneratedValue
    public Long orderitemid;
    @Column(name = "productid")
    public Long productId;
    @Column(name = "itemquantity")
    public Long itemQuantity;
    @Column(name = "orderid")
    public Long orderId;

    public void setOrderitemid(Long orderitemid) {
        this.orderitemid = orderitemid;
    }
    public Long getOrderitemid() {
        return orderitemid;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getProductId() {
        return productId;
    }
    public void setItemQuantity(Long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    public Long getItemQuantity() {
        return itemQuantity;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getOrderId() {
        return orderId;
    }
    @Override
    public String toString() {
        return "orderitemid {"+orderitemid+" productId{"+productId+" itemQuantity="+itemQuantity+" orderId{"+orderId;
    }
}
