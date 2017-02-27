/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 26.02.17
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp').factory('GuideService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8083/guides';

    var factory = {
        fetchAllGuides: fetchAllGuides,
        createGuide: createGuide,
        updateGuide: updateGuide,
        deleteGuide: deleteGuide
    };

    return factory;

    function fetchAllGuides() {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                console.log('get guides', response.data);
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching guides');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createGuide(guide) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, guide)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating guide');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateGuide(guide, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, guide)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating guide');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteGuide(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting guide');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
