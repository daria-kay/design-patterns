package com.darakay.patterns.chainofresp.handlers;

import com.darakay.patterns.chainofresp.IntermediateResult;
import com.darakay.patterns.chainofresp.banknote.Banknote;

import java.util.List;
import java.util.Objects;

public abstract class BanknoteHandler {

    private BanknoteHandler next;

    public BanknoteHandler(BanknoteHandler next) {
        this.next = next;
    }

    public boolean validate(String banknote) {
        return next != null && next.validate(banknote);
    }

    public final List<Banknote> cashOut(String cashRequest){
        String[] queries = cashRequest.split(" ");
        Banknote.Builder banknoteBuilder = getBanknoteBuilder(queries[1]);
        int sum = Integer.parseInt(queries[0]);
        return cashOut(new IntermediateResult(sum, banknoteBuilder)).getBanknotes();
    }

    final void setNext(BanknoteHandler handler){
        this.next = handler;
    }

    protected Banknote.Builder getBanknoteBuilder(String currency){
        if(Objects.nonNull(next))
            return next.getBanknoteBuilder(currency);
        else throw new IllegalArgumentException();
    }

    protected IntermediateResult cashOut(IntermediateResult intermediateResult)  {
        if(Objects.nonNull(this.next)){
            return next.cashOut(intermediateResult);
        }
        return intermediateResult;
    }
}
