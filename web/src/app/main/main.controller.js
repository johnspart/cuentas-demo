(function() {
  'use strict';

  angular
    .module('web')
    .controller('MainController', MainController);

  /** @ngInject */
  function MainController(toastr) {
    var vm = this;

    vm.cliente = {
      cuenta: '###########',
      saldo: 0.00000,
      valorTrasnferir: 0,
      cuentaTransferir: ''
    };

    vm.transferir = function(form) {
      
    };

  }
})();
