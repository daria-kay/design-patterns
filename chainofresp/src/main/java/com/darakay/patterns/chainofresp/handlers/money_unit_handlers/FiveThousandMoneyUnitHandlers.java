package com.darakay.patterns.chainofresp.handlers.money_unit_handlers;

import com.darakay.patterns.chainofresp.handlers.BanknoteHandler;

public class FiveThousandMoneyUnitHandlers extends MoneyUnitHandler {

    public FiveThousandMoneyUnitHandlers(BanknoteHandler next) {
        super(next);
    }

    @Override
    int getNominal() {
        return 5000;
    }
}
