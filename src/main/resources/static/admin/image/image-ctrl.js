app.controller("images-ctrl", function ($scope, $http, $window){
    $scope.listProduct = []
    $scope.listImageDescribe = []
    $scope.form = {}
    $scope.listImageDescribeByProductID = []

    $scope.message = ""
    $scope.error = ""
    $scope.ProductName = ""

    $scope.edit = function (item) {
        $scope.reset()
        $scope.ProductName = item.name
        $scope.form = {
            product: {id: item.id}
        }
        $http.get(`/rest/imageDescribe/${item.id}`).then(resp =>{
            $scope.listImageDescribeByProductID = resp.data
            console.log("listImageDescribeByProductID", resp.data)
        }).catch(err => console.log("Error listImageDescribeByProductID", err))

        $(".nav-tabs button:eq(0)").tab('show')
    }

    $scope.imageChanged = function (files){
        let dataImage = new FormData()
        dataImage.append('file', files[0])
        $http.post('/rest/upload/images', dataImage, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp =>{
            $scope.form.image = resp.data.name
            console.log("name image: ", resp.data.name)
            console.log("name image: ", $scope.form.image)
        }).catch(err =>{
            $scope.error = "The field file exceeds its maximum permitted size of 1048576 bytes!"
            console.log('Error', err)
        })

        $scope.preview()
    }

    $scope.preview = function () {
        let fileInput = document.getElementById("file-input");
        let imageContainer = document.getElementById("images");
        let numOfFiles = document.getElementById("num-of-files");

        imageContainer.innerHTML = "";
        numOfFiles.textContent = `${fileInput.files.length} Files Selected`;

        for (i of fileInput.files) {
            let reader = new FileReader();
            let figure = document.createElement("figure");
            let figCap = document.createElement("figcaption");
            let span = document.createElement('span')

            figure.className = "position-relative pip"
            span.className = "remove btn-close position-absolute top-0 start-100 translate-middle"
            figCap.innerText = i.name;
            figure.appendChild(figCap);

            reader.onload = () => {
                let img = document.createElement("img");
                img.setAttribute("src", reader.result);
                figure.insertBefore(img, figCap);
                $(span).insertAfter(figCap)
                $(".remove").click(function () {
                    $(this).parent(".pip").remove();
                    $(this.i).val('')
                });
            }
            imageContainer.appendChild(figure);
            reader.readAsDataURL(i);
        }

    }

    $scope.reset = function () {
        $scope.message = ""
        $scope.error = ""
        $scope.ProductName = ""
        $scope.listImageDescribeByProductID = []
        $scope.form = {}
        document.getElementById("file-input").value = "";
    }

    $scope.delete = async function (item) {
        $http.delete(`/rest/images/${item.id}`).then(resp => {
            let index = $scope.listImageDescribe.findIndex(item => item.product.id == item.id)
            $scope.listImageDescribe.splice(index, 1)
            $scope.reset()
            $scope.message = "Deleted success!"
        }).catch(err => {
            $scope.error = "Fail to Deleted!"
            console.log("Error: ", err)
        })

    }

    $scope.create = function (){
        let item = angular.copy($scope.form)
        let image = $scope.form.image
        console.log("image: " + image)
        $scope.form = {
            image: image,
            product: {id: parseInt(item.product.id)}
        }
        let imageDes = angular.copy($scope.form)
        $http.post('/rest/images', imageDes).then(resp => {
            $scope.reset()
            $scope.listImageDescribe.push(resp.data)
            $scope.message = "Save images product success!"
        }).catch(err =>{
            $scope.error ="Error save images product!"
            console.log("Error: ", err)
        })

    }

    $scope.pager = {
        page: 0,
        size: 10,
        get count(){
            return Math.ceil(1.0 * $scope.listProduct.length / this.size)
        },
        get length(){
            return $scope.listProduct.length
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

    $scope.sleep = function(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }

    $scope.initialize = function (){
        $http.get("/rest/products").then(resp =>{
            $scope.listProduct = resp.data
            $scope.listProduct.forEach(item =>{
                item.createDate = new Date(item.createDate)
            })
        })

        $http.get("/rest/images").then(resp =>{
            $scope.listImageDescribe = resp.data
        })

    }

    $scope.initialize()
})
