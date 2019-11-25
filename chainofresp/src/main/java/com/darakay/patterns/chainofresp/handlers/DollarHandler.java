package com.darakay.patterns.chainofresp.handlers;

import com.darakay.patterns.chainofresp.banknote.Banknote;
import com.darakay.patterns.chainofresp.banknote.CurrencyType;

public class DollarHandler extends CurrencyHandler {
    public DollarHandler(BanknoteHandler handler) {
        super(handler);
    }

    @Override
    public boolean validate(String banknote) {
        if(banknote.matches("[0-9]+ \\$"))
            return true;
        return super.validate(banknote);
    }

    @Override
    protected Banknote.Builder getBanknoteBuilder(String currency) {
        if("$".equalsIgnoreCase(currency)) {
            super.buildChainOfCashingHandlers();
            return Banknote.withCurrency(CurrencyType.DOLLAR);
        }
        return super.getBanknoteBuilder(currency);
    }
}
