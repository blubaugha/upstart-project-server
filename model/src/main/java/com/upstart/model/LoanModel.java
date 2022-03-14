package com.upstart.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@NoArgsConstructor
@Entity
@Table(name = "loan")
@Data
public class LoanModel extends AbstractBaseModel {
    @Column(nullable = false)
    BigDecimal annualPercentageRate;

    @Column(nullable = false)
    BigDecimal amount;
}
