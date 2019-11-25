package com.darakay.patterns.chainofresp.handlers.money_unit_handlers;

import com.darakay.patterns.chainofresp.handlers.BanknoteHandler;

public class ThousandMoneyUnitHandler extends MoneyUnitHandler {

    public ThousandMoneyUnitHandler(BanknoteHandler next) {
        super(next);
    }

    @Override
    int getNominal() {
        return 1000;
    }
}
