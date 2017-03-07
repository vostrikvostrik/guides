/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 27.02.17
 * Time: 19:51
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp')
    .controller('cityController', ['$scope', '$location', '$http', 'CityService', function ($scope, $location, $http, CityService) {
        // настройка контроллера
        $scope.jQuery = jQuery.noConflict();

        var self = this;

        self.city = {
            city: null ,
            cities:  []
        };

        fetchAllCities();

        function fetchAllCities() {

            CityService.fetchAllCities()
                .then(
                function (d) {
                    self.city.cities = d;
                },
                function (errResponse) {
                    console.error('Error while fetching city.cities in controller');
                }
            );
        }

    }]);
