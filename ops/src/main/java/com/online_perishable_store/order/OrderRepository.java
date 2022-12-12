package com.online_perishable_store.order;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query("select o from Order o where o.userId=?1")
    List<Order> findAllOrderByUserId(Long userId);
}