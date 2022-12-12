package com.online_perishable_store.cart;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    @Query("select c.orderItemId from Cart c where c.userId = ?1")
    List<Long> findAllByUserId(Long userId);

    @Query("select c from Cart c where c.userId = ?1")
    List<Cart> findAllCartByUserId(Long userId);
    // @Query("delete from Cart c where c.userId = ?1")
    // void deleteAllByUserId(Long userId);
}