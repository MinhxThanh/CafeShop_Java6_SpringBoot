app.controller('category-ctrl', function ($scope, $http, $window) {
    $scope.form = {}
    $scope.items = []

    $scope.message = ""
    $scope.error = ""

    $scope.edit = function (item){
        $scope.reset()
        $scope.form = angular.copy(item)
    }

    $scope.delete = function (item) {
        $http.delete(`/rest/categories/${item.id}`).then(resp =>{
            let index = $scope.items.findIndex(item => item.id == item.id)
            $scope.items.splice(index, 1)
            $scope.reset()
            $scope.message = "Delete category successfully!"
        }).catch(err => $scope.error = "Error Delete category!")
    }

    $scope.update = function (){
        let item = angular.copy($scope.form)
        $http.put(`/rest/categories`, item).then(resp =>{
            let index = $scope.items.findIndex(item => item.id == item.id)
            $scope.items[index] = item
            $scope.reset()
            $scope.message = "Update category successfully!"
        }).catch(err => $scope.error = "Error Update category!")
    }

    $scope.create = function (){
        let item = angular.copy($scope.form)
        $http.post(`/rest/categories`, item).then(resp =>{
            $scope.items.push(resp.data)
            $scope.reset()
            console.log("category1", resp.data)
            $scope.message = "Create category successfully!"
        }).catch(err => {
            $scope.error = "Error create category!"
            console.log("create error:", err)
        })
    }

    $scope.reset = function (){
        $scope.form = {}
        $scope.message = ""
        $scope.error = ""
    }

    $scope.pager = {
        page: 0,
        size: 10,
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
        $http.get(`/rest/categories/getAllCategoriesAndTotalProduct`).then(resp =>{
            $scope.items = resp.data
            console.log("list", resp.data)
        })

    }
    $scope.initialize()
})