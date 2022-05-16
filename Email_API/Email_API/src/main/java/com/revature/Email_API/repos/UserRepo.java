package com.revature.Email_API.repos;


import com.revature.Email_API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("From User where userId = :userId")
    List<User> findByUserId(@Param("userId") int userId);

    @Query("From User where email = :email")
    List<User> findByEmail(@Param("email") String email);
}
