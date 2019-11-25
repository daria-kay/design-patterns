package com.darakay.patterns.chainofresp.handlers;

import com.darakay.patterns.chainofresp.ResultOfCashing;
import com.darakay.patterns.chainofresp.banknote.Banknote;
import com.darakay.patterns.chainofresp.banknote.CurrencyType;

public class EuroHandler extends BanknoteHandler {
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
    protected ResultOfCashing defineCurrency(int sum, String currency) {
        if("eur".equalsIgnoreCase(currency)){
            super.setNextChainOfCashingHandlers();
            return super.cashOutConcreteCurrency(new ResultOfCashing(sum, Banknote.withCurrency(CurrencyType.EURO)));
        }
        return super.defineCurrency(sum, currency);
    }
}
