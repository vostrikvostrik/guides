<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    .tourName.ng-valid {
        background-color: lightgreen;
    }

    .tourName.ng-dirty.ng-invalid-required {
        background-color: red;
    }

    .tourName.ng-dirty.ng-invalid-minlength {
        background-color: yellow;
    }

</style>

<div ng-app="guideApp">
    <div ng-controller="tourController as ctrl">

        <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">Создание тура </span></div>
            <div class="formcontainer">
                <form ng-submit="ctrl.submit()" name="tourForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.tour.tourId"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourName">Name</label>

                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.tour.tourName" id="tourName"
                                       class="form-control input-sm" placeholder="Enter tour name" required
                                       ng-minlength="3"/>

                                <div class="has-error" ng-show="tourForm.$dirty">
                                    <span ng-show="tourForm.tourName.$error.required">This is a required field</span>
                                    <span ng-show="tourForm.tourName.$error.minlength">Minimum length required is 3</span>
                                    <span ng-show="tourForm.tourName.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourDescribe">Describe</label>

                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.tour.tourDescribe" id="tourDescribe"
                                       class="form-control input-sm"
                                       placeholder="Enter your Describe. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourStartDate">tourStartDate</label>

                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.tour.tourStartDate"
                                       value="{{ctrl.tour.tourStartDate | date:'yyyy-MM-dd'}}" id="tourStartDate"
                                       class="form-control input-sm" placeholder="Enter tour date start" required
                                       formatDate/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourEndDate">tourEndDate</label>

                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.tour.tourEndDate" id="tourEndDate"
                                       class="form-control input-sm" placeholder="Enter tour date end" required/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourPrice">Price</label>

                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.tour.tourPrice" id="tourPrice"
                                       class="form-control input-sm"
                                       placeholder="Enter your Describe. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourCurrency">Currency</label>

                            <div class="col-md-7">
                                <div ng-controller="currencyController as currencyCtrl">
                                    <select name="repeatCurrency" id="repeatCurrency" ng-model="ctrl.tour.tourCurrency" id="tourCurrency">
                                        <option ng-repeat="currency in currencyCtrl.currency.currencies" ng-selected="ctrl.tour.tourCurrency == currency.currencyId" value="{{currency.currencyId}}">
                                            {{currency.currencyName}}({{currency.currencyCode}} )
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourActive">is Active</label>

                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.tour.tourActive" id="tourActive"
                                       class="form-control input-sm"
                                       placeholder="Enter your Describe. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourGuide">tour Guide</label>

                            <div class="col-md-7">
                                <div ng-controller="guideController as guideCtrl">
                                    <select name="repeatSelect" id="repeatSelect" ng-model="ctrl.tour.tourGuide" id="tourGuide">
                                        <option ng-repeat="guide in guideCtrl.guide.guides" ng-selected="ctrl.tour.tourGuide == guide.userId" value="{{guide.userId}}">
                                            {{guide.userPublicName}}
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourCountry">Country</label>

                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.tour.tourCountry" id="tourCountry"
                                       class="form-control input-sm"
                                       placeholder="Enter your Describe. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourCity">City</label>

                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.tour.tourCity" id="tourCity"
                                       class="form-control input-sm"
                                       placeholder="Enter your Describe. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourType">Type</label>

                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.tour.tourType" id="tourType"
                                       class="form-control input-sm"
                                       placeholder="Enter your Describe. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourPlacesCount">Places count</label>

                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.tour.tourPlacesCount" id="tourPlacesCount"
                                       class="form-control input-sm"
                                       placeholder="Enter your Describe. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourLifeCircle">Tour life circle</label>

                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.tour.tourLifeCircle" id="tourLifeCircle"
                                       class="form-control input-sm"
                                       placeholder="Enter your Describe. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tourUrl">Url</label>

                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.tour.tourUrl" id="tourUrl"
                                       class="form-control input-sm"
                                       placeholder="Enter tour Url. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{!ctrl.tour.tourId ? 'Add' : 'Update'}}"
                                   class="btn btn-primary btn-sm" ng-disabled="tourForm.$invalid">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
                                    ng-disabled="tourForm.$pristine">Reset Form
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>


        <form ng-submit="ctrl.submit()" name="tourForm" class="form-horizontal">
            <input type="hidden" ng-model="ctrl.tour.tourId"/>

            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Tours </span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>ID.</th>
                            <th>Name</th>
                            <th>tourDescribe</th>
                            <th>tourGuideName</th>
                            <th width="20%"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat="tour in ctrl.tours">
                            <td><span ng-bind="tour.tourId"></span></td>
                            <td><span ng-bind="tour.tourName"></span></td>
                            <td><span ng-bind="tour.tourDescribe"></span></td>
                            <td><span ng-bind="tour.tourGuideName"></span></td>
                            <td>
                                <button type="button" ng-click="ctrl.edit(tour.tourId)"
                                        class="btn btn-success custom-width">Edit
                                </button>
                                <button type="button" ng-click="ctrl.remove(tour.tourId)"
                                        class="btn btn-danger custom-width">Remove
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </form>
    </div>
</div>
<script src="<%=request.getContextPath()%>/resources/js/lib/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/controllers/app.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/controllers/tourService.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/controllers/tourController.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/controllers/guideService.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/controllers/guideController.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/controllers/currencyService.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/controllers/currencyController.js"></script>