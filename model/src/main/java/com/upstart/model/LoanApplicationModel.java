package com.upstart.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "loan_application")
@Data
public class LoanApplicationModel extends AbstractBaseModel {
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private AppUserModel applicant;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private LoanModel loan;
}
