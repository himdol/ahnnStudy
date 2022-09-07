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
            // tableContents();
            let tr = __memoTable.insertRow(1);
            let cell1 = tr.insertCell(0);
            cell1.innerText = "test";
        }
    };
}());

function tableTitle () {
    let tr = __memoTable.insertRow();

    tr.insertCell(0).innerText = "게시글 번호";
}