package com.revature.ReimbursementApi.Services;

import com.revature.ReimbursementApi.Models.Employee;
import com.revature.ReimbursementApi.Models.Manager;
import com.revature.ReimbursementApi.Models.Reimbursement;
import com.revature.ReimbursementApi.Repos.EmployeeRepo;
import com.revature.ReimbursementApi.Repos.ManagerRepo;
import com.revature.ReimbursementApi.Repos.ReimbursementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ReimbursementService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private ReimbursementRepo reimbursementRepo;

    public ReimbursementService(EmployeeRepo employeeRepo, ManagerRepo managerRepo) {
        this.employeeRepo = employeeRepo;
        this.managerRepo = managerRepo;
    }

    public EmployeeRepo getEmployeeRepository() {
        return employeeRepo;
    }

    public ManagerRepo getManagerRepository() {
        return managerRepo;
    }

//    public List<Reimbursement> getAllReimbursements(Reimbursement reimbursement) {
//        List<Reimbursement> reimbursements = reimbursementRepo.findAllReimbursements();
//    }

    public List<Employee> findByEmployeeId(int employeeId) {
        List<Employee> er = Collections.singletonList(employeeRepo.findByEmployeeId(employeeId));
        return er;
    }

    public List<Manager> findByManagerId(int managerId) {
        List<Manager> mr = managerRepo.findByManagerId(managerId);
        return mr;
    }

    public ResponseEntity addReimbursement(Reimbursement reimbursement) throws URISyntaxException {
        int employeeId = reimbursement.getEmployeeId();
        List<Employee> checkUser = Collections.singletonList(employeeRepo.findByEmployeeId(employeeId));
        reimbursementRepo.save(reimbursement);
        return ResponseEntity.created(new URI("http://localhost/reimbursements/" + reimbursement.getReimbursementId())).build();
    }

    public void updateReimbursement(Reimbursement reimbursement, int id) {

        Manager managerId = (Manager) managerRepo.findByManagerId(id);
        Employee employeeId = employeeRepo.findByEmployeeId(id);


        String status = reimbursement.getStatus();


        reimbursementRepo.updateReimbursementById(status, managerId, id);


    }
}
