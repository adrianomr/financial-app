package com.example.financialapp.domain.usecases;

import com.example.financialapp.domain.model.FinancialRecord;
import com.example.financialapp.infra.database.FinancialRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class AddFinancialRecordUseCase {

    private final FinancialRecordRepository repository;

    public FinancialRecord execute(FinancialRecord financialRecord) {
        financialRecord.setId(UUID.randomUUID());
        return repository.save(financialRecord);
    }
}
