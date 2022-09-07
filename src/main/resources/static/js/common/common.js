let com = {
    project : {
        name : {
            common : {}
        }
    }
};

// ajax 관련 공통 함수 setup
jQuery.ajaxSetup({
	// ajax before send set header, dimmer show
    beforeSend: function(xhr) {
        xhr.setRequestHeader("AJAX", true);
        xhr.setRequestHeader("X-Current-View", location.href);

        jQuery('#dimmerPage').show();
    },
	// ajax complete dimmer hide
    complete: function() {
        jQuery('#dimmerPage').hide();
    }
});

let __SessionExpired = false;

com.project.name.common.ajax = (function() {
    // --------------------------------------------------------------------------------------------------------------------------------------------------------
    // 함수 정의 부분
    // --------------------------------------------------------------------------------------------------------------------------------------------------------

    // --------------------------------------------------------------------------------------------------------------------------------------------------------
    // 객체 정의 부분
    // --------------------------------------------------------------------------------------------------------------------------------------------------------
    return {
        // ajax 데이터 로드
        ajaxLoad: function (p_sUrl, p_para, p_callBack, p_async, p_btn, p_element, p_methodType, p_errorCallBack) {
            //default : {}
            if (typeof p_para === "undefined" || p_para === null || p_para == ""){
                p_para = {};
			}

            //default : 비동기
            if (typeof p_async === "undefined"){
                p_async = true;
			}
			
			//default : 액션 버튼 null, jQuery("#엘리먼트")
            if (typeof p_btn === "undefined" || p_btn === "" || p_btn === null) {	
                p_btn = null;
            } else {
				//버튼 비활성화
                p_btn.attr('disabled', true);
            }

            //default : body
            if (typeof p_element === "undefined"){
                p_element = ".page-content";
			}

            //default : POST
            if (typeof p_methodType === "undefined"){
                p_methodType = "POST";
			}

			
            return (
                jQuery.ajax({
                    url: p_sUrl,
                    type: p_methodType,
                    cache: false,
                    async: p_async,
                    data: JSON.stringify(p_para),
                    contentType: "application/json",
                    dataType: "json",
                    success: function (p_data, p_textStatus, p_jqXHR) {
						//버튼 활성화
                        if (p_btn != null) {
                            p_btn.attr('disabled', false);
                        }

						// TODO start
						// p_data.errorFlag : errorFlag 정의 필요
						// TODO end
                        //오류가 존재하는 경우 : 알림창 표시 후 STOP
                        if (p_data.responseMessage == 'error' && (p_data.errorFlag == 'A' || p_data.errorFlag == 'E')) {
                            alert(p_data.errorMessage);
                            return;
                        }
                        //오류가 존재하는 경우 : 알림창 표시 후 진행
                        else if (p_data.responseMessage == 'error' && p_data.errorFlag == 'M') {
                            alert(p_data.errorMessage);
                        }
                        //오류가 존재하는 경우 : 알림창 표시 후 Callback 실행 - 예를 들면 페이지 이동 처리
                        else if (p_data.responseMessage == 'error' && p_data.errorFlag == 'CALLBACK') {
                            alert(p_data.errorMessage, p_callBack);
                            return;
                        }

                        //callBack 함수가 존재하는 경우
                        if (p_callBack && Object.prototype.toString.call(p_callBack) == '[object Function]') {
                            p_callBack(p_data, p_textStatus, p_jqXHR);
                        }
                    },
                    error: function (p_jqXHR, p_textStatus, p_errorThrown) {
                        // 최초 세션 만료여부 판단이 되었을 경우 중복체크 안되도록 처리
                        if (__SessionExpired == true) {
                            return;
                        }

                        if (p_jqXHR.status == 401) {
                            __SessionExpired = true;
                            alert("인증에 실패 했습니다. 메인 페이지로 이동합니다.");
                            location.href = "/";
                            return;
                        } else if (p_jqXHR.status == 403) {
                            __SessionExpired = true;
                            alert("세션이 만료 되었습니다. 페이지를 새로고침 합니다.");
                            location.reload();
                            return;
                        } else if (p_jqXHR.status == 0) {
                            return;
                        }

                        if (p_btn != null) {
                            p_btn.attr('disabled', false);
                        }

                        if(p_jqXHR.status == 500){
                            alert(p_jqXHR.getResponseHeader("errorMsg"));
                        }else{
                            alert("[AJAX] Sorry for the inconvenience!\r\nCode: " + p_jqXHR.status + "\r\nMessage: " + p_jqXHR.responseText + "\r\nError: " + p_errorThrown);
                        }

                        //callBack 함수가 존재하는 경우
                        if (p_errorCallBack && Object.prototype.toString.call(p_errorCallBack) == '[object Function]') {
                            p_errorCallBack(p_jqXHR, p_textStatus, p_errorThrown);
                        }
                        return;
                    }
                })
            );
        },
        //---------------------------------------------------------------------------------------------------------
    };
}(jQuery));



// 일반적인 공통함수
com.project.name.common.utils = (function() {
    // --------------------------------------------------------------------------------------------------------------------------------------------------------
    // 객체 정의 부분
    // --------------------------------------------------------------------------------------------------------------------------------------------------------
    return {
        //---------------------------------------------------------------------------------------------------------
        // 파라미터 체크 (null이 넘어가지 않도록 함)
        isNull: function (p_para, p_type) {
            let _returnValue;

            //파라미터 값이 없는 경우
            if (jQuery.type(p_para) === "null" || jQuery.type(p_para) === "undefined" || p_para == null || p_para === "") {
                switch (p_type) {
                    //int, float, decimal 등 숫자타입의 경우
                    case "number":
                        _returnValue = 0;
                        break;
                    //문자 타입의 경우, DataTime도 string로 정의
                    case "string":
                        _returnValue = "";
                        break;
					//object 타입
                    case "object":
                        _returnValue = {};
                        break;
                    //값이 없을경우 "-"로 대체한다.
                    case "dash":
                        _returnValue = "-";
                        break;
					//default 공백 문자 처리
                    default :
                        _returnValue = "";
                        break;
                }
            } else {
                _returnValue = p_para;
            }

            return _returnValue;
        },
        //---------------------------------------------------------------------------------------------------------
        // 날짜 데이터 yyyy-MM-dd 형태로 반환
        // p_nonNull : true일 경우는 현재 날짜 반환
        //---------------------------------------------------------------------------------------------------------
        formatDate : function(p_data, p_nonNull){
            p_data = com.project.name.common.utils.isNull(p_data, 'string');
            if(p_nonNull === true && (p_data === null || p_data === "" || p_data.length === 0)){
                // TODO 서버 시간 받기 : let now = getServerTime();
                return new Date().toLocaleDateString().replace(/\./g, '').split(' ').map((v,i)=> i > 0 && v.length < 2 ? '0' + v : v).join('-');
            }
            if(p_data === '-'){
                return p_data;
            }
            return new Date(p_data).toLocaleDateString().replace(/\./g, '').split(' ').map((v,i)=> i > 0 && v.length < 2 ? '0' + v : v).join('-');
        },
        //---------------------------------------------------------------------------------------------------------
        // 숫자만 추출(마이너스 포함)
        onlyNumber: function (p_number) {
            return com.project.name.common.utils.isNull(p_number, "string") !== "" ? String(p_number).replace(/(?!^-)[^0-9.]/g, "") : "0";
        },
        //---------------------------------------------------------------------------------------------------------
    };
}(jQuery));

