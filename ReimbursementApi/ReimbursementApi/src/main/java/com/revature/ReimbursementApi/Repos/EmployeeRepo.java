package com.revature.ReimbursementApi.Repos;

import com.revature.ReimbursementApi.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    /**
     * Finds using employee ID
     * @param employeeId
     * @return
     */
    Employee findByEmployeeId(@Param("employeeId") int employeeId);

//    List<Employee> findAllEmployeeId(int employeeId);

}
