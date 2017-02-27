/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 14.02.17
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp')
    .directive("formatDate", function(){
        return {
            require: 'ngModel',
            link: function(scope, elem, attr, modelCtrl) {
                modelCtrl.$formatters.push(function(modelValue){
                    return new Date(modelValue);
                })
            }
        }
    })
    .controller('tourController', ['$scope', '$location', '$http', 'TourService', function ($scope, $location, $http, TourService) {
        // настройка контроллера
        $scope.jQuery = jQuery.noConflict();


        var self = this;
        self.tour = {
            tourId: null,
            tourName: '',
            tourDescribe: '',
            tourStartDate: new Date(),
            tourEndDate: new Date(),
            tourPrice: 0,
            tourCurrency: '',
            tourActive: '',
            tourGuide: 0,
            tourCountry: 0,
            tourCity: 0,
            tourType: 0,
            tourLifeCircle: 0,
            tourPlacesCount: 0,
            tourUrl: null
        };
        self.tours = [];


        self.submit = submit;
        self.edit = edit;
        self.remove = remove;
        self.reset = reset;


        fetchAllTours();

        function fetchAllTours() {

            TourService.fetchAllTours()
                .then(
                function (d) {
                    self.tours = d;
                },
                function (errResponse) {
                    console.error('Error while fetching Tours in controller');
                }
            );
        }

        function createTour(tour) {
            TourService.createTour(tour)
                .then(
                fetchAllTours,
                function (errResponse) {
                    console.error('Error while creating Tour in controller');
                }
            );
        }

        function updateTour(tour, id) {
            TourService.updateTour(tour, id)
                .then(
                fetchAllTours,
                function (errResponse) {
                    console.error('Error while updating Tour in controller');
                }
            );
        }

        function deleteTour(id) {
            TourService.deleteTour(id)
                .then(
                fetchAllTours,
                function (errResponse) {
                    console.error('Error while deleting Tour in controller');
                }
            );
        }

        function submit() {
            if (self.tour.tourId === null) {
                console.log('Saving New Tour in controller', self.tour);
                createTour(self.tour);
            } else {
                updateTour(self.tour, self.tour.tourId);
                console.log('Tour updated with id ', self.tour.tourId);
            }
            reset();
        }

        function edit(id) {
            console.log('id to be edited', id);
            for (var i = 0; i < self.tours.length; i++) {
                console.log('self.tours[i]', self.tours[i]);
                if (self.tours[i].tourId === id) {
                    self.tour = angular.copy(self.tours[i]);
                    break;
                }
            }
        }

        function remove(id) {
            console.log('id to be deleted', id);
            if (self.tour.tourId === id) {//clean form if the user to be deleted is shown there.
                reset();
            }
            deleteTour(id);
        }


        function reset() {
            self.tour = {
                tourId: null,
                tourName: '',
                tourDescribe: '',
                tourStartDate: new Date(),
                tourEndDate: new Date(),
                tourPrice: 0,
                tourCurrency: '',
                tourActive: '',
                tourGuide: 0,
                tourCountry: 0,
                tourCity: 0,
                tourType: 0,
                tourLifeCircle: 0,
                tourPlacesCount: 0,
                tourUrl: null
            };
            $scope.tourForm.$setPristine(); //reset Form
        }

    }]);
