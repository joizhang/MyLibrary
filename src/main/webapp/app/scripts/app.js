/**
 * Created by Administrator on 2016/4/20.
 */
'use strict';

angular.module('MyLibraryApp', [
        'oc.lazyLoad',
        'ui.router',
        'ui.bootstrap',
        'angular-loading-bar',
        'ngSanitize',
        'ngDialog'
    ])
    .config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider', function ($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
        $ocLazyLoadProvider.config({
            debug: false,
            events: true
        });

        $urlRouterProvider.otherwise('/main/index');

        $stateProvider
            .state('main', {
                url: '/main',
                templateUrl: 'app/partials/main.html',
                resolve: {
                    loadMyDirectives: function ($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name: 'MyLibraryApp',
                            files: [
                                'app/scripts/directives/header/header.js',
                                'app/scripts/directives/footer/footer.js',
                                'app/scripts/directives/search/search.js'
                            ]
                        }),
                        $ocLazyLoad.load({
                            name: 'toggle-switch',
                            files: [
                                "app/bower_components/angular-toggle-switch/angular-toggle-switch.min.js",
                                "app/bower_components/angular-toggle-switch/angular-toggle-switch.css"
                            ]
                        }),
                        $ocLazyLoad.load({
                            name: 'ngAnimate',
                            files: ['app/bower_components/angular-animate/angular-animate.js']
                        }),
                        $ocLazyLoad.load({
                            name: 'ngCookies',
                            files: ['app/bower_components/angular-cookies/angular-cookies.js']
                        }),
                        $ocLazyLoad.load({
                            name: 'ngResource',
                            files: ['app/bower_components/angular-resource/angular-resource.js']
                        }),
                        $ocLazyLoad.load({
                            name: 'ngTouch',
                            files: ['app/bower_components/angular-touch/angular-touch.js']
                        })
                    }
                }
            })
            .state('main.index', {
                url: '/index',
                controller: 'IndexController',
                templateUrl: 'app/partials/index.html',
                resolve: {
                    loadMyFiles: function ($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name: 'MyLibraryApp',
                            files: ['app/scripts/controllers/IndexController.js']
                        }),
                        $ocLazyLoad.load({
                            name: 'tm.pagination',
                            files: ['app/js/tm.pagination.js']
                        })
                    }
                }
            })
            .state('main.analysis', {
                url: '/analysis',
                controller: 'AnalysisController',
                templateUrl: 'app/partials/analysis.html',
                resolve: {
                    loadMyFiles: function ($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name: 'MyLibraryApp',
                            files: ['app/scripts/controllers/AnalysisController.js']
                        }),
                        $ocLazyLoad.load({
                            name: 'chart.js',
                            files: [
                                'app/bower_components/angular-chart.js/dist/angular-chart.min.js',
                                'app/bower_components/angular-chart.js/dist/angular-chart.css'
                            ]
                        })
                    }
                }
            })
            .state('main.addBook', {
                url: '/addBook',
                controller: 'AddBookController',
                templateUrl: 'app/partials/addBook.html',
                resolve: {
                    loadMyFiles: function ($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name: 'MyLibraryApp',
                            files: ['app/scripts/controllers/AddBookController.js']
                        })
                    }
                }
            })
            .state('main.bookPhoto', {
                url: '/bookPhoto',
                controller: 'BookPhotoController',
                templateUrl: 'app/partials/bookPhoto.html',
                resolve: {
                    loadMyFiles: function ($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name: 'angular-file-upload',
                            files: ['app/bower_components/angular-file-upload/dist/angular-file-upload.min.js']
                        }),
                        $ocLazyLoad.load({
                            name: 'MyLibraryApp',
                            files: [
                                'app/scripts/directives/preview.js',
                                'app/scripts/controllers/BookPhotoController.js'
                            ]
                        })
                    }
                }
            })
            .state('signin', {
                url: '/signin',
                controller: 'SignInController',
                templateUrl: 'app/partials/signin.html',
                resolve: {
                    loadMyFiles: function ($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name: 'MyLibraryApp',
                            files: ['app/scripts/controllers/SignInController.js']
                        })
                    }
                }
            })
    }]);
