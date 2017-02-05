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
$( document ).ready(function() {
    var password = document.getElementById("userPassword");
    var confirm_password = document.getElementById("confirmPassword");

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
});

function validatePassword() {
    var password = document.getElementById("userPassword");
    var confirm_password = document.getElementById("confirmPassword");

    if(password.value != confirm_password.value)
    {
        confirm_password.setCustomValidity("Passwords Don't Match");
        confirm_password.reportValidity();
    }
    else if(password.value.trim() == "")
    {
        password.setCustomValidity("Passwords must not be empty");
        password.reportValidity();
    } else
    {
        password.setCustomValidity("");
    }
}

function createClient() {


    var client = {
        userName: $("#userName").val(),
        userCountry: 0,
        userCity: 1,
        userEmail: $("#userEmail").val(),
        userPassword: $("#userPassword").val(),
        confirmPassword: $("#confirmPassword").val(),
        userDescribe: $("#userDescribe").val(),
        userVkId: 0,
        userFbId: 1,
        userClientState: 'A',
        userGuideState: 'N',
        userIsGuide: $("#userIsGuide").val(),
        userIsClient: $("#userIsClient").val(),
        userPublicName: $("#userPublicName").val()
    };

    $.ajax({
        type: 'POST',
        url: <%=request.getContextPath()%>'/clients',
        async: false,
        data: JSON.stringify(client),
        contentType: 'application/json',
        datatype: 'json',
        traditional: true,
        success: function (data) {
            var errorString = '';
            $.each(data.errors, function (key, value) {
                errorString += key + ": " + value + "<br/>";
            });
            if(errorString != ''){
                $("#errors").html(errorString);
                var obj = document.getElementById('errors');
                obj.style.display = "block"; //Показываем элемент
                $('html, body').animate({ scrollTop: $('#errors').offset().top }, 'slow');
            }

            var newRowContent = '<tr>' +
                    '<td>' + data.userPublicName + ' ( логин: ' + data.userName + ' )</td>' +
                    '<td>' + data.userCountry + '/' + data.userCity + '</td>' +
                    '<td>' + data.userDescribe + '</td>' +
                    '<td><a href="#">Туры</a></td>';
            if (data.userGuideState = 'A') {
                newRowContent += '<td><a href="#">Блокировка</a></td>';
            }
            else if (data.userGuideState = 'B') {
                newRowContent += '<td><a href="#">Разблокировка</a></td>';
            }
            else
                newRowContent += '<td></td>';
                newRowContent = newRowContent + '' +
                    ' <td> ' +
                    ' <button class="btn btn-large btn-primary" name="submit" type="submit" onclick="getClient(' + data.userId + ');showHide(\'block_id\',\'update\','+data.userId+');">' +
                    ' <spring:message code="settings.manage.client.edit"/></button> ' +
                    ' </td>' +
                    ' <td> ' +
                    ' <button class="btn btn-large btn-primary" name="submit" type="submit" onclick="deleteClient(' + data.userId + ');">' +
                    ' <spring:message code="settings.manage.client.delete"/></button> ' +
                    ' </td>' +
                    '</tr>';


            $("#clientTable tbody").append(newRowContent);
            if(errorString = '')
                showHide('block_id');
        }
    });
}

