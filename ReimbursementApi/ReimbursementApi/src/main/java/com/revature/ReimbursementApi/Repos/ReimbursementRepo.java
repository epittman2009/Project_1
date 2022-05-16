package com.revature.ReimbursementApi.Repos;

import com.revature.ReimbursementApi.Models.Manager;
import com.revature.ReimbursementApi.Models.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementRepo extends JpaRepository<Reimbursement, Integer> {

    List<Reimbursement> findAllByManagerId(@Param("id") int id);
    List<Reimbursement> findAllByEmployeeId(@Param("id") int id);
//    List<Reimbursement> findAllReimbursements (@Param("reimbursement") Reimbursement reimbursement);

//    List<Reimbursement> findAllReimbursements(Reimbursement reimbursement);

    @Modifying
    @Query("update Reimbursement r set r.status = ?1, r.manager = ?2 where r.id = ?3")
    void updateReimbursementById(String status, Manager manager, int id);
}
