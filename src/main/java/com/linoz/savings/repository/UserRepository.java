package com.linoz.savings.repository;

import com.linoz.savings.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by linoz on 2/15/21
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value="select u from #{#entityName} u where u.email= ?1")
    User findUserByEmail(String email);
}
