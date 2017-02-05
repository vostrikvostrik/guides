<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-sm-3 col-md-2 sidebar">
    <c:choose>
        <c:when test="${admintype == 'manage'}">
            <ul class="nav nav-sidebar">
                <li <c:if test='${selected == "clients"}'>class="active"</c:if>><a
                        href="<%=request.getContextPath()%>/settings/manage/clients">Управление клиентами</a></li>
                <li <c:if test='${selected == "guides"}'>class="active"</c:if>><a
                        href="<%=request.getContextPath()%>/settings/manage/guides">Управление гидами</a></li>
                <li <c:if test='${selected == "tours"}'>class="active"</c:if>><a
                        href="<%=request.getContextPath()%>/settings/manage/tours">Управление турами</a></li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul class="nav nav-sidebar">
                <li <c:if test='${selected == "clientPage"}'>class="active"</c:if>><a
                        href="<%=request.getContextPath()%>/settings/view/clientPage">Страница клиента</a></li>
                <li <c:if test='${selected == "mainPage"}'>class="active"</c:if>><a
                        href="<%=request.getContextPath()%>/settings/view/mainPage">Главная страница</a></li>
            </ul>
        </c:otherwise>
    </c:choose>
    <ul class="nav nav-sidebar">
        <li <c:if test='${selected == "countries"}'>class="active"</c:if>><a
                href="<%=request.getContextPath()%>/settings/catalog/countries">Управление странами</a></li>
        <li <c:if test='${selected == "cities"}'>class="active"</c:if>><a
                href="<%=request.getContextPath()%>/settings/catalog/cities">Список городов</a></li>
        <li <c:if test='${selected == "tourtypes"}'>class="active"</c:if>><a
                href="<%=request.getContextPath()%>/settings/catalog/tourtypes">Список типов туров</a></li>
        <li <c:if test='${selected == "currencies"}'>class="active"</c:if>><a
                href="<%=request.getContextPath()%>/settings/catalog/currencies">Список валют</a></li>
    </ul>
</div>

