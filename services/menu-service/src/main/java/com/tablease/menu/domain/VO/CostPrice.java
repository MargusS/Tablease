package com.tablease.menu.domain.VO;

import java.math.BigDecimal;

public class CostPrice extends MonetaryValue {

    public CostPrice(BigDecimal amount) {
        super(amount);
    }

    @Override
    protected void validate(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
    }
}
