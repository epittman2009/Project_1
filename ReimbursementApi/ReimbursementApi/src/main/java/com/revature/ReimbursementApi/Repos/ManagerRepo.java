package com.revature.ReimbursementApi.Repos;

import com.revature.ReimbursementApi.Models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepo extends JpaRepository<Manager, Integer> {

   List<Manager> findByManagerId(int managerId);
}
