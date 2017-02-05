<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: EVostrikova
  Date: 27.08.15
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>

<h1 class="page-header">${selected}</h1>
<c:url value="/settings/catalog/currencies" var="manageCurrencies" />
<form:form class="form-signin" role="form"
           modelAttribute="manageCurrencies" commandName="manageCurrencies" action="${manageCurrencies}" accept-charset="UTF-8" method="POST">

    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Валюта</th>
                <th>Описание</th>
                <th>Редактировать</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${currencyList}" var="currency">
                <tr>
                    <td>${currency.currencyName}</td>
                    <td> ${currency.currencyCode}</td>
                    <td>
                        <a href="javascript:void(0);showHide('currency_block')" onclick=""><spring:message code="settings.manage.currency.edit"/></a><br/><br/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</form:form>

    <h1 class="page-header">${selected}</h1>
