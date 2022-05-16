package com.revature.ReimbursementApi.Models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Reimbursements")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Reimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "reimbursementID", columnDefinition = "AUTO_INCREMENT")
    private int reimbursementId;

    @Column(name = "dateSubmitted")
    private Date dateSubmitted;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private int amount;

    @Column(name = "status")
    private String status = "pending";

    @Column(name = "employeeId")
    private int employeeId;

    @Column(name = "managerId")
    private Integer managerId;



    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="employee_Id", referencedColumnName = "employeeId")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="manager_Id", referencedColumnName = "managerId")
    private Manager manager;
}
