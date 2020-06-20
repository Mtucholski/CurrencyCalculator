package pl.mtucholski.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import pl.mtucholski.model.ExchangeRate;

public class FixerAPI {

	private final String API_URL = "http://api.fixer.io/latest";

	public ExchangeRate downloadExchangeRate(String base) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());

			URL url = new URL(API_URL + "?base=" + base);

			return mapper.readValue(url, ExchangeRate.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public BigDecimal pobierzKurs(String from, String to) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());

			URL url = new URL(API_URL + "?base=" + from + "&symbols=" + to);
			ExchangeRate exchangeRate = mapper.readValue(url, ExchangeRate.class);
			
			Map<String, BigDecimal> rates = exchangeRate.getRates();
			
			
			return rates.get(to);
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Set<String> downloadCurrency() {
		ExchangeRate exchangeRate = downloadExchangeRate("EUR");
		Map<String, BigDecimal> rates = exchangeRate.getRates();
		rates.put("EUR", BigDecimal.ZERO);
		
		return rates.keySet();
	}

}
