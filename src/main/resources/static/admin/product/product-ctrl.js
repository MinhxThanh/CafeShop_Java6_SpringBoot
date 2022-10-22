app.controller('product-ctrl', function ($scope, $http, $window){
    $scope.items = []
    $scope.form = {}
    $scope.categories = []
    $scope.categoriesInProduct = {}
    $scope.categoriesInProductList = []
    $scope.message = ""
    $scope.error = ""
    $scope.listCategories = {}
    $scope.getcategoriesInProduct = {}

    $scope.reset = function (){
        $scope.message = ""
        $scope.error = ""
        $scope.listCategories = {}
        $scope.listCategoriesChose = []
        $scope.form = {
            createDate: new Date(),
            available: true,
            image: 'XOsX.gif'
        }
        $scope.getcategoriesInProduct = {}
    }

    $scope.initialize = function (){
        $http.get("/rest/products").then(resp =>{
            $scope.items = resp.data
            $scope.items.forEach(item =>{
                item.createDate = new Date(item.createDate)
            })

        })
        $http.get('/rest/categories').then(resp =>{
            $scope.categories = resp.data
        })
        $http.get('/rest/categoriesInProduct').then(resp =>{
            $scope.categoriesInProductList = resp.data
        })
    }

    $scope.initialize()

    $scope.listCategoriesChose = []
    $scope.edit = function (item) {
        $scope.reset()
        $http.get(`/rest/categories/getAllCategoriesByProductID/${item.id}`).then(resp =>{
            $scope.listCategoriesChose =  angular.copy(resp.data)
            console.log("edit id", resp.data)
        })
        $scope.form = angular.copy(item)
        $(".nav-tabs button:eq(0)").tab('show')
    }

    // $scope.imageChanged = function (files){
    //     let data = new FormData()
    //     data.append('file', files[0])
    //     $http.post('/rest/upload/images', data, {
    //         transformRequest: angular.identity,
    //         headers: {'Content-Type': undefined}
    //     }).then(resp =>{
    //         $scope.form.image = resp.data.name
    //         console.log("name image: ", resp.data.name)
    //     }).catch(err =>{
    //         $scope.error = "The field file exceeds its maximum permitted size of 1048576 bytes!"
    //         console.log('Error', err)
    //     })
    //     blah.src = URL.createObjectURL(event.target.files[0]);
    // }

    $scope.pager = {
        page: 0,
        size: 20,
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

    $scope.create = async function () {
        let CreateProductID = ""
        let item = angular.copy($scope.form)
        console.log("Before: ", item)
        $http.post('/rest/products', item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data)
            CreateProductID = resp.data.id
            console.log("create: ", resp.data.id)
            console.log("CreateProductID: " + CreateProductID)
            // $scope.reset()
            $scope.message = "Save product success!"
            console.log("Product", resp)
        }).catch(err => {
            $scope.error = "Fail to save product!"
            console.log('Error', err)
        })

        await $scope.sleep(500)

        console.log("CreateProductID 1: " + CreateProductID)
        let productID = CreateProductID
        $scope.createCategoriesInProduct(productID)

    }

    $scope.createCategoriesInProduct = function (productID) {
        for (let i = 0; i < $scope.listCategories.id.length; i++) {
            let id = $scope.listCategories.id[i];
            console.log("ID: " + id)
            $scope.categoriesInProduct = {
                product: {id: parseInt(productID)},
                category: {id: parseInt(id)}
            }
            let category = angular.copy($scope.categoriesInProduct)
            $http.post('/rest/categoriesInProduct', category).then(resp => {
                $scope.reset()
                console.log('Success', resp)
            }).catch(err => {
                $scope.error = "Fail to save Category!"
                console.log('Error Category', err)
            })
        }
    }

    $scope.update = async function () {
        let CreateProductID = ""
        let item = angular.copy($scope.form)
        $http.put(`/rest/products/${item.id}`, item).then(resp => {
            let index = $scope.items.findIndex(product => product.id == item.id)
            $scope.items[index] = item
            CreateProductID = resp.data.id
            $scope.message = "Updated success!"
        }).catch(err => {
            $scope.error = "Fail to updated!"
            console.log("Error: ", err)
        })

        await $scope.sleep(500)

        console.log("CreateProductID 1: " + CreateProductID)
        let productID = CreateProductID
        $scope.createCategoriesInProduct(productID)

        await $scope.sleep(500)
        $window.location.reload();
    }

    $scope.delete = function (item){
        $http.delete(`/rest/products/${item.id}`).then(resp =>{
            let index = $scope.items.findIndex(product => product.id == item.id)
            $scope.items.splice(index, 1)
            $scope.reset()
            $scope.message = "Deleted success!"
        }).catch(err =>{
            $scope.error = "Fail to Deleted!"
            console.log("Error: ", err)
        })
    }

    $scope.deleteCategory = function (cid, pid) {
        console.log("Product id: " + pid + " - cate: " + cid)

        $http.get(`/rest/categoriesInProduct/${cid}/${pid}`).then(resp =>{
            $scope.getcategoriesInProduct = resp.data
        })

        $http.delete(`/rest/categoriesInProduct/${cid}/${pid}`).then(resp =>{
            console.log("deleteCategory", resp.data)

            let index = $scope.categoriesInProductList.findIndex(item => item.id == $scope.getcategoriesInProduct.id)
            $scope.categoriesInProductList.splice(index, 1)

            let indexCate2 = $scope.listCategoriesChose.findIndex(item => item.id == cid)
            console.log("indexCate2", indexCate2)
            $scope.listCategoriesChose.splice(indexCate2, 1)
            $scope.message = "Deleted category of product success!"
        }).catch(err =>{
            $scope.error = "Fail to Deleted category of product!"
            console.log("Error: ", err)
        })
    }

    $scope.sleep = function(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }

    $scope.updateSelect= function (category) {
        console.log("0: " + $scope.listCategories.id)
        console.log("-------")
    };
    $scope.reset()
})

