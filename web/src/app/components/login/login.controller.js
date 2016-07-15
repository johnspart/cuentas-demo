(function() {
  'use strict';

  angular
    .module('web')
    .controller('LoginController', LoginController);

  /** @ngInject */
  function LoginController($scope, toastr) {
    var vm = this;

    vm.credentials = {
      username: "john.lopez",
      password: "1128434940"
    };
    vm.error = false;
    vm.login = function(form) {
      if (form.$valid)
        toastr.info("Usuario y password correctos");
      else {
        form.$setDirty(true);
        toastr.info("Usuario y/o password erroneos");
      }
    };



  }
})();
