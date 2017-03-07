/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 26.02.17
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp')
    .controller('countryController', ['$scope', '$location', '$http', 'CountryService', function ($scope, $location, $http, CountryService) {
        // настройка контроллера
        $scope.jQuery = jQuery.noConflict();

        var self = this;

        self.country = {
            country: null ,
            countries:  []
        };

        fetchAllCountries();

        function fetchAllCountries() {

            CountryService.fetchAllCountries()
                .then(
                function (d) {
                    self.country.countries = d;
                },
                function (errResponse) {
                    console.error('Error while fetching countries in controller');
                }
            );
        }

    }]);
