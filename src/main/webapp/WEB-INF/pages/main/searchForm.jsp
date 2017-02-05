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

    $(document).ready(function () {
        $('.datepicker').datepicker({
            format: "dd.mm.yyyy",
            clearBtn: true,
            autoclose: true});


        //---------get guides for live search
        $.ajax({
            type: 'POST',
            url: <%=request.getContextPath()%>'/search/quide',
            async: false,
            data: { name: '' },
            datatype: 'json',
            traditional: true,
            success: function (data) {
                //alert('guideSelect data.length=' + data.length);
                $('#guideSelect').find('option').remove();
                for (i = 0; i < data.length; i++) {
                    var o = new Option(data[i].userPublicName, data[i].userId);
                    $(o).html(data[i].userPublicName);
                    $("#guideSelect").append(o);
                }
            }
        });

        //---------get tour types for live search
        $.ajax({
            type: 'POST',
            url: <%=request.getContextPath()%>'/search/tourType',
            async: false,
            //data: { name: '' },
            datatype: 'json',
            traditional: true,
            success: function (data) {
                // alert('tourType data.length=' + data.length);
                $('#tourTypeSelect').find('option').remove();
                for (i = 0; i < data.length; i++) {
                    var o = new Option(data[i].typeName, data[i].typeId);
                    $(o).html(data[i].typeName);
                    $("#tourTypeSelect").append(o);
                }
            }
        });


        //----- get countries for live search
        //alert('start country');
        $.ajax({
            type: 'POST',
            url: <%=request.getContextPath()%>'/search/country',
            async: false,
            data: { name: '' },
            datatype: 'json',
            traditional: true,
            success: function (data) {
                // alert('country data.length=' + data.length);
                $('#countrySelect').find('option').remove();
                for (i = 0; i < data.length; i++) {
                    var o = new Option(data[i].countryName, data[i].id);
                    $(o).html(data[i].countryName);
                    $("#countrySelect").append(o);
                }
                //   $("#countrySelect").selectedIndex = 0;
                //    alert('"#countrySelect").val() = ' + $("#countrySelect").val());

            }
        });


    });

    function getTours() {
        $.ajax({
            type: 'POST',
            url: <%=request.getContextPath()%>'/search/tours',
            async: false,
            data: { countrySelect: $("#countrySelect").val(),
                tourTypeSelect: $("#tourTypeSelect").val(),
                dateFrom: $("#dateFrom").val(),
                dateTo: $("#dateTo").val(),
                guideSelect: $("#guideSelect").val() },
            datatype: 'json',
            traditional: true,
            success: function (data) {
             //   alert('search Result = ' + data.length);
                for (i = 0; i < data.length; i++) {
                    var newRowContent = '<tr>' +
                            '<td>' + data[i].tourCountry + '</td>' +
                            '<td>' + data[i].tourCity + '</td>' +
                            '<td>' + data[i].tourType + '</td>' +
                            '<td>' + data[i].tourStartDate + '</td>' +
                            '<td>' + data[i].tourEndDate + '</td>' +
                            '<td>' + data[i].userPublicName + '</td>' +
                            '<td><a href="/tours/'+ data[i].tourId +'">View</a></td>' +
                            '</tr>';
                  //  alert('newRowContent = ' + newRowContent);
                  //  alert('$("#resultSearch tbody") = ' + $("#resultSearch tbody"));
                    $("#resultSearch tbody").append(newRowContent);
                }
            }
        });
    }

</script>

<div class="container inline">
    <!--form role="form" class="form-inline"-->
        <div class="form-group">
            <table>
                <tr>
                    <td><label for="countrySelect">Страна:</label></td>
                    <td><label for="tourTypeSelect">Тип тура:</label></td>
                    <td><label for="dateFrom">Дата начала:</label></td>
                    <td><label for="dateTo">Дата окончания:</label></td>
                    <td><label for="guideSelect">Гид:</label></td>
                    <td></td>
                </tr>
                <tr>
                    <td>
                        <select class="selectpicker" data-live-search="true" id="countrySelect" name="countrySelect">
                        </select>
                    </td>
                    <td>
                        <select class="selectpicker" data-live-search="true" id="tourTypeSelect" name="tourTypeSelect">
                        </select>
                    </td>
                    <td>
                        <!--input type="text" class="form-control" id="dateFrom" value="Дата начала:"-->
                        <div class="input-group date" data-provide="datepicker">
                            <input type="text" class="form-control" id="dateFrom" name="dateFrom">

                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-th"></span>
                            </div>
                        </div>
                    </td>
                    <td><!--input type="text" class="form-control" id="dateTo" value="Дата окончания:"></td-->
                        <div class="input-group date" data-provide="datepicker">
                            <input type="text" class="form-control" id="dateTo" name="dateTo">

                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-th"></span>
                            </div>
                        </div>
                    </td>
                    <td>
                        <select class="selectpicker" data-live-search="true" id="guideSelect" name="guideSelect">
                        </select>
                    </td>
                    <td>
                        <button class="btn btn-large btn-primary" onclick="getTours();">
                            Найти
                        </button>
                    </td>
                </tr>
            </table>
        </div>
    <!--/form-->
</div>


