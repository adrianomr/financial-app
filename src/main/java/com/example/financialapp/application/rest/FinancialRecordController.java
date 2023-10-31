package com.example.financialapp.application.rest;

import com.example.financialapp.domain.model.FinancialRecord;
import com.example.financialapp.domain.usecases.AddFinancialRecordUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("financial-records")
@RequiredArgsConstructor
public class FinancialRecordController {

    private final AddFinancialRecordUseCase addFinancialRecordUseCase;

    @PostMapping
    public ResponseEntity createPost(@RequestBody FinancialRecord financialRecord){
        return ResponseEntity.ok(addFinancialRecordUseCase.execute(financialRecord));
    }

}
