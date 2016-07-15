(function() {
  'use strict';

  angular
    .module('web')
    .factory('MainService', MainService);

  function MainService($http, urlSrv) {
    var vm = this;

    $http.post(urlSrv + 'transferir');
  }
})();
