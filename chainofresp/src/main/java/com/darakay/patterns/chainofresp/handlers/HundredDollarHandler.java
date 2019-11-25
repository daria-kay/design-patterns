package com.darakay.patterns.chainofresp.handlers;

public class HundredDollarHandler extends BanknoteHandler {
    public HundredDollarHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }
}
