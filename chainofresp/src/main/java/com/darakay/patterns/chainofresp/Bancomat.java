package com.darakay.patterns.chainofresp;

import com.darakay.patterns.chainofresp.handlers.*;

public class Bancomat {

    private BanknoteHandler handler;

    public Bancomat() {
        this.handler = new TenRubleHandler(null);
        this.handler = new TenDollarHandler(handler);
        this.handler = new FiftyDollarHandler(handler);
        this.handler = new HundredDollarHandler(handler);
    }

    public boolean validate(String banknote){
        return this.handler.validate(banknote);
    }
}
