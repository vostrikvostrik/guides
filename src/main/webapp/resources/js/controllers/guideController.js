/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 24.02.17
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp')
    .controller('guideController', ['$scope', '$location', '$http', 'GuideService', function ($scope, $location, $http, GuideService) {
        // настройка контроллера
        $scope.jQuery = jQuery.noConflict();


        var self = this;

        self.guide = {
            guide: null ,
            guides:  []
        };

        fetchAllGuides();

        function fetchAllGuides() {

            GuideService.fetchAllGuides()
                .then(
                function (d) {
                    self.guide.guides = d;
                    console.log('self.guide.guides = ',self.guide.guides);
                },
                function (errResponse) {
                    console.error('Error while fetching Tours in controller');
                }
            );
        }


    }]);

