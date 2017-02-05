<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/resources/css/full-width-pics.css" rel="stylesheet">

<div class="masthead">

    <header class="image-bg-fullfill-height">
        <h3 class="text-muted">Гиды.РУ</h3>
    </header>
        <ul class="nav nav-justified">
            <li><a href="#">Поиск туров</a></li>
            <li><a href="#">Будущие туры</a></li>
        </ul>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('.tooltipMe').tooltip({placement: 'bottom'});
    });
</script>