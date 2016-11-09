angular.module('webApp', []).controller('webCtrl', function ($scope) {
    var pagetoIndex = ['homeBtn', 'employmentBtn', 'skillsBtn', 'projectsBtn'];
    $scope.currentIndex = 0;
    $scope.changePage = function (index) {
        $('#' + pagetoIndex[index]).addClass('active');
        $scope.currentIndex = index;
        for(var i = 0; i < pagetoIndex.length; i++) {
            if(i != index) {
                $('#' + pagetoIndex[i]).removeClass('active');
            }
        }
    };
});
