/**
 * Created with IntelliJ IDEA.
 * User: EVostrikova
 * Date: 14.02.17
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
'use strict';

angular.module('guideApp')
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
            tourCurrency: 0,
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

        self.tourActiveStates= [
            {id: 0, describe: 'заблокирован'},
            {id: 1, describe: 'активен'}
        ];

        self.tourLifeCircles = [
           {id: 0, describe: 'тур не начался'},
           {id: 1, describe: 'тур начался'},
           {id:2, describe: 'тур окончен'},
           {id:3, describe: 'тур отменен'}
        ];

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
                if (self.tours[i].tourId === id) {
                    self.tour = angular.copy(self.tours[i]);
                    self.tour.tourStartDate = new Date(self.tour.tourStartDate);
                    self.tour.tourEndDate = new Date(self.tour.tourEndDate);
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
                tourCurrency: 0,
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
