package com.tablease.menu.domain.VO;

import java.math.BigDecimal;

public class SellingPrice extends MonetaryValue {

    public SellingPrice(BigDecimal amount) {
        super(amount);
    }

    @Override
    protected void validate(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Selling price cannot be negative");
        }
    }
}