function getAllClients() {
    $.ajax({
        type: 'GET',
        url: <%=request.getContextPath()%>'/clients',
        async: false,
        datatype: 'json',
        traditional: true,
        success: function (data) {

            //alert('get all list data.length = ' + data.length);
            $("#clientTable > tbody:last").children().remove();


            for (i = 0; i < data.length; i++) {
                var newRowContent = '<tr>' +
                        '<td>' + data[i].userPublicName + ' ( логин: ' + data[i].userName + ' )</td>' +
                        '<td>' + data[i].userCountry + '/' + data[i].userCity + '</td>' +
                        '<td>' + data[i].userDescribe + '</td>' +
                        '<td><a href="#">Туры</a></td>';
                if (data[i].userGuideState = 'A') {
                    newRowContent += '<td><a href="#">Блокировка</a></td>';
                }
                else if (data[i].userGuideState = 'B') {
                    newRowContent += '<td><a href="#">Разблокировка</a></td>';
                }
                else
                    newRowContent += '<td></td>';
                    newRowContent = newRowContent + '' +
                        ' <td> ' +
                        ' <button class="btn btn-large btn-primary" name="submit" type="submit" onclick="getClient(' + data[i].userId + ');showHide(\'block_id\',\'update\','+ data[i].userId +');">' +
                        ' <spring:message code="settings.manage.client.edit"/></button> ' +
                        ' </td>' +
                        ' <td> ' +
                        ' <button class="btn btn-large btn-primary" name="submit" type="submit" onclick="deleteClient(' + data[i].userId + ');">' +
                        ' <spring:message code="settings.manage.client.delete"/></button> ' +
                        ' </td>' +
                        '</tr>';

                $("#clientTable tbody").append(newRowContent);

            }
        }
    });

}


function deleteClient(clientId) {
    $.ajax({
        type: 'DELETE',
        url: <%=request.getContextPath()%>'/clients/' + clientId,
        async: false,
        datatype: 'json',
        traditional: true,
        success: function (data) {
            //alert('delete clientId = ' + clientId);
            getAllClients();
        }
    });
}

function getClient(clientId) {
    $.ajax({
        type: 'GET',
        url: <%=request.getContextPath()%>'/clients/' + clientId,
        async: false,
        datatype: 'json',
        traditional: true,
        success: function (data) {
            $("#userId").val(data.userId);
            $("#userName").val(data.userName);
            $("#userName").val(data.userName);
            $("#userCountry").val(data.userCountry);
            $("#userCity").val(data.userCity);
            $("#userEmail").val(data.userEmail);
            $("#userPassword").val(data.userPassword);
            $("#confirmPassword").val(data.userPassword);
            $("#userDescribe").val(data.userDescribe);
            $("#userIsGuide").val(data.userIsGuide);
            $("#userIsClient").val(data.userIsClient);
            $("#userPublicName").val(data.userPublicName);

        }
    });
}

function updateClient(clientId) {


    var client = {
        userId: clientId,
        userName: $("#userName").val(),
        userCountry: 0,
        userCity: 1,
        userEmail: $("#userEmail").val(),
        userPassword: $("#userPassword").val(),
        confirmPassword: $("#confirmPassword").val(),
        userDescribe: $("#userDescribe").val(),
        userVkId: 0,
        userFbId: 1,
        userClientState: 'A',
        userGuideState: 'N',
        userIsGuide: $("#userIsGuide").val(),
        userIsClient: $("#userIsClient").val(),
        userPublicName: $("#userPublicName").val()
    };

    $.ajax({
        type: 'PUT',
        url: <%=request.getContextPath()%>'/clients/' + clientId,
        async: false,
        data: /*{id: clientId,client:*/ JSON.stringify(client)/*}*/,
        contentType: 'application/json',
        datatype: 'json',
        traditional: true,
        success: function (data) {
            $.each(data.errors, function (key, value) {
                errorString += key + ": " + value + "<br/>";
            });
            if(errorString != ''){
                $("#errors").html(errorString);
                var obj = document.getElementById('errors');
                obj.style.display = "block"; //Показываем элемент
                $('html, body').animate({ scrollTop: $('#errors').offset().top }, 'slow');
            }

            getAllClients();

            if(errorString = '')
                showHide('block_id');
        }
    });
}


function showHide(element_id, blocktype, clientId) {
    //Если элемент с id-шником element_id существует
    if (document.getElementById(element_id)) {
        //Записываем ссылку на элемент в переменную obj
        var obj = document.getElementById(element_id);
        //Если css-свойство display не block, то:
        if (obj.style.display != "block") {
            obj.style.display = "block"; //Показываем элемент
            $("#showBlock").html("Hide");
            var obj = document.getElementById('errors');
            obj.style.display = "none"; //Показываем элемент
            //blocktype
            if (blocktype = 'update'){
                $('#updButton').click(function() {
                    alert('Update  ');
                    updateClient(clientId);

                });
            }
            else{
                $('#updButton').click(function() {
                    alert('Create');
                    createClient(clientId);

                });
            }
        }
        else {obj.style.display = "none"; //Скрываем элемент
            $("#showBlock").html("Add client");
        }
    }
    //Если элемент с id-шником element_id не найден, то выводим сообщение
    //else alert("Элемент с id: " + element_id + " не найден!");
}
</script>
<style>
    .error {
        color: #ff0000;
    }

    .errorblock {
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
    }
