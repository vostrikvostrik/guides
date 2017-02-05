<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><fmt:message key="label.title"/></title>

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico" type="image/png">
    <link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/resources/css/dashboard.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/moment.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap-datetimepicker.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/blockui.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/docs.min.js"></script>
    <style type="text/css"></style>
    <style id="holderjs-style" type="text/css"></style>
</head>

</head>

<tiles:importAttribute name="selected" scope="request"/>
<tiles:importAttribute name="admintype" scope="request"/>
<body>
<div class="container">
    <tiles:insertAttribute name="topMenu"/>

    <div class="container-fluid">
        <div class="row">
            <tiles:insertAttribute name="subMenu"/>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <c:if test="${currentUser!=null}">
                    <div class="row">
                        <div class="span12 text-right">
                            <span class="label label-info"><i
                                    class="icon-user icon-white"></i> ${currentUser.userName}</span>
                        <span class="label label-info"><i
                                class="icon-user icon-white"></i> ${currentUser.userDescribe}</span>
                            <a href="<%=request.getContextPath()%>/logout">выйти</a>
                        </div>
                    </div>
                </c:if>
                <tiles:insertAttribute name="content"/>
            </div>
            <div id="popupWrapper" class="modal hide fade">
                <div class="modal-header" style="background: #fcfcfc">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 id="popupHeader"></h3>
                </div>
            </div>
        </div>

        <div id="push"></div>
    </div>


    <div id="footer">
        <div class="container">
            <p class="muted credit text-center">
                E. Vostrikova @ 2015
            </p>
        </div>
    </div>

</div> <!-- /container -->
</body>
</html>