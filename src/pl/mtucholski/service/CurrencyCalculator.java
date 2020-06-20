package pl.mtucholski.service;

import java.math.BigDecimal;

public class CurrencyCalculator {

    private final FixerAPI api;

    public CurrencyCalculator(FixerAPI api) {
        this.api = api;
    }

    public BigDecimal count(BigDecimal amount, String from, String to) {

        BigDecimal exchangeRate = api.pobierzKurs(from, to);

        if (exchangeRate == null) {
            return null;
        }

        return amount.multiply(exchangeRate);
    }

}
