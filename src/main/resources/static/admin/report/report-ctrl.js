app.controller('report-ctrl', function ($scope, $http){
    $scope.items = []
    $scope.totalPrice = 0
    $scope.totalQuantity = 0

    $scope.initialize = function (){
        $http.get('/rest/report').then(resp =>{
            $scope.items = resp.data
            $scope.totalPrice = resp.data
                .map(item => item.totalPrice)
                .reduce((total, totalPrice) => total += totalPrice, 0)
            $scope.totalQuantity = resp.data
                .map(item => item.quantity)
                .reduce((total, quantity) => total += quantity, 0)
        }).catch(err => console.log('Err', err))
    }
    $scope.initialize()
})
