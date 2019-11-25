package com.darakay.patterns.chainofresp.handlers;

import com.darakay.patterns.chainofresp.banknote.Banknote;
import com.darakay.patterns.chainofresp.banknote.CurrencyType;

public class EuroHandler extends CurrencyHandler {
    public EuroHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean validate(String banknote) {
        if(banknote.matches("[0-9]+ eur"))
            return true;
        return super.validate(banknote);
    }

    @Override
    protected Banknote.Builder getBanknoteBuilder(String currency) {
        if("eur".equalsIgnoreCase(currency)){
            super.buildChainOfCashingHandlers();
            return Banknote.withCurrency(CurrencyType.EURO);
        }
        return super.getBanknoteBuilder(currency);
    }
}
