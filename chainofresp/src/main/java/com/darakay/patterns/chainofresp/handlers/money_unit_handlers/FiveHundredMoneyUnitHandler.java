package com.darakay.patterns.chainofresp.handlers.money_unit_handlers;

import com.darakay.patterns.chainofresp.handlers.BanknoteHandler;

public class FiveHundredMoneyUnitHandler extends MoneyUnitHandler {

    public FiveHundredMoneyUnitHandler(BanknoteHandler next) {
        super(next);
    }

    @Override
    int getNominal() {
        return 500;
    }
}
