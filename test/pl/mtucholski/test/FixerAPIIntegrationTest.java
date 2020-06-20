package pl.mtucholski.test;

import java.math.BigDecimal;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.mtucholski.model.ExchangeRate;
import pl.mtucholski.service.FixerAPI;

public class FixerAPIIntegrationTest {

    private FixerAPI classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new FixerAPI();
    }

    @Test
    public void testPobieraniaKursow() {
        ExchangeRate kurs = classUnderTest.downloadExchangeRate("PLN");
        Assert.assertNotNull(kurs);
        Assert.assertNotNull(kurs.getBase());
        Assert.assertNotNull(kurs.getDate());
        Assert.assertNotNull(kurs.getRates());
        Assert.assertEquals("PLN", kurs.getBase());
    }

    @Test
    public void testPobieraniaKursDwochWalut() {
        String from = "USD";
        String to = "EUR";
        BigDecimal kurs = classUnderTest.pobierzKurs(from, to);

        Assert.assertNotNull(kurs);
    }

    @Test
    public void testPobieraZbioruWalut() {

        Set<String> waluty = classUnderTest.downloadCurrency();

        Assert.assertNotNull(waluty);
        Assert.assertFalse(waluty.isEmpty());
    }

}
