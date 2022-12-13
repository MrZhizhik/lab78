var app = angular.module('vacancys', []).config(function ($httpProvider) {
    csrftoken = $("meta[name='_csrf']").attr("content");
    csrfheader = $("meta[name='_csrf_header']").attr("content");
    $httpProvider.defaults.headers.common["X-CSRF-TOKEN"] = csrftoken;
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(csrfheader, csrftoken);
    });
});

app.controller("VacancysController", function ($scope, $http) {

    $scope.successGetVacancysCallback = function (response) {
        $scope.vacancysList = response.data;
        $scope.errormessage = "";
    };

    $scope.errorGetVacancysCallback = function (error) {
        console.log(error);
        $scope.errormessage = "Unable to get list of vacancys";
    };

    $scope.getVacancys = function () {
        $http.get('/public/rest/vacancys').then($scope.successGetVacancysCallback, $scope.errorGetVacancysCallback);
    };

    $scope.successDeleteVacancyCallback = function (response) {
        for (var i = 0; i < $scope.vacancysList.length; i++) {
            var j = $scope.vacancysList[i];
            if (j.id === $scope.deletedId) {
                $scope.vacancysList.splice(i, 1);
                break;
            }
        }
        $scope.errormessage = "";
    };

    $scope.errorDeleteVacancyCallback = function (error) {
        console.log(error);
        if (error.status === 405) {
            $scope.errormessage = "You do not have permissions to do that";
        } else
        if (error.status === 403) {
            $scope.errormessage = "You do not have permissions to do that";
        } else
            $scope.errormessage = "Unable to delete vacancy; check if there are any related records exist. Such records should be removed first";
    };

    $scope.deleteVacancy = function (id) {
        $scope.deletedId = id;

        $http.delete('/public/rest/vacancys/' + id).then($scope.successDeleteVacancyCallback, $scope.errorDeleteVacancyCallback);
    };


    $scope.successGetVacancyCallback = function (response) {
        $scope.vacancysList.splice(0, 0, response.data);
        $scope.errormessage = "";
    };

    $scope.errorGetVacancyCallback = function (error) {
        console.log(error);
        $scope.errormessage = "Unable to get information on vacancy number " + $scope.inputnumber;
    };

    $scope.successAddVacancyCallback = function (response) {

        $http.get('/public/rest/vacancys/' + $scope.inputnumber).then($scope.successGetVacancyCallback, $scope.errorGetVacancyCallback);
        $scope.errormessage = "";
    };

    $scope.errorAddVacancyCallback = function (error) {
        console.log(error);
        if (error.status === 405) {
            $scope.errormessage = "You do not have permissions to do that";
        } else
        if (error.status === 403) {
            $scope.errormessage = "You do not have permissions to do that";
        } else
            $scope.errormessage = "Impossible to add new vacancy; check if it's number is unique";
    };

    $scope.addVacancy = function () {
        $http.post('/public/rest/vacancys/' + $scope.inputnumber + "/" + $scope.inputname).then($scope.successAddVacancyCallback, $scope.errorAddVacancyCallback);
    };

});
