package com.darakay.patterns.chainofresp.handlers.money_unit_handlers;

import com.darakay.patterns.chainofresp.IntermediateResult;
import com.darakay.patterns.chainofresp.handlers.BanknoteHandler;

abstract class MoneyUnitHandler extends BanknoteHandler {

    MoneyUnitHandler(BanknoteHandler next) {
        super(next);
    }

    @Override
    public IntermediateResult cashOut(IntermediateResult intermediateResult) {
        intermediateResult.put(getNominal());
        return super.cashOut(intermediateResult);
    }

    abstract int getNominal();
}
