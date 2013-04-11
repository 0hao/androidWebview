/* seajs config */
seajs.config({
    // 激活 shim 插件
    plugins: ['shim'],

    // shim 配置项
    alias: {
        'zepto': {
            src: 'zepto/zepto',
            exports: '$'
        },
        'backbone': {
            src: 'backbone/backbone',
            deps: ['underscore', 'zepto'],
            exports: 'Backbone'
        },
        'underscore': {
            src: 'underscore/underscore',
            exports: '_'
        },

    },
    paths: {
        //app : '/js/app/'
    }
});