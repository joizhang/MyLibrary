/**
 * Created by 新林 on 2016/4/28.
 */
'use strict';

angular.module('globalAlert', [])
    .value("alerts", []) //如果不写这个，那么下面的$rootScope.alerts = []就只能是显示一个了
    .factory('commAlertService', ['$rootScope', '$timeout', 'alerts', function($rootScope, $timeout, alerts) {
        return {
            "alertService": function() {
                var alertJson = {};
                $rootScope.alerts = alerts;
                alertJson.add = function(type, msg, time) {
                    console.log('1:' + $rootScope.alerts.length);
                    $rootScope.alerts.push({
                        'type': type,
                        'msg': msg,
                        'close': function() {
                            console.log('2:' + $rootScope.alerts.length);
                            //alertJson.closeAlert(this);
                            $rootScope.alerts.splice($rootScope.alerts.indexOf(alert), 1);
                        }
                    });
                    //如果设置定time的话就定时消失
                    if (time) {
                        $timeout(function() {
                            $rootScope.alerts = [];
                        }, time);
                    }
                };

                alertJson.closeAlert = function(alert) {
                    console.log('2:' + $rootScope.alerts.length);
                    $rootScope.alerts.splice($rootScope.alerts.indexOf(alert), 1);
                };

                return alertJson;
            }
        }
    }])
