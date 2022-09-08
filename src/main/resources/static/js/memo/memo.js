window.onload = function (){
    console.log("이거 들어옴?");
    main.init();
};

const __memoTable = document.getElementById("memo-table");

let main = (function() {
    return {
        init : function () {
            bind.tableDataBind();
        }
    };
}());

let bind = (function() {
    return {
        tableDataBind : function () {
            tableTitle();
            tableContents();
        }
    };
}());

function tableTitle () {
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

function tableContents () {
    //todo : 테이블 컨텐츠 만들기
}

//todo : 제목클릭시 상세페이지로 이동