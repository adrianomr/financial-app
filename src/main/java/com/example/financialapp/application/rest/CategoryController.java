package com.example.financialapp.application.rest;

import com.example.financialapp.domain.model.FinancialRecord;
import com.example.financialapp.domain.usecases.AddFinancialRecordUseCase;
import com.example.financialapp.domain.usecases.GetCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final GetCategoryUseCase getCategoryUseCase;

    @GetMapping
    public ResponseEntity createPost(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return ResponseEntity.ok(getCategoryUseCase.execute(startDate, endDate));
    }

}
