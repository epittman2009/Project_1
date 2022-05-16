package com.revature.Email_API.repos;

import com.revature.Email_API.models.Email;
import com.revature.Email_API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepo extends JpaRepository<Email, Integer> {

    @Query("From Email where emailId = :emailId")
    List<Email> findByEmailId(@Param("emailId") int emailId);
}
