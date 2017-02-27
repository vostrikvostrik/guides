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

<script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyBot19sRpBzn0rIvIE2vrzJgpFzgP3q7fA&hl=ru"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/gmaps.markermanager.min.js"></script>

<script type="text/javascript">

    var map;
    var infoWindow;
    function initMap() {

        blockUI("Загрузка...", $("map_canvas"));
        var lat = -54;
        var lng = -68;
        var quantity = 100;

        var myOptions = {
            zoom: 4,
            center: new google.maps.LatLng(lat, lng),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        }

        map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

        infoWindow = new google.maps.InfoWindow({map: map});

        var markerManagerOptions = {
            icon: {
                src: "http://maps.google.com/mapfiles/ms/micons/hiker.png",
                shadow: "http://maps.google.com/mapfiles/ms/micons/hiker.shadow.png"
            },
            cell: {
                width: 48,
                height: 96
            }
        };


        // Try HTML5 geolocation.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude,
                    title: "Current Position"
                };

                infoWindow.setPosition(pos);
                //infoWindow.setTitle('Coordinates');
                //infoWindow.setHeaders();
                infoWindow.setContent('Location found.');
                //    map.setCenter(pos);

            }, function () {
                handleLocationError(true, infoWindow, map.getCenter());
            });
        } else {
            // Browser doesn't support Geolocation
            handleLocationError(false, infoWindow, map.getCenter());
        }


        function handleLocationError(browserHasGeolocation, infoWindow, pos) {
            infoWindow.setPosition(pos);
            infoWindow.setContent(browserHasGeolocation ?
                    'Error: The Geolocation service failed.' :
                    'Error: Your browser doesn\'t support geolocation.');
        }

        var markerManager = new GmapsMarkerManager(map, markerManagerOptions);
        var markers = [];

        $.ajax({
            type: 'POST',
            url: <%=request.getContextPath()%>'/getCityMapPoints',
            async: true,
            datatype: 'json',
            traditional: true,
            success: function (data) {
                for (i = 0; i < data.length; i++) {

                    var cityPoint = data[i].city;
                    lat = -cityPoint.latitude;
                    lng = -cityPoint.longitude;
                    markers.push(new google.maps.Marker({
                        position: new google.maps.LatLng(lat, lng)})
                    );
                    attachCityMessage(markers[i], data[i].tourPointList, cityPoint);
                    markerManager.addMarker(markers[i]);
                }
            }
        });
    }

    // Attaches an info window to a marker with the provided message. When the
    // marker is clicked, the info window will open with the secret message.
    function attachCityMessage(marker, tourPointList, cityPoint) {
        // alert('secretMessage = ' + secretMessage);
        infowindow = new google.maps.InfoWindow(/*{
         content: secretMessage
         }*/);

        var message = '';
        //  alert('tourPointList.length = ' + tourPointList.length);
        for (k = 0; k < tourPointList.length; k++) {
            message = message + 'Тур: <a href="<%=request.getContextPath()%>/tours/tourview?tourId=' + tourPointList[k].tour.tourId + '">' + tourPointList[k].tour.tourName + '</a><br/>';
            if (tourPointList[k].user != null)
                message = message + 'Гид: ' + tourPointList[k].user.userName + '<br/>';
        }

        message = message + 'Город: ' + cityPoint.cityName + '<br/>';

        marker.addListener('click', function () {
            // infowindow.close();

            infowindow.setContent(message);
            infowindow.open(marker.get('map'), /*marker*/this);
            //   map.setZoom(8);
            //  map.setCenter(marker.getPosition());
        });
    }

    // Attaches an info window to a marker with the provided message. When the
    // marker is clicked, the info window will open with the secret message.
    function attachSecretMessage(marker, secretMessage) {
        // alert('secretMessage = ' + secretMessage);
        infowindow = new google.maps.InfoWindow(/*{
         content: secretMessage
         }*/);

        marker.addListener('click', function () {
            // infowindow.close();

            infowindow.setContent(secretMessage);
            infowindow.open(marker.get('map'), /*marker*/this);
            //   map.setZoom(8);
            //  map.setCenter(marker.getPosition());
        });
    }

</script>


<!--div class="main-content container"-->
<div class="col-sm-8 blog-main">
    <div id="progress-content" style="display: none">
        <span>{message}</span>
        <br/>
        <img class="loading-bar" src="<c:url value="/resources/img/ajax-loader.gif" />"/>
    </div>
    <div id="map_canvas" style="margin: 5px auto; width: 650px; height: 400px"></div>

    <div class="container">
        <h3>Найденные туры</h3>
        <table class="table table-striped" id="resultSearch" name="resultSearch">
            <thead>
            <tr>
                <th>Страна</th>
                <th>Город</th>
                <th>Тип тура</th>
                <th>Дата начала</th>
                <th>Дата конца</th>
                <th>Гид</th>
                <th>Ссылка</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>

    <div>
        <input type="submit" value="Start" onclick="start()" />
    </div>
    <div id="messages"></div>
    <script type="text/javascript">
        var webSocket =
                new WebSocket('ws://localhost:8088/websocket');

        webSocket.onerror = function(event) {
            onError(event)
        };

        webSocket.onopen = function(event) {
            onOpen(event)
        };

        webSocket.onmessage = function(event) {
            onMessage(event)
        };

        function onMessage(event) {
            document.getElementById('messages').innerHTML
                    += '<br />' + event.data;
        }

        function onOpen(event) {
            document.getElementById('messages').innerHTML
                    = 'Connection established';
        }

        function onError(event) {
            alert(event.data);
        }

        function start() {
            webSocket.send('hello');
            return false;
        }
    </script>
</div>

