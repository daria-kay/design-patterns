package com.darakay.patterns.chainofresp.banknote;

import java.util.Objects;

public class Banknote implements IBanknote{
   private int nominal;
   private CurrencyType currencyType;

   private Banknote(int nominal, CurrencyType currencyType) {
      this.nominal = nominal;
      this.currencyType = currencyType;
   }

   public static Builder withCurrency(CurrencyType currency) {
      return new Builder(currency);
   }

   @Override
   public int getNominal() {
      return nominal;
   }

   @Override
   public CurrencyType getCurrency() {
      return currencyType;
   }

   public static class Builder {
      private CurrencyType currencyType;

      public Builder(CurrencyType currencyType) {
         this.currencyType = currencyType;
      }

      public Banknote createWithNominal(int nominal){
         return new Banknote(nominal, currencyType);
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Banknote banknote = (Banknote) o;
      return nominal == banknote.nominal &&
              currencyType == banknote.currencyType;
   }

   @Override
   public int hashCode() {
      return Objects.hash(nominal, currencyType);
   }

   @Override
   public String toString() {
      return "Banknote{" +
              "nominal=" + nominal +
              ", currencyType=" + currencyType +
              '}';
   }
}
