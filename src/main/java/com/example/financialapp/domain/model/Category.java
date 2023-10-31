package com.example.financialapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Category {
    private String type;
    private String description;
    private BigDecimal total;

    public static Category of(FinancialRecord financialRecord) {
        var category = Category.builder()
                .type(financialRecord.getType().toString())
                .description(financialRecord.getCategory())
                .total(BigDecimal.ZERO)
                .build();
        return category;
    }

    public boolean isSameCategory(FinancialRecord financialRecord) {
        return (type+description)
                .equalsIgnoreCase(financialRecord.getType().toString()+financialRecord.getCategory());
    }

    public int compare(Category category) {
        var typeOrder = this.type.compareTo(category.type)*-1;
        if(typeOrder != 0)
            return typeOrder;
        return category.total.compareTo(this.total);
    }
}
