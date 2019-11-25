package com.darakay.patterns.chainofresp.handlers;

public class TenRubleHandler extends BanknoteHandler {

    public TenRubleHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }
}
