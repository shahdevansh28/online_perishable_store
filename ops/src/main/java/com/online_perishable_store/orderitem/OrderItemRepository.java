package com.online_perishable_store.orderitem;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    
    @Query("select i.productId from OrderItem i where i.orderId= ?1")
    List<Long> findAllOrderItemsById(Long orderId);
}