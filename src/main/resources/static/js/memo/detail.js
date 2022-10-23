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

            const replyDto = {
                "highSeq" : seq,
            };

            let xhr = new XMLHttpRequest();
            const url = '/api/reply/detail';
            xhr.responseType = 'json';
            xhr.open("POST", url);
            xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8;');
            xhr.onload = function() {
                if (this.status == 200) {
                    showContents(xhr.response);



                } else {

                }
            }
            xhr.send(JSON.stringify(replyDto));
        }
    }
}());


document.getElementById("")

let reply = (function () {
    const xhr = new XMLHttpRequest();
    return {
        saved : function () {
            const replyComment = document.getElementById("reply-box").value;

            const jsonData = {
                "seq" : 106,
                "highSeq" : seq,
                "dirSeq" : 0,
                "replyWriter" : "TESTER",
                "replyComment" : replyComment,
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
                    alert(this.status);
                    alert("300");
                    location.reload();
                } else {
                    alert(this.status);
                    alert("300");
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

let showReply

document.getElementById("reply-insert-button").addEventListener("click", function () {
    reply.saved();
});

function showContents(data) {

    for (let i = 0; i < data.length; i++) {
        document.getElementById("reply-row").innerHTML = "<div>hello</div>";

    }


}

window.onload = function () {
    detail.init();
}