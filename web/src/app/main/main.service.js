(function() {
  'use strict';

  angular
    .module('web')
    .factory('MainService', MainService);

  function MainService($http, urlSrv, toastr) {

    function transferir(transferencia) {
      $http.post(urlSrv + 'transferir', transferencia, {
          headers: {
            "content-type": "application/json"
          }
        }).success(function(data) {
          toastr.info("Transferencia exitosa");
        })
        .error(function() {

        });
    }

    return {
      transferir: transferir
    };

  }
})();
