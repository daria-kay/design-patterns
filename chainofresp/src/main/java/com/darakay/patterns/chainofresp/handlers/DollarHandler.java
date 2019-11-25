package com.darakay.patterns.chainofresp.handlers;

import com.darakay.patterns.chainofresp.ResultOfCashing;
import com.darakay.patterns.chainofresp.banknote.Banknote;
import com.darakay.patterns.chainofresp.banknote.CurrencyType;

public class DollarHandler extends BanknoteHandler {
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
    protected ResultOfCashing defineCurrency(int sum, String currency) {
        if("$".equalsIgnoreCase(currency)) {
            super.setNextChainOfCashingHandlers();
            return super.cashOutConcreteCurrency(new ResultOfCashing(sum, Banknote.withCurrency(CurrencyType.DOLLAR)));
        }
        return super.defineCurrency(sum, currency);
    }
}
