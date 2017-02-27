/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 26.02.17
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp')
    .controller('currencyController', ['$scope', '$location', '$http', 'CurrencyService', function ($scope, $location, $http, CurrencyService) {
        // настройка контроллера
        $scope.jQuery = jQuery.noConflict();

        var self = this;

        self.currency = {
            currency: null ,
            currencies:  []
        };

        fetchAllCurrencies();

        function fetchAllCurrencies() {

            CurrencyService.fetchAllCurrencies()
                .then(
                function (d) {
                    self.currency.currencies = d;
                    console.log('self.guide.guides = ',self.currency.currencies);
                },
                function (errResponse) {
                    console.error('Error while fetching Tours in controller');
                }
            );
        }

    }]);

