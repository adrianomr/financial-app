package com.example.financialapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Categories {
    private List<Category> categories;
    private BigDecimal total;

    public Categories() {
        this.categories = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }

    public void updateCategories(FinancialRecord financialRecord) {
        var category = categories.stream()
                .filter(category1 -> category1.isSameCategory(financialRecord))
                .findFirst()
                .orElseGet(() -> newCategory(financialRecord));
        category.setTotal(category.getTotal().add(financialRecord.getValue()));
    }

    private Category newCategory(FinancialRecord financialRecord) {
        var category = Category.of(financialRecord);
        categories.add(category);
        return category;
    }

    public Categories ordered() {
        categories = categories.stream().sorted((o1, o2) -> o1.compare(o2)).toList();
        return this;
    }
}
