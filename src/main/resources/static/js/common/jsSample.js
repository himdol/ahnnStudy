let __COMMON = com.project.name.common;

// 전역변수
let __STATIC_VALUE = "";

// 시작부분
let init = function () {
    main.init();
};

// 메인함수 정의
let main = (function () {
   return {
       init : function () {
           bind.eventBind();
           bind.dataBind();
       }
   }
});

// 바인딩 함수 정의
let bind = (function () {
   return {
       // sample 이벤트 바인딩
       eventBind : function () {
           event.clickAddName();
       }
   }
});