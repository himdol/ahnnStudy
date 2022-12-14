let detail = (function () {
    return {
        init: function () {
            bind.page();
        }
    };
}());

window.onload = function () {
    detail.init();
}

let __replyTable = document.getElementById("reply-table");

function showContents(data) {

    for (let [index, value] of data.entries()) {

        let tr = __replyTable.insertRow();
        if(value.dirSeq == 0) {
            tr.insertCell(0).innerText = value.replyComment;
            tr.insertCell(1).innerText = value.createBy;
            tr.insertCell(2).innerText = value.replyWriter;
            // tr.insertCell(3).innerText = value.createDate;
            tr.insertCell(3).colSpan = 3;
            tr.insertCell(3).innerHTML ="<div class=\"btn-group reply-group\" value=\""+value.seq+"\" data-dirSeq=\""+value.dirSeq+"\">\n" +
                                                    "<button className=\"btn btn-outline-primary reply-modify\" id=\"reply-modify"+value.seq+"\" value=\""+value.seq+"\" data-replyNo=\""+value.replyNo+"\" data-dirSeq=\""+value.dirSeq+"\" type=\"button\">댓글수정</button>\n"+
                                                    "<button className=\"btn btn-outline-primary reply-deleted\" class=\"\" id=\"reply-deleted"+value.seq+"\" value=\""+value.seq+"\" data-replyNo=\""+value.replyNo+"\" data-dirSeq=\""+value.dirSeq+"\" type=\"button\">댓글삭제</button>\n"+
                                                "</div>";
                let ttr = __replyTable.insertRow().insertCell();
                ttr.colSpan = 5;
                ttr.innerHTML = "<div className=\"input-group mb-3\" id=\"reply-group\" data-dirSeq=\""+value.dirSeq+"\">\n"+
                                    "<input type=\"text\" class=\"form-control\" id=\"subReply-box"+value.seq+"\"  placeholder=\"답글 추가...\">\n" +
                                    "<button class=\"btn btn-outline-secondary\" id=\"subReply-add-button"+value.seq+"\" value=\""+value.seq+"\"  data-replyNo=\""+value.replyNo+"\"  data-dirSeq=\""+value.dirSeq+"\" type=\"button\">대댓글추가</button>\n"+
                                "</div>";
        } else {
            tr.insertCell(0).innerText = "ㄴ";
            tr.insertCell(1).innerText = value.replyComment;
            tr.insertCell(2).innerText = value.createBy;
            tr.insertCell(3).innerText = value.replyWriter;
            // tr.insertCell(3).innerText = value.createDate;
            tr.insertCell(4).innerHTML ="<div class=\"btn-group reply-group\" value=\""+value.seq+"\" data-dirSeq=\""+value.dirSeq+"\">\n" +
                                                    "<input className=\"btn btn-outline-primary reply-add\" id=\"subReply-add-button"+value.seq+"\" value=\""+value.seq+"\" type=\"hidden\">\n"+
                                                    "<button className=\"btn btn-outline-primary reply-modify\" id=\"reply-modify"+value.seq+"\"  data-replyNo=\""+value.replyNo+"\"  value=\""+value.seq+"\" data-dirSeq=\""+value.dirSeq+"\" type=\"button\">댓글수정</button>\n"+
                                                    "<button className=\"btn btn-outline-primary reply-deleted\" id=\"reply-deleted"+value.seq+"\"  data-replyNo=\""+value.replyNo+"\"  value=\""+value.seq+"\" data-dirSeq=\""+value.dirSeq+"\" type=\"button\">댓글삭제</button>\n"+
                                                "</div>";
        }
        document.getElementById("subReply-add-button"+value.seq).addEventListener("click", function () {
            reply.subSave(this);
        });

        document.getElementById("reply-modify"+value.seq).addEventListener("click", function () {
            reply.modify(this);
        });

        document.getElementById("reply-deleted"+value.seq).addEventListener("click", function () {
            reply.deleted(this);
        });
    }
}



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
        subSave : function (data) {
            let replyComment = document.getElementById("subReply-box"+data.value).value;
            let lastReplyElementLength = document.getElementsByClassName("reply-group").length+1;
            let lastReplyElementNum = 1;

            if(lastReplyElementLength != 1){
                lastReplyElementNum = document.getElementsByClassName("reply-group").length+1
            }

            let jsonData = {
                "ref" : data.value,
                "seq" : lastReplyElementNum,
                "highSeq" : seq,
                "dirSeq" : Number(data.getAttribute("data-dirseq"))+1,
                "replyWriter" : "testHimdol",
                "replyComment" : replyComment,
                "createDate" : "",
                "createBy" : "himdolJson",
                "modifiedDate" : "",
                "modifiedBy" : "himdolJson",
            };

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
        deleted : function (data) {

            let jsonData = {
                "replyNo" : Number(data.getAttribute("data-replyno")),
                "ref" : data.value,
                "seq" : data.value,
                "highSeq" : seq,
                "dirSeq" : Number(data.getAttribute("data-dirseq"))+1,
                "replyWriter" : "testHimdol",
                "replyComment" : "수정",
                "createDate" : "",
                "createBy" : "himdolJson",
                "modifiedDate" : "",
                "modifiedBy" : "himdolJson",
            };

            const url = '/api/reply/delete';
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
        modify : function (data) {

            let jsonData = {
                "replyNo" : Number(data.getAttribute("data-replyno")),
                "ref" : data.value,
                "seq" : data.value,
                "highSeq" : seq,
                "dirSeq" : Number(data.getAttribute("data-dirseq"))+1,
                "replyWriter" : "testHimdol",
                "replyComment" : "수정",
                "createDate" : "",
                "createBy" : "himdolJson",
                "modifiedDate" : "",
                "modifiedBy" : "himdolJson",
            };

            const url = '/api/reply/update';
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

        }
    };
}());

document.getElementById("reply-insert-button").addEventListener("click", function () {
    reply.saved();
});







