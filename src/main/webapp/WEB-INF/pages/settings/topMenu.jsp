<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><fmt:message key="label.title"/></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<%=request.getContextPath()%>/settings/manage/clients">Управление сущностями</a></li>
                <li><a href="<%=request.getContextPath()%>/settings/view/">Настройки отображения</a></li>
                <li><a href="#">Дополнения</a></li>
                <li><a href="#">Help</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</div>

<%--<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-inner">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="<%=request.getContextPath()%>/"><b>RU</b>Guides</a>
            </div>
            <div class="subnav">
                <ul class="nav nav-pills">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Управление
                            сущностями <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/settings/manage/clients">Управление клиентами</a>
                            </li>
                            <li><a href="<%=request.getContextPath()%>/settings/manage/countries">Управление странами</a></li>
                            <li><a href="<%=request.getContextPath()%>/settings/manage/guides">Управление гидами</a></li>
                            <li><a href="<%=request.getContextPath()%>/settings/manage/tours">Управление турами</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Настройки
                            отображения<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/settings/view/clientPage">Страница клиента</a></li>
                            <li><a href="<%=request.getContextPath()%>/settings/view/mainPage">Главная страница</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Дополнения</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>--%>

<script type="text/javascript">
    $(document).ready(function () {
        $('.tooltipMe').tooltip({placement: 'bottom'});
    });
</script>