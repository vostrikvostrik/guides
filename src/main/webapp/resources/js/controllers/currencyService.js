/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 26.02.17
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
 */
/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 26.02.17
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp').factory('CurrencyService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8083/currencies';

    var factory = {
        fetchAllCurrencies: fetchAllCurrencies,
        createCurrency: createCurrency,
        updateCurrency: updateCurrency,
        deleteCurrency: deleteCurrency
    };

    return factory;

    function fetchAllCurrencies() {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                console.log('get Currencies', response.data);
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Currencies');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createCurrency(currency) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, currency)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Currency');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateCurrency(currency, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, currency)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Currency');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteCurrency(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Currency');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
