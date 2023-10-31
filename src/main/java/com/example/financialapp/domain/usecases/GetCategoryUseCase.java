package com.example.financialapp.domain.usecases;

import com.example.financialapp.domain.model.Categories;
import com.example.financialapp.infra.database.FinancialRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class GetCategoryUseCase {

    private final FinancialRecordRepository repository;

    public Categories execute(LocalDate startDate, LocalDate endDate) {
        var categories = new Categories();
        var financialRecords = repository.findAllByDateBetween(startDate, endDate);
        financialRecords.stream()
                .forEach(financialRecord -> categories.updateCategories(financialRecord));
        return categories.ordered();
    }
}
