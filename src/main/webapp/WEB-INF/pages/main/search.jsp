<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.12.16
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>

<div class="list-group">
    <h3>${tagItem.tagName}</h3>
    <c:forEach items="${resultList}" var="result">
            <a href="${result.tagLink}"  class="list-group-item  list-group-item-action">
                <h5 class="list-group-item-heading">${result.tagType} / ${result.tagName}</h5>
                <p class="list-group-item-text">${result.tagDescr}</p>
            </a>

    </c:forEach>
</div>
