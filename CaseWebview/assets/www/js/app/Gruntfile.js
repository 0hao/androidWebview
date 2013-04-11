'use strict';

module.exports = function(grunt) {
    var pkg = grunt.file.readJSON('package.json');

    grunt.initConfig({
        pkg: pkg,
        //传输文件
        transport: {
            app: {
                options: {
                    format: './js/app/build/{{filename}}', //模块标识
                },
                files: [{
                    cwd: 'src', //源代码目录
                    src: '*.js',
                    dest: '.build' //build中转目录
                }]
            }
        },
        //合并
        concat: {
            app: {
                options: {
                    relative: true // this will include relative dependencies
                },
                files: {
                    //合并，筛选出需要的文件到正式目录
                    'build/main.js': ['.build/main.js'],
                    'build/main-debug.js': ['.build/main-debug.js']
                }
            }
        },
        //压缩
        uglify: {
            main: {
                files: {
                    'build/main.js': ['build/main.js']
                }
            }
        },
        //清理文件
        clean: {
            build: ['.build'] //删掉中转目录
        }
    })

    grunt.loadNpmTasks('grunt-cmd-transport');
    grunt.loadNpmTasks('grunt-cmd-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-clean');

    grunt.registerTask('build', ['transport', 'concat', 'uglify', 'clean']);
}