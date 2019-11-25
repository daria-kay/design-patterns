package com.darakay.patterns.chainofresp;

import com.darakay.patterns.chainofresp.banknote.Banknote;
import com.darakay.patterns.chainofresp.handlers.BanknoteHandler;
import com.darakay.patterns.chainofresp.handlers.DollarHandler;
import com.darakay.patterns.chainofresp.handlers.EuroHandler;
import com.darakay.patterns.chainofresp.handlers.RubleHandler;

import java.util.List;

public class Bancomat {

    private BanknoteHandler handler;

    public Bancomat() {
        this.handler = new RubleHandler(null);
        this.handler = new DollarHandler(handler);
        this.handler = new EuroHandler(handler);
    }

    public boolean validate(String banknote){
        return this.handler.validate(banknote);
    }

    public List<Banknote> cash(String cashRequest){
        return handler.cashOut(cashRequest);
    }
}
