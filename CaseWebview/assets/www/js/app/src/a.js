define(function(require, exports, module) {
    var $ = require('jquery');
    function modelA(text) {
        $('<p>model A load</p>').appendTo('#list');
    }

    module.exports = modelA;
});