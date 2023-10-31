package com.example.financialapp;

import com.example.financialapp.domain.enums.FinancialRecordType;
import com.example.financialapp.domain.model.FinancialRecord;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FiancialRecordPool {
    public static FinancialRecord buildSalaryRecord(){
        return FinancialRecord.builder()
                .type(FinancialRecordType.INCOME)
                .value(BigDecimal.valueOf(10))
                .description("Salary")
                .category("Salary")
                .date(LocalDate.of(2023,10,12))
                .build();
    }
    public static FinancialRecord buildCdbRecord(){
        return FinancialRecord.builder()
                .type(FinancialRecordType.INCOME)
                .value(BigDecimal.valueOf(105.1))
                .description("CDB")
                .category("Investments")
                .date(LocalDate.of(2023,10,15))
                .build();
    }
    public static FinancialRecord buildIceCreamRecord(){
        return FinancialRecord.builder()
                .type(FinancialRecordType.EXPENSE)
                .value(BigDecimal.valueOf(15.1))
                .description("Ice Cream")
                .category("Food")
                .date(LocalDate.of(2023,10,17))
                .build();
    }
}
