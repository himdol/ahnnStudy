let detail = (function () {
    return {
        init: function () {
            bind.page();
        }
    };
}());

let __replyTable = document.getElementById("reply-table");

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
                    alert("성공");
                    showContents(xhr.response);
                } else {
                    alert("데이터 불러오는데 실패 했습니다.");
                }
            }
            xhr.send(JSON.stringify(replyDto));
        }
    }
}());

let reply = (function () {
    const xhr = new XMLHttpRequest();
    return {
        saved : function () {
            const replyComment = document.getElementById("reply-box").value;

            const jsonData = {
                "seq" : seq,
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
                    alert("성공");
                    location.reload();
                } else {
                    alert(this.status);
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

function showContents(data) {

    for (let [index, value] of data.entries()) {
        let tr = __replyTable.insertRow();
        tr.insertCell(0).innerText = value.replyComment;
        tr.insertCell(1).innerText = value.createBy;
        tr.insertCell(2).innerText = value.replyWriter;
        tr.insertCell(3).innerText = value.createDate;
        tr.insertCell(4).innerHTML ="<div class=\"btn-group\">\n" +
                                                "<button className=\"btn btn-outline-primary reply-modify\" type=\"button\">MODIFY</button>\n"+
                                                "<button className=\"btn btn-outline-primary reply-deleted\" type=\"button\">DELETE</button>\n"+
                                            "</div>"
    }

}

window.onload = function () {
    detail.init();
}