package com.darakay.patterns.chainofresp.handlers;

public class TenDollarHandler extends BanknoteHandler {
    public TenDollarHandler(BanknoteHandler handler) {
        super(handler);
    }
}
