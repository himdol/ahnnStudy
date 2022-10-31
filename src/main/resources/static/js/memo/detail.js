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
            let replyComment = document.getElementById("reply-box").value;
            let lastReplyElementLength = document.getElementsByClassName("reply-group").length+1;
            let lastReplyElementNum = 1;


            if(lastReplyElementLength != 1){
                lastReplyElementNum = Number(document.getElementsByClassName("reply-group")[document.getElementsByClassName("reply-group").length-1].getAttribute("value"))+1;
            }

            let jsonData = {
                "ref" : lastReplyElementNum,
                "seq" : lastReplyElementNum,
                "highSeq" : seq,
                "dirSeq" : 0,
                "replyWriter" : "testHimdol",
                "replyComment" : replyComment,
                "createDate" : "",
                "createBy" : "himdolJson",
                "modifiedDate" : "",
                "modifiedBy" : "himdolJson",
            };

            console.log(JSON.stringify(jsonData));
            const url = '/api/reply/save';
            xhr.responseType = 'json';
            xhr.open("POST", url);
            xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8;');
            xhr.onload = function(e) {
                if (this.status == 200) {
                    location.reload();
                } else {
                    alert('실패');
                }
            }
            xhr.send(JSON.stringify(jsonData));
        },
        subSave : function () {
            console.log("subSave");
            let lastReplyElementLength = document.getElementsByClassName("reply-group").length;
            let replyComment = document.getElementById("subReply-add-button").value;
            console.log(replyComment);
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
        if(value.dirSeq == 0) {
            tr.insertCell(0).innerText = value.replyComment;
            tr.insertCell(1).innerText = value.createBy;
            tr.insertCell(2).innerText = value.replyWriter;
            // tr.insertCell(3).innerText = value.createDate;
            tr.insertCell(3).innerHTML ="<div class=\"btn-group reply-group\" value=\""+value.seq+"\">\n" +
                                                    "<button className=\"btn btn-outline-primary reply-add\" id=\"subReply-add-button\" value=\""+value.seq+"\" type=\"button\">대댓글추가</button>\n"+
                                                    "<button className=\"btn btn-outline-primary reply-modify\" id=\"reply-modify\" value=\""+value.seq+"\" type=\"button\">댓글수정</button>\n"+
                                                    "<button className=\"btn btn-outline-primary reply-deleted\" class=\"\" id=\"reply-deleted\" value=\""+value.seq+"\" type=\"button\">댓글삭제</button>\n"+
                                                "</div>"
        } else {
            tr.insertCell(0).innerText = "ㄴ";
            tr.insertCell(1).innerText = value.replyComment;
            tr.insertCell(2).innerText = value.createBy;
            tr.insertCell(3).innerText = value.replyWriter;
            // tr.insertCell(3).innerText = value.createDate;
            tr.insertCell(4).innerHTML ="<div class=\"btn-group reply-group\" value=\""+value.seq+"\">\n" +
                                                    "<button className=\"btn btn-outline-primary reply-modify\" id=\"reply-modify\" value=\""+value.seq+"\" type=\"button\">댓글수정</button>\n"+
                                                    "<button className=\"btn btn-outline-primary reply-deleted\" id=\"reply-deleted\" value=\""+value.seq+"\" type=\"button\">댓글삭제</button>\n"+
                                                "</div>"
        }

    }
}


window.onload = function () {
    detail.init();
}
