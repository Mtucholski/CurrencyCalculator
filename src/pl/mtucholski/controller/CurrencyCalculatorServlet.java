package pl.mtucholski.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.mtucholski.service.FixerAPI;
import pl.mtucholski.service.CurrencyCalculator;

@WebServlet("/calculator")
public class CurrencyCalculatorServlet extends HttpServlet {

    private final FixerAPI api = new FixerAPI();
    private final CurrencyCalculator calculator = new CurrencyCalculator(api);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String from = req.getParameter("from");
        String to = req.getParameter("to");
        BigDecimal amount = null;

        if (req.getParameter("amount") != null) {
            amount = new BigDecimal(req.getParameter("amount"));
        }

        if (from != null && to != null && amount != null) {
            BigDecimal result = calculator.count(amount, from, to);
            req.setAttribute("result", result);
            req.setAttribute("from", from);
            req.setAttribute("to", to);
            req.setAttribute("amount", amount);
        }

        req.setAttribute("currency", api.downloadCurrency());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/form.jsp");
        dispatcher.forward(req, resp);
    }
}
