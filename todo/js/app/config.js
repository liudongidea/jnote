seajs.config({
    // 激活 shim 插件
    plugins: ['shim'],

    // shim 配置项
    alias: {
        jquery: {
            src: 'jquery/1.9.1/jquery',
            exports: '$'
        },
        underscore: {
            src: 'underscore/1.4.4/underscore',
            exports: '_'
        },
        backbone: {
            src: 'backbone/1.0.0/backbone',
            deps: ['jquery', 'underscore'],
            exports: 'Backbone'
        }
    },
    paths: {
        // app : './js/app/'
    }
});