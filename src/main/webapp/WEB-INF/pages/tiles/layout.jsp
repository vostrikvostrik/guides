<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title><fmt:message key="label.title"/></title>

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico" type="image/png"/>
    <link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap-select.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap-select.min.css" rel="stylesheet"/>

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/resources/css/justified-nav.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap-datepicker.min.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap-datepicker.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/resources/css/jqcloud.css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jqcloud-1.0.0.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/moment.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap-datetimepicker.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap-datepicker.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/blockui.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap-select.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap-select.min.js"></script>
</head>

<tiles:importAttribute name="selected" scope="request"/>
<body onload="initMap();initTagCloud();" onunload="GUnload()">

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
<tiles:insertAttribute name="topMenu"/>
<div class="container">
    <div class="row">

        <c:if test="${message!=null}">

            <div class="span12">
                <br/>

                <div class="alert alert-info">
                    Main message from controller: ${message}
                </div>
            </div>

        </c:if>
            <tiles:insertAttribute name="searchForm"/>
        <tiles:insertAttribute name="content"/>
        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <tiles:insertAttribute name="tagCloud"/>
        </div>
    </div>
    <div id="footer">
        <div class="container">
            <p class="muted credit text-center">
                E. Vostrikova @ 2015
            </p>
        </div>
    </div>

</div>
</body>
</html>