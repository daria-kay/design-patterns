package com.darakay.patterns.chainofresp.handlers;

import com.darakay.patterns.chainofresp.handlers.money_unit_handlers.*;

public class CurrencyHandler extends BanknoteHandler {

    public CurrencyHandler(BanknoteHandler next) {
        super(next);
    }

    void buildChainOfCashingHandlers(){
        BanknoteHandler handler = new FiftyMoneyUnitHandler(null);
        handler = new HundredMoneyUnitHandler(handler);
        handler = new FiveHundredMoneyUnitHandler(handler);
        handler = new ThousandMoneyUnitHandler(handler);
        handler = new FiveThousandMoneyUnitHandlers(handler);
        super.setNext(handler);
    }
}
