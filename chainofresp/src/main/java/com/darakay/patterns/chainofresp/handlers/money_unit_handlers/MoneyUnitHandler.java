package com.darakay.patterns.chainofresp.handlers.money_unit_handlers;

import com.darakay.patterns.chainofresp.ResultOfCashing;
import com.darakay.patterns.chainofresp.handlers.BanknoteHandler;

abstract class MoneyUnitHandler extends BanknoteHandler {

    MoneyUnitHandler(BanknoteHandler next) {
        super(next);
    }

    @Override
    public ResultOfCashing cashOutConcreteCurrency(ResultOfCashing resultOfCashing) {
        resultOfCashing.put(getNominal());
        return super.cashOutConcreteCurrency(resultOfCashing);
    }

    abstract int getNominal();
}
