package com.tablease.menu.domain.VO;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class MonetaryValue {
    protected final BigDecimal amount;

    protected MonetaryValue(BigDecimal amount) {
        Objects.requireNonNull(amount, "Amount cannot be null");
        validate(amount);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    protected abstract void validate(BigDecimal amount);

    public boolean isGreaterThan(MonetaryValue other) {
        return this.amount.compareTo(other.amount) > 0;
    }

    public boolean isLessThan(MonetaryValue other) {
        return this.amount.compareTo(other.amount) < 0;
    }

    public boolean isZero() {
        return amount.compareTo(BigDecimal.ZERO) == 0;
    }

}
