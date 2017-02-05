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

<script type="text/javascript">

    function showHide(block_id, element_id) {
        //Если элемент с id-шником element_id существует
        if (document.getElementById(block_id)) {
            //Записываем ссылку на элемент в переменную obj
            var obj = document.getElementById(block_id);
            //Если css-свойство display не block, то:
            if (obj.style.display != "block") {
                obj.style.display = "block"; //Показываем элемент
            }
            else obj.style.display = "none"; //Скрываем элемент
        }
        if(element_id > 0 )
        {

        }
        //document.getElementsByTagName('DIV')[0].getElementsByTagName('LI')
    }

    function countryEdit(id) {
        var data = {}
        data["query"] = $("#query").val();

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "<%=request.getContextPath()%>'/settings/catalog/country/"+id,
            data : JSON.stringify(data),
            dataType : 'json',
            timeout : 100000,
            success : function(data) {
                console.log("SUCCESS: ", data);
                display(data);
            },
            error : function(e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done : function(e) {
                console.log("DONE");
            }
        });
    }
</script>

<h1 class="page-header">${selected}</h1>

<h2 class="sub-header">Список стран</h2>
<c:url value="/settings/catalog/countries" var="manageCountries" />
<form:form class="form-signin" role="form"
           modelAttribute="manageCountries" commandName="manageCountries" action="${manageCountries}" accept-charset="UTF-8" method="POST">
    <a href="javascript:void(0);showHide('block_id')" onclick=""><spring:message code="settings.manage.country.add"/></a><br/><br/>
    <div id="block_id" style="display: none;">
        <div class="form-group">
            <label class="control-label" for="countryName">Имя</label>
            <form:input type="text" class="form-control" id="countryName" path="countryName"/>
        </div>
        <div class="form-group">
            <label class="control-label" for="code">Описание</label>
            <form:input type="text" class="form-control" id="code" path="code"/>
        </div>
        <br/>
        <button class="btn btn-large btn-primary" name="submit" type="submit" onclick="showHide();"><spring:message
                code="settings.manage.country.add"/></button>
    </div>
    <div id="country_block" style="display: none;">
        <div class="form-group">
            <label class="control-label" for="countryName">Ид страны</label>
            <form:input type="text" class="form-control" id="id" path="id"/>
        </div>
        <div class="form-group">
            <label class="control-label" for="countryName">Название страны</label>
            <form:input type="text" class="form-control" id="countryName" path="countryName"/>
        </div>
        <div class="form-group">
            <label class="control-label" for="code">Код страны</label>
            <form:input type="text" class="form-control" id="code" path="code"/>
        </div>
        <div class="form-group">
            <label class="control-label" for="code">Описание</label>
            <form:input type="text" class="form-control" id="alias" path="alias"/>
        </div>
        <div class="form-group">
            <label class="control-label" for="code">Широта</label>
            <form:input type="text" class="form-control" id="lat" path="lat"/>
        </div>
        <div class="form-group">
            <label class="control-label" for="code">Долгота</label>
            <form:input type="text" class="form-control" id="lng" path="lng"/>
        </div>
        <br/>
        <button class="btn btn-large btn-primary" name="submit" type="submit" onclick="showHide();"><spring:message
                code="settings.manage.country.edit"/></button>

    </div>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Страна</th>
                <th>Описание</th>
                <th>Редактировать</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${countryList}" var="country">
                <tr>
                    <td>${country.countryName}</td>
                    <td>${country.code} / ${country.alias} / ${country.lat} / ${country.lng}</td>
                    <td>
                        <a href="javascript:void(0);showHide('country_block')" onclick=""><spring:message code="settings.manage.country.edit"/></a><br/><br/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</form:form>