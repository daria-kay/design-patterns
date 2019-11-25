package com.darakay.patterns.chainofresp.handlers;

import com.darakay.patterns.chainofresp.ResultOfCashing;
import com.darakay.patterns.chainofresp.banknote.Banknote;
import com.darakay.patterns.chainofresp.banknote.CurrencyType;

public class RubleHandler extends BanknoteHandler {

    private static final CurrencyType RUBLE = CurrencyType.RUBLE;

    public RubleHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean validate(String banknote) {
        if(banknote.matches("[0-9]+ rub"))
            return true;
        return super.validate(banknote);
    }

    @Override
    protected ResultOfCashing defineCurrency(int sum, String currency) {
        if("rub".equalsIgnoreCase(currency)){
            super.setNextChainOfCashingHandlers();
            return super.cashOutConcreteCurrency(new ResultOfCashing(sum, Banknote.withCurrency(CurrencyType.RUBLE)));
        }
        return super.defineCurrency(sum, currency);
    }
}
