'use strict';

angular.module('app.controllers').controller('PostController',['$rootScope', '$scope', '$location', 'postService', 'messageService',
  function ($rootScope, $scope, $location, postService, messageService) {
    postService.getPosts().then(
        function success(posts) {
            $scope.posts = posts;
           },
        function error(status) {
            if(status === 401) {
                $location.path("/login");
            }
            else {
                messageService.error("POST_GET_FAILURE", "Oooooops something went wrong, please try again");
            }
        });

    $scope.remove = function remove(id) {
        postService.deletePost(id).then(
            function success(response) {
                if (response) {
                    angular.forEach($scope.posts, function (post, index) {
                        if (id == post.id) {
                            $scope.posts.splice(index, 1);
                        }
                    });
                }
            },
            function error() {
                messageService.error("POST_DELETE_FAILURE", "Oooooops something went wrong, please try again");
            });
    };

    $scope.save = function (id) {
        angular.forEach($scope.posts, function (post) {
                if (id == post.id) {
                	postService.savePost(post).then(
                        function success(response) {});
                }
            },
            function error() {
                messageService.error("POST_SAVE_FAILURE", "Oooooops something went wrong, please try again");
            });
    };
   
}]);