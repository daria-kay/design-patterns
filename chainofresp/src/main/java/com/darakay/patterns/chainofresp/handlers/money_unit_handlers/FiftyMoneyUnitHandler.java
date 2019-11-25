package com.darakay.patterns.chainofresp.handlers.money_unit_handlers;

import com.darakay.patterns.chainofresp.handlers.BanknoteHandler;

public class FiftyMoneyUnitHandler extends MoneyUnitHandler {

    public FiftyMoneyUnitHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    int getNominal() {
        return 50;
    }
}
