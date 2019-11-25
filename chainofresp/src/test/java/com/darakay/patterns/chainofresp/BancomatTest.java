package com.darakay.patterns.chainofresp;

import com.darakay.patterns.chainofresp.banknote.Banknote;
import com.darakay.patterns.chainofresp.banknote.CurrencyType;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BancomatTest {

    private Bancomat bancomat = new Bancomat();

    @Test
    public void shouldCashOut_RoundSumOfRubles(){
        List<Banknote> actual = bancomat.cash("250 rub");
        Banknote.Builder rubleBuilder = Banknote.withCurrency(CurrencyType.RUBLE);

        assertThat(actual).containsExactly(
                rubleBuilder.createWithNominal(100),
                rubleBuilder.createWithNominal(100),
                rubleBuilder.createWithNominal(50));
    }

    @Test
    public void shouldCashOut_RoundSumOfDollars(){
        List<Banknote> actual = bancomat.cash("150 $");
        Banknote.Builder rubleBuilder = Banknote.withCurrency(CurrencyType.DOLLAR);

        assertThat(actual).containsExactly(
                rubleBuilder.createWithNominal(100),
                rubleBuilder.createWithNominal(50));
    }

    @Test
    public void shouldCashOut_RoundSumOfEuros(){
        List<Banknote> actual = bancomat.cash("150 eur");
        Banknote.Builder rubleBuilder = Banknote.withCurrency(CurrencyType.EURO);

        assertThat(actual).containsExactly(
                rubleBuilder.createWithNominal(100),
                rubleBuilder.createWithNominal(50));
    }

    @Test
    public void shouldNotCashOut_NotRoundSum(){
        List<Banknote> actual = bancomat.cash("263 rub");

        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldNotCashOut_SmallSum(){
        List<Banknote> actual = bancomat.cash("3 rub");

        assertThat(actual).isEmpty();
    }

    @Test
        public void shouldCashOut_SumMultipleOf10(){
        List<Banknote> actual = bancomat.cash("2000 rub");
        Banknote.Builder rubleBuilder = Banknote.withCurrency(CurrencyType.RUBLE);

        assertThat(actual).containsExactly(
                rubleBuilder.createWithNominal(1000),
                rubleBuilder.createWithNominal(1000));
    }

}