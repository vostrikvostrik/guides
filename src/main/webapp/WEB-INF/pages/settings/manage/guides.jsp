<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.10.15
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>

    <h1 class="page-header">${selected}</h1>


<h2 class="sub-header">Список гидов</h2>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Имя гида</th>
            <th>Страна</th>
            <th>Фактическое<br/>место пребывания</th>
            <th>Туры</th>
            <th>Блокировка гида</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${guideList}" var="guide">
            <tr>
                <td>${guide.userName}</td>
                <td>${guide.userCountry}/${guide.userCity}</td>
                <td>${guide.userDescribe}</td>
                <td><a href="#">Туры</a></td>
                <td>
                    <c:choose>
                        <c:when test="${guide.userGuideState eq 'A'}">
                            <a href="#">Блокировка</a>
                        </c:when>
                        <c:when test="${guide.userGuideState eq 'B'}">
                            <a href="#">Разблокировка</a>
                        </c:when>
                    </c:choose>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<button class="btn btn-large btn-primary" name="submit" type="submit"><spring:message code="settings.manage.guide.add"/></button>

