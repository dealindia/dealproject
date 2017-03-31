'use strict';

angular.module('app.services').service('postService', [ '$http', '$q', 'propertiesConstant',
  function ($http, $q, propertiesConstant) {
    this.getPosts = function () {
        var d = $q.defer();

        $http.get(propertiesConstant.API_URL + '/post')
            .then(function success(response) {
                d.resolve(response.data);
            }, function error(response) {
                d.reject(response.status);
            });

        return d.promise;
    };

    this.deletePost = function (id) {
        var d = $q.defer();

        $http.delete(propertiesConstant.API_URL + '/post/' + id)
            .then(function success(response) {
                d.resolve(response.data);
            }, function error() {
                d.reject();
            });

        return d.promise;
    };

    this.savePost = function (post) {
        var d = $q.defer();

        $http.post(propertiesConstant.API_URL + '/post', post)
            .then(function success(response) {
                d.resolve(response.data);
            }, function error() {
                d.reject();
            });

        return d.promise;
    };
}]);