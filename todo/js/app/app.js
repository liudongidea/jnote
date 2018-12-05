define(function(require, exports) {
    var $ = require("jquery");
    var _ = require("underscore");
    var Backbone = require('backbone');
    //配置路由
    var autoRouter = Backbone.Router.extend({
        routes: {
            '': 'home',
            'at/:module/:action(/*condition)': 'loadmodule'
        },
        home: function() {
            this.loadmodule('home', 'index');
        },
        loadmodule: function(md, ac, con) {
            //将参数字符串'a:123/b:456'转换为json对象{a:123, b:456}
            var cj = {};
            if(con && con.indexOf(':') > -1) {
                con.replace(/(\w+)\s*:\s*([\w-]+)/g, function(a, b, c) {
                    b && (cj[b] = c);
                });
            } else {
                cj = con;
            }
            //加载module目录下对应的模块
            require.async(['./module', md, ac].join('/'), function(cb) {
                if(cb) {
                    cb(cj);
                } else {
                    console.log('模块加载失败！');
                }
            })
        }

    });    
    //定义全局变量App
    window.App = {
        Models: {},  
        Views: {},  
        Collections: {},
        initialize: function() {
            new autoRouter();
            Backbone.history.start();
        }  
    };
    exports.run = App.initialize;
})