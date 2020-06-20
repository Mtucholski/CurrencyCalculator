package pl.mtucholski.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.mtucholski.model.ExchangeRate;
import pl.mtucholski.service.FixerAPI;

@WebServlet("/table")
public class CurrencyTableServlet extends HttpServlet {

    private final FixerAPI api = new FixerAPI();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String base = req.getParameter("baseCurrency") == null
                ? "PLN" : req.getParameter("baseCurrency");

        ExchangeRate exchangeRate = api.downloadExchangeRate(base);

        req.setAttribute("exchangeRateJsp", exchangeRate);
        req.setAttribute("currency", api.downloadCurrency());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/table.jsp");
        dispatcher.forward(req, resp);
    }

}
