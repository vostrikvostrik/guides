<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-sm-3 col-md-2 sidebar">
    <c:if test="${currentUser!=null}">
        <ul class="nav nav-sidebar">
            <li <c:if test='${selected == "countries"}'>class="active"</c:if>><a
                    href="#">Поиск гида</a></li>
            <li <c:if test='${selected == "cities"}'>class="active"</c:if>><a
                    href="<#">Поиск стран</a></li>
        </ul>
    </c:if>
</div>
