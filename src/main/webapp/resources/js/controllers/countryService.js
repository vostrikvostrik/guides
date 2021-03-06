/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 26.02.17
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp').factory('CityService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8083/settings/catalog/countries';

    var factory = {
        fetchAllCountries: fetchAllCountries
    };

    return factory;

    function fetchAllCountries() {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching countries');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);