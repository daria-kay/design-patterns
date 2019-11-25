package com.darakay.patterns.chainofresp.handlers;

import com.darakay.patterns.chainofresp.ResultOfCashing;
import com.darakay.patterns.chainofresp.banknote.Banknote;
import com.darakay.patterns.chainofresp.handlers.money_unit_handlers.*;

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
        int sum = Integer.parseInt(queries[0]);
        return defineCurrency(sum, queries[1]).getBanknotes();
    }

    final void setNextChainOfCashingHandlers() {
        BanknoteHandler handler = new FiftyMoneyUnitHandler(null);
        handler = new HundredMoneyUnitHandler(handler);
        handler = new FiveHundredMoneyUnitHandler(handler);
        handler = new ThousandMoneyUnitHandler(handler);
        handler = new FiveThousandMoneyUnitHandlers(handler);
        this.next = handler;
    }

    protected ResultOfCashing defineCurrency(int sum, String currency){
        if(Objects.nonNull(next))
            return next.defineCurrency(sum, currency);
        else throw new IllegalArgumentException();
    }

    protected ResultOfCashing cashOutConcreteCurrency(ResultOfCashing resultOfCashing)  {
        if(Objects.nonNull(this.next)){
            return next.cashOutConcreteCurrency(resultOfCashing);
        }
        return resultOfCashing;
    }
}
