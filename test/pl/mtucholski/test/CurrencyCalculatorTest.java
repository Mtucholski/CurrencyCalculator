package pl.mtucholski.test;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import org.junit.*;
import pl.mtucholski.service.FixerAPI;
import pl.mtucholski.service.CurrencyCalculator;

import static org.mockito.Mockito.*;

public class CurrencyCalculatorTest {

    private CurrencyCalculator classUnderTest;

    private FixerAPI api;

    @Before
    public void setUp() {
        api = mock(FixerAPI.class);

        when(api.pobierzKurs("USD", "PLN"))
                .thenReturn(new BigDecimal("4.1"));

        when(api.pobierzKurs("N/E", "USD"))
                .thenReturn(null);

        classUnderTest = new CurrencyCalculator(api);
    }

    @Test
    public void testCountCurrency() {
        String from = "USD";
        String to = "PLN";
        BigDecimal amount = new BigDecimal("100");

        BigDecimal result = classUnderTest.count(amount, from, to);

        Assert.assertEquals(new BigDecimal("410.0"), result);

    }

    @Test
    public void testErrorAPI() {
        String from = "N/E";
        String to = "USD";
        BigDecimal amount = new BigDecimal("100");

        long start = System.currentTimeMillis();
        BigDecimal result = classUnderTest.count(amount, from, to);
        long end = System.currentTimeMillis();

        System.out.println(end - start);

        Assert.assertNull(result);
        verify(api, times(1)).pobierzKurs("N/E", "USD");
        verifyNoMoreInteractions(api);
    }
}
