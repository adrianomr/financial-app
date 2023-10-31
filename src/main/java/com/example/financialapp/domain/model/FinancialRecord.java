package com.example.financialapp.domain.model;

import com.example.financialapp.domain.enums.FinancialRecordType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class FinancialRecord {
    @Id
    private UUID id;
    @Column
    private BigDecimal value;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private LocalDate date;
    @Column
    @Enumerated(EnumType.STRING)
    private FinancialRecordType type;
}
