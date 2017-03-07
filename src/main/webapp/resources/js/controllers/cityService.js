/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 27.02.17
 * Time: 19:51
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp').factory('CityService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8083/settings/catalog/cities';

    var factory = {
        fetchAllCities: fetchAllCities
    };

    return factory;

    function fetchAllCities() {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching cities');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);