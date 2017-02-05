<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style type="text/css">
    body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
    }

    .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        text-align: center;
    }

    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }

    .form-signin input[type="text"],
    .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
    }

</style>
<div class="container">
    <c:if test="${not empty param.error}">
        <div class="alert alert-danger">
            Неверное имя пользователя или пароль!
        </div>
    </c:if>
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <input type="hidden" name="loginUrl" id="loginUrl" value="${loginUrl}">
    <form class="form-signin" role="form" action="${loginUrl}" accept-charset="UTF-8" method="POST">
        <h2 class="form-signin-heading"><spring:message code="label.auth"/></h2>
        <input type="text" class="input-block-level" placeholder="<spring:message code="label.username"/>" required="" autofocus=""
               name="j_username">
        <input type="password" class="input-block-level" placeholder="<spring:message code="label.password"/>" required="" name="j_password">
        <br/>
        <button class="btn btn-large btn-primary" name="submit" type="submit"><spring:message code="label.login"/></button>
    </form>
</div>


