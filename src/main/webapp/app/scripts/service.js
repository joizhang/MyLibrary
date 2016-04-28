/**
 * Created by 新林 on 2016/4/28.
 */
'use strict';

angular.module('MyLibraryService', [])
    .factory('alertService', function ($rootScope) {
        var alertService = {};

        // 创建一个全局的 alert 数组
        $rootScope.alerts = [];

        alertService.add = function (type, msg) {
            $rootScope.alerts.push({
                'type': type, 'msg': msg, 'close': function () {
                    alertService.closeAlert(this);
                }
            });
        };

        alertService.closeAlert = function (alert) {
            alertService.closeAlertIdx($rootScope.alerts.indexOf(alert));
        };

        alertService.closeAlertIdx = function (index) {
            $rootScope.alerts.splice(index, 1);
        };

        return alertService;
    });
