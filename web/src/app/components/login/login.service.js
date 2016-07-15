(function() {
  'use strict';

  angular
    .module('web')
    .factory('LoginService', LoginService);

  function LoginService($rootScope, $http, $log, $location, urlSrv, toastr) {

    function login(credentials) {

      $http.post(urlSrv + 'login', credentials, {
        headers: {
          "content-type": "application/json"
        }
      }).success(function() {
        $rootScope.authenticate(function() {
          if ($rootScope.authenticated) {
            $log.debug("Login succeeded");
            $location.path("/");
            toastr.info("Bienvenido");
            $rootScope.authenticated = true;
          } else {
            $log.debug("Login failed");
            $location.path("/login");
            toastr.error("Usuario y/o password erroneos");
            $rootScope.authenticated = false;
          }
        });
      }).error(function(data) {
        $location.path("/login");
        toastr.error("Error");
        $rootScope.authenticated = false;
      });

      return $rootScope.authenticated;
    }

    return {
      login: login
    };
  }
})();
