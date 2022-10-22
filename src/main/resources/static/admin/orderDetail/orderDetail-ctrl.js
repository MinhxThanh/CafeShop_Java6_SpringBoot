app.controller('orderDetail-ctrl', function ($scope, $http) {
    $scope.items = []
    $scope.orderDetail = {}
    $scope.message = ''
    $scope.error = ''

    $scope.delete = {
        deleteConfirm(item){
            $scope.orderDetail = item
        },
        deleteThis(){
            let item = angular.copy($scope.orderDetail)
            $http.delete(`/rest/orderDetails/${item.id}`).then(resp =>{
                let index = $scope.items.findIndex(i => i.id == item.id)
                $scope.items.splice(index, 1)
                $scope.reset()
                $scope.message = "Delete order detail successfully!"
            }).catch(err => $scope.error = "Error Delete order detail please try again!")

            $('#liveToast').toast('show');
        },
        noDelete(){
            $scope.orderDetail = {}
        }
    }

    $scope.reset = function (){
        $scope.message = ''
        $scope.error = ''
    }

    $scope.pager = {
        page: 0,
        size: 9,
        get count(){
            return Math.ceil(1.0 * $scope.items.length / this.size)
        },
        get length(){
            return $scope.items.length
        },
        first(){
            this.page = 0
        },
        prev(){
            this.page--
            if (this.page < 0)
                this.last()
        },
        next(){
            this.page++
            if (this.page >= this.count)
                this.first()
        },
        last(){
            this.page = this.count - 1
        }
    }

    $scope.initialize = function (){
        $http.get('/rest/orderDetails').then(resp =>{
            $scope.items = resp.data
        }).catch(err => console.log('Err', err))
    }
    $scope.initialize()
})