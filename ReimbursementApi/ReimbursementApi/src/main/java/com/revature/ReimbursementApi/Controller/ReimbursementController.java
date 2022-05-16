package com.revature.ReimbursementApi.Controller;


import com.revature.ReimbursementApi.Models.Reimbursement;
import com.revature.ReimbursementApi.Repos.ReimbursementRepo;
import com.revature.ReimbursementApi.Services.ReimbursementService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("reimbursements")
public class ReimbursementController {

    @Setter(onMethod =@__({@Autowired}) )
    private ReimbursementRepo reimbursementRepo;

    @Autowired
    private ReimbursementService reimbursementService;

    @GetMapping
    public ResponseEntity<List<Reimbursement>> getAllReimbursements() {
        return ResponseEntity.ok(reimbursementRepo.findAll());
    }

    @GetMapping(path="{id}") //reimbursements/{id}
    public ResponseEntity getReimbursementById(@PathVariable Integer reimbursementId) {

        return ResponseEntity.ok(reimbursementRepo.findById(reimbursementId));
    }

    @GetMapping(path="reimbursements/managers/{id}")
    public ResponseEntity getAllReimbursementsByManagerId(@PathVariable Integer managerId) {
        return ResponseEntity.ok(reimbursementRepo.findAllByManagerId(managerId));
    }

    @GetMapping(path="reimbursements/employees/{id}")
    public ResponseEntity getAllReimbursementsWithEmployeeId(@PathVariable Integer id) {
        return ResponseEntity.ok(reimbursementRepo.findAllByEmployeeId(id));
    }

    @PostMapping("new")
    public ResponseEntity addReimbursement(@RequestBody Reimbursement reimbursement) throws URISyntaxException {
        return reimbursementService.addReimbursement(reimbursement);
    }

    @PutMapping("reimbursements/{reimbursementId}")
    public void updateReimbursement(
            @RequestBody Reimbursement reimbursement,
            @PathVariable int reimbursementId
    ) {
        reimbursementService.updateReimbursement(reimbursement, reimbursementId);
    }


}
