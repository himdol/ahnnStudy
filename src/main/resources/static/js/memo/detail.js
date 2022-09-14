let detail = (function () {
    return {
        init: function () {
            bind.page();
        }
    };
}());

let bind = (function () {
    return {
        page: function () {
            console.log("init")
            let xhr = new XMLHttpRequest();
        }
    }
}());

var reply = (function () {
    return {
        saved : function () {
            console.log("saved");
        },
        deleted : function () {
            console.log("deleted");
        },
        modify : function () {
            console.log("modify");
        }
    };
}());

document.getElementById("reply-insert-button").addEventListener("click", function () {
    console.log("click to button");
    reply.saved();
});

window.onload = function () {
    detail.init();
}