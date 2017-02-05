<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: EVostrikova
  Date: 11.01.16
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>

<!--div class="main-content container"-->
<br/><br/>
<div class="col-sm-8 blog-main">
    <div style="text-align: left; font-size: large;">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-4 control-label" style="text-align: left; ">Название тура </label>
                <div class="col-sm-4">
                    ${tourItem.tourName}
                </div>
                <div class="col-sm-4">
                    ${tourItem.tourDescribe}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label" style="text-align: left; ">Страна ${tourItem.tourCountry} / город ${tourItem.tourCity}</label>
                <div class="col-sm-4">
                    <p class="form-control-static">Гид ${tourItem.tourGuideName}</p>
                </div>
                <div class="col-sm-4">
                    <p class="form-control-static">Фото гида</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label" style="text-align: left; ">Цена тура: ${tourItem.tourPrice} ${tourItem.tourCurrName}</label>
                <div class="col-sm-4">
                    <p class="form-control-static">Количество мест в туре  ${tourItem.placesCount} / забронировано ${tourItem.clientCount}</p>
                </div>
                <div class="col-sm-4">

                </div>
            </div>

        </form>
    </div>
</div>
