package com.example.demo.domain.valueObjects;

import lombok.Value;

@Value
public class Money {
    double amount;

    public Money(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    public Money add(Money other) {
        return new Money(this.amount + other.amount);
    }

    public Money subtract(Money other) {
        if (this.amount < other.amount) {
            throw new IllegalArgumentException("Resulting amount cannot be negative");
        }
        return new Money(this.amount - other.amount);
    }
}
