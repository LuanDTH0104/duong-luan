package com.org.clockshop.repository;

import com.org.clockshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM [user] WHERE user_account = :userAccount",nativeQuery = true)
    User getUserByUserAccount(@Param("userAccount") String userAccount);
}
