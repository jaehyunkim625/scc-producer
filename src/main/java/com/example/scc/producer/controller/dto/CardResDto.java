package com.example.scc.producer.controller.dto;

import lombok.ToString;

@ToString
public class CardResDto {
    private final long cardSeq;
    private final long cardNumber;
    private final long balance;
    private final String customerId;
    public CardResDto(long cardSeq, long cardNumber, long balance, String customerId) {
        this.cardSeq = cardSeq;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.customerId = customerId;
    }

    public long getCardSeq() {
        return cardSeq;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public long getBalance() {
        return balance;
    }

    public String getCustomerId() {
        return customerId;
    }
}
