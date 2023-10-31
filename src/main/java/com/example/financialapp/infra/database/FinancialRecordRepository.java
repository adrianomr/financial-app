package com.example.financialapp.infra.database;

import com.example.financialapp.domain.model.FinancialRecord;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface FinancialRecordRepository extends CrudRepository<FinancialRecord, UUID> {
    List<FinancialRecord> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
}
