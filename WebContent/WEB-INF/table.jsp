<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
              crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
              crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h1>ExchangeRateTable ${exchangeRateJsp.base}, dnia: ${exchangeRateJsp.date}</h1>
            <div class="row">
                <div class="col-md-offset-3 col-md-6">

                    <c:url value="/table" var="tableUrl"/>
                    <form id="kursy-form" method="get" action="${tableUrl}">
                        <div class="form-group">
                            <label for="baseCurrency" class="control-label col-md-3">Base Currency: </label>
                            <div class="col-md-9">
                                <select name="baseCurrency" class="form-control" id="baseCurrency">
                                    <option value=""> -- Choose currency -- </option>
                                    <c:forEach items="${currency}" var="currency">
                                        <option ${currency == exchangeRateJsp.base ? 'selected' : ''}
                                            value="${currency}">${currency}</option>
                                    </c:forEach>
                                </select>
                            </div>


                        </div>
                    </form>

                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Symbol</th>
                                <th>Exchange Rate</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${exchangeRateJsp.rates}" var="currency">
                                <tr>
                                    <td>${currency.key}</td>
                                    <td>${currency.value}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script>
            $('#baseCurrency').on('change', function () {
                $('#kursy-form').submit();
            });
        </script>

    </body>
</html>

