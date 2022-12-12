package com.online_perishable_store.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
// import org.springframework.Query;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.email = ?1")
    User findByEmailAddress(String email);
    
}
