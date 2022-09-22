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

let reply = (function () {
    const xhr = new XMLHttpRequest();
    return {
        saved : function () {
            const jsonData = {
                "seq" : 101,
                "highSeq" : seq,
                "dirSeq" : 0,
                "replyWriter" : "TESTER",
                "replyComment" : "TESTER",
                "createDate" : null,
                "createBy" : "himdolJson",
                "modifiedDate" : null,
                "modifiedBy" : "himdolJson",
            };
            const url = '/api/reply/save';
            // xhr.responseType = 'json';
            console.log(JSON.stringify(jsonData));
            xhr.open("POST", url);
            xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8;');
            xhr.onload = function(e) {
                if (this.status == 200) {
                    alert('성공');
                } else {
                    alert('실패');
                }
            }
            xhr.send(JSON.stringify(jsonData));
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
    reply.saved();
});

window.onload = function () {
    detail.init();
}