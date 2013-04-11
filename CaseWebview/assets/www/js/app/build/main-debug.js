define("./js/app/build/main-debug", [ "./a-debug", "jquery-debug", "./b-debug", "./c-debug", "jquery-migrate-debug" ], function(require, exports, module) {
    var modelA = require("./a-debug");
    var modelB = require("./b-debug");
    modelA();
    modelB();
    require("jquery-migrate-debug");
    $("#list").append("<br>$.migrateMute = " + $.migrateMute);
});

define("./js/app/build/a-debug", [ "jquery-debug" ], function(require, exports, module) {
    var $ = require("jquery-debug");
    function modelA(text) {
        $("<p>model A load</p>").appendTo("#list");
    }
    module.exports = modelA;
});

define("./js/app/build/b-debug", [ "jquery-debug", "./c-debug" ], function(require, exports, module) {
    var $ = require("jquery-debug");
    var modelC = require("./c-debug");
    function modelB(text) {
        $("<p>model B load</p>").appendTo("#list");
        modelC();
    }
    module.exports = modelB;
});

define("./js/app/build/c-debug", [ "jquery-debug" ], function(require, exports, module) {
    var $ = require("jquery-debug");
    function modelC(text) {
        $("<p>&nbsp;&nbsp;--model C load</p>").appendTo("#list");
    }
    module.exports = modelC;
});
