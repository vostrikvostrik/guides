<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.10.15
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>

<h1 class="page-header">${selected}</h1>

<div class="row placeholders">
    <div class="col-xs-6 col-sm-3 placeholder">
        <a href="<%=request.getContextPath()%>/settings/manage/tours?tour_active=1&tourtype=2">
            <!--img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail"-->
            <span class="glyphicon glyphicon-th-list"></span>
            <!--h4>Список</h4-->
            <span class="text-muted">Журнал закончившихся туров</span>
        </a>
    </div>
    <div class="col-xs-6 col-sm-3 placeholder">
        <a href="<%=request.getContextPath()%>/settings/manage/tours?tour_active=0">
            <!--img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail"-->
            <span class="glyphicon glyphicon-th-list"></span>
            <!--h4>Список</h4-->
            <span class="text-muted">Журнал заблокированных туров</span>
        </a>
    </div>
    <div class="col-xs-6 col-sm-3 placeholder">
        <a href="<%=request.getContextPath()%>/settings/manage/tours?tour_active=1&tourtype=1">
            <!--img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail"-->
            <span class="glyphicon glyphicon-th-list"></span>
            <!--h4>Список</h4-->
            <span class="text-muted">Журнал активных туров</span>
        </a>
    </div>
</div>
<h2 class="sub-header">Список туров</h2>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Страна</th>
            <th>ГОРОД</th>
            <th>Направление<br/>деятельности</th>
            <th>Дата нач.</th>
            <th>Дата оконч</th>
            <th>ГИД (email и имя)</th>
            <th>Цена (S)</th>
            <th>Описание тура</th>
            <th>Участники тура</th>
            <th>Мест\Претендуют</th>
            <th>Блокировка тура</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tourList}" var="tour">
            <tr>
                <td>${tour.tourCountry}</td>
                <td>${tour.tourCity}</td>
                <td>${tour.tourType}</td>
                <td>${tour.tourStartDate}</td>
                <td>${tour.tourEndDate}</td>
                <td>${tour.tourGuide}</td>
                <td>${tour.tourPrice}&nbsp;${tour.tourCurrency}</td>
                <td>${tour.tourDescribe}</td>
                <td>${tour.tourDescribe}</td>
                <td>${tour.placesCount}</td>
                <td>${tour.tourActive}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