</style>
<h1 class="page-header">${selected}</h1>

<h2 class="sub-header">Список клиентов</h2>
<c:url value="/settings/manage/clients" var="manageClients"/>
<a href="javascript:void(0);showHide('block_id','create');" onclick="" id="showBlock"><spring:message
        code="settings.manage.client.add"/></a><br/><br/>
<!--form:form class="form-signin" role="form"
commandName="client" action="${manageClients}" accept-charset="UTF-8"-->
<div id="block_id" style="display: none;">
    <input type="hidden" id = "userId" />
    <div class="form-group">
        <div id="errors" class="errorblock"></div>
        <label class="control-label" for="userPublicName">Имя</label>
        <input type="text" class="form-control" id="userPublicName"/>
    </div>
    <div class="form-group">
        <label class="control-label" for="userDescribe">Описание</label>
        <input type="text" class="form-control" id="userDescribe"/>
    </div>
    <div class="form-group">
        <label class="control-label" for="userCity">Город</label>
        <input type="text" class="form-control" id="userCity"/>
    </div>
    <div class="form-group">
        <label class="control-label" for="userCountry">Страна</label>
        <input type="text" class="form-control" id="userCountry"/>
    </div>
    <div class="form-group">
        <label class="control-label" for="userName">Логин</label>
        <input type="text" class="form-control" id="userName"/>
    </div>
    <div class="form-group">
        <label class="control-label" for="userEmail">Email</label>
        <input type="text" class="form-control" id="userEmail"/>
    </div>
    <div class="form-group">
        <label class="control-label" for="userPassword">Пароль</label>
        <input type="password" class="form-control" id="userPassword" placeholder="Please Enter Password" required="required"/>
    </div>
    <div class="form-group">
        <label class="control-label" for="confirmPassword">Подтверждение пароля</label>
        <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password"  required="required"/>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" id="userIsClient" value="1" checked="true" readonly="true"/>
            Клиент
        </label>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" id="userIsGuide" value="1"/>
            Гид
        </label>
    </div>
    <br/>

    <button class="btn btn-large btn-primary" id="updButton" onclick="createClient();"><spring:message
            code="settings.manage.client.add"/></button>
    <!--input type="submit" /-->
</div>
<!--/form:form-->
<div class="table-responsive">
    <table class="table table-striped" id="clientTable">
        <thead>
        <tr>
            <th>Имя клиента</th>
            <th>Страна</th>
            <th>Фактическое<br/>место пребывания</th>
            <th>Туры</th>
            <th>Блокировка клиента</th>
            <th>Редактировать</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${clientList}" var="client">
            <tr>
                <td>${client.userPublicName} ( логин: ${client.userName} )</td>
                <td>${client.userCountry}/${client.userCity}</td>
                <td>${client.userDescribe}</td>
                <td><a href="#">Туры</a></td>
                <td>
                    <c:choose>
                        <c:when test="${client.userGuideState eq 'A'}">
                            <a href="#">Блокировка</a>
                        </c:when>
                        <c:when test="${client.userGuideState eq 'B'}">
                            <a href="#">Разблокировка</a>
                        </c:when>
                    </c:choose>

                </td>
                <td>
                    <button class="btn btn-large btn-primary" name="submit" type="submit"
                            onclick="getClient(${client.userId});showHide('block_id','update',${client.userId});">
                        <spring:message
                                code="settings.manage.client.edit"/></button>
                </td>
                </td>
                <td>
                    <button class="btn btn-large btn-primary" name="submit" type="submit"
                            onclick="deleteClient(${client.userId});">
                        <spring:message code="settings.manage.client.delete"/></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


