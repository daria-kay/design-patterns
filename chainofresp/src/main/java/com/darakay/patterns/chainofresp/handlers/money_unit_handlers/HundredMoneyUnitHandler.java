package com.darakay.patterns.chainofresp.handlers.money_unit_handlers;

import com.darakay.patterns.chainofresp.handlers.BanknoteHandler;

public class HundredMoneyUnitHandler extends MoneyUnitHandler {

    public HundredMoneyUnitHandler(BanknoteHandler next) {
        super(next);
    }

    @Override
    int getNominal() {
        return 100;
    }
}
