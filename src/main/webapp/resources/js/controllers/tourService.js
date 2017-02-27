/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 24.02.17
 * Time: 22:03
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp').factory('TourService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8083/tours';

    var factory = {
        fetchAllTours: fetchAllTours,
        createTour: createTour,
        updateTour: updateTour,
        deleteTour: deleteTour
    };

    return factory;

    function fetchAllTours() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createTour(tour) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, tour)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Tour');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateTour(tour, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Tour');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteTour(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Tour');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
