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
            <div class="row">
                <div class="col-md-offset-3 col-md-6">
                    <h1>Form</h1>

                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="amount" class="control-label col-md-3">Amount: </label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="amount" name="amount"
                                       placeholder="Write amount" value="${amount}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="currency_from" class="control-label col-md-3">Currency  from: </label>
                            <div class="col-md-9">
                                <select class="form-control" id="currency_from" name="from" required>
                                    <option value=""> -- Choose currency -- </option>
                                    <c:forEach items="${currency}" var="currency">
                                        <option ${currency == from ? 'selected' : ''}
                                            value="${currency}">${currency}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="currency_to" class="control-label col-md-3">currency to: </label>
                            <div class="col-md-9">
                                <select class="form-control" id="currency_to" name="to" required>
                                    <option value=""> -- Choose currency -- </option>
                                    <c:forEach items="${currency}" var="currency">
                                        <option ${currency == to ? 'selected' : ''}
                                            value="${currency}">${currency}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn btn-primary">Count</button>
                            </div>
                        </div>
                    </form>

                    <c:if test="${result != null}">
                        Result: ${result} ${to}
                    </c:if>

                </div>
            </div>
        </div>
    </body>
</html>

