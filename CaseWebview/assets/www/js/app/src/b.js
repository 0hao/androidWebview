define(function(require, exports, module) {
    var $ = require('jquery');
    var modelC = require("./c");
    
    function modelB(text) {
        $('<p>model B load</p>').appendTo('#list');
        modelC();
    }

    module.exports = modelB;
    
});