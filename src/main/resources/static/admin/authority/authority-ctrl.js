app.controller('authority-ctrl', function ($scope, $http, $location){
    $scope.roles = []
    $scope.admin = []
    $scope.authorities = []

    $scope.initialize = function () {
        $http.get('/rest/roles').then(resp =>{
            $scope.roles = resp.data
        })

        //load staff and directors (administrator)
        $http.get('/rest/accounts?admin=true').then(resp =>{
            $scope.admin = resp.data
        })

        //load authorities of staffs and directors
        $http.get('/rest/authorities?admin=true').then(resp =>{
            $scope.authorities = resp.data
        })

    }

    $scope.authority_of = function (acc, role) {
        if ($scope.authorities){
            return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id == role.id)
        }
    }

    $scope.authority_changed = function (acc, role) {
        let authority = $scope.authority_of(acc, role)
        if (authority){
            $scope.revoke_authority(authority)
        } else {
            authority = {account: acc, role: role}
            $scope.grant_authority(authority)
        }
    }
    
    $scope.grant_authority = function (authority) {
        $http.post('/rest/authorities', authority).then(resp =>{
            $scope.authorities.push(resp.data)
            alert("Give authority success!")
        }).catch(err =>{
            console.log("Error", err)
        })
    }
    
    $scope.revoke_authority = function (authority) {
        $http.delete(`/rest/authorities/${authority.id}`).then(resp =>{
            let index = $scope.authorities.findIndex(item => item.id == authority.id)
            $scope.authorities.splice(index, 1)
            alert("Delete authority success!")
        }).catch(err =>{
            console.log("Error", err)
        })
    }

    $scope.initialize();
})