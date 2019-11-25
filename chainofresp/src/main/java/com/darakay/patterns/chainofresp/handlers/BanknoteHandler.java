package com.darakay.patterns.chainofresp.handlers;

public class BanknoteHandler {

    private final BanknoteHandler next;

    public BanknoteHandler(BanknoteHandler next) {
        this.next = next;
    }

    public boolean validate(String banknote) {
        return next != null && next.validate(banknote);
    }
}
