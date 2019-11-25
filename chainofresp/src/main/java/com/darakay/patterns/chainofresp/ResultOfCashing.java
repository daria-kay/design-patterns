package com.darakay.patterns.chainofresp;

import com.darakay.patterns.chainofresp.banknote.Banknote;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultOfCashing {
    private List<Banknote> banknotes;
    private Banknote.Builder banknoteBuilder;
    private int remains;

    public ResultOfCashing(int initialValue, Banknote.Builder banknoteBuilder) {
        this.remains = initialValue;
        this.banknoteBuilder = banknoteBuilder;
        this.banknotes = new ArrayList<>();
    }

    public List<Banknote> getBanknotes() {
        if(remains != 0)
            return new ArrayList<>();
        else
            return banknotes;
    }

    public void put(int nominal) {
        int amount = remains / nominal;
        this.banknotes.addAll(Stream.iterate(0, i -> i++).limit(amount)
                .map(i -> banknoteBuilder.createWithNominal(nominal))
                .collect(Collectors.toList()));
        this.remains = remains % nominal;
    }
}
