window.onload = function () {
    main.init();
};

const __memoTable = document.getElementById("memo-table");

let main = (function () {
    return {
        init: function () {
            bind.tableDataBind();
        }
    };
}());

let bind = (function () {
    return {
        tableDataBind: function () {

            let httpRequest = new XMLHttpRequest();
            httpRequest.open('GET', '/api/index');
            httpRequest.responseType = "json";

            httpRequest.onreadystatechange = () => {
                if (httpRequest.readyState === XMLHttpRequest.DONE) {
                    if (httpRequest.status === 200) {
                        tableTitle();
                        tableContents(httpRequest.response);
                    } else {
                        alert('Request api Error!');
                    }
                }
            };
            httpRequest.send();
        }
    };
}());

function tableTitle() {
    let tr = __memoTable.insertRow();
    tr.insertCell(0).innerText = "게시글 번호";
    tr.insertCell(1).innerText = "게시글 제목";
    tr.insertCell(2).innerText = "게시글 내용";
    tr.insertCell(3).innerText = "게시자";
    tr.insertCell(4).innerText = "생성일";
    tr.insertCell(5).innerText = "생성자";
    tr.insertCell(6).innerText = "수정일";
    tr.insertCell(7).innerText = "수정자";
}

function tableContents(list) {

    for (let [index, value] of list.entries()) {

        let tr = __memoTable.insertRow();
        tr.insertCell(0).innerText = value.memoSeq;
        tr.insertCell(1).innerText = value.memoTitle;
        tr.insertCell(2).innerText = value.memoContent;
        tr.insertCell(3).innerText = value.memoWriter;
        tr.insertCell(4).innerText = value.createDate;
        tr.insertCell(5).innerText = value.createBy;
        tr.insertCell(6).innerText = value.modifiedBy;
        tr.insertCell(7).innerText = value.modifiedDate;

        tr.addEventListener("click", function () {
            const URI = '/memo/detail?memoSeq='+value.memoSeq;
            location.href=URI;
        });

    }
}
