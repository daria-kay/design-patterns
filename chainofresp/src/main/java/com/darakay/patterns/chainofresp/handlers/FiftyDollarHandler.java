package com.darakay.patterns.chainofresp.handlers;

public class FiftyDollarHandler extends BanknoteHandler {
    public FiftyDollarHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }
}
