define(function(require, exports, module) {
    var $ = require('jquery');
    function modelC(text) {
        $('<p>&nbsp;&nbsp;--model C load</p>').appendTo('#list');
    }

    module.exports = modelC;
});