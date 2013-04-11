/* seajs config */
seajs.config({
    debug: true,
    // 激活 shim 插件
    plugins: ['shim'],

    // shim 配置项
    alias: {
        'jquery-debug': {
            src: 'jquery/jquery-debug',
            exports: '$'
        },
        'jquery-migrate-debug': {
            src: 'jquery/jquery-migrate-debug',
            deps: ['jquery-debug']
        }
    },
    paths: {
        //app : '/js/app/'
    }
});