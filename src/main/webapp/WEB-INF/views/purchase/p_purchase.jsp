<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<jsp:include page="../css.jsp"></jsp:include>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
	console.log("onload...");
	
	$.ajax({
		url: "json_m_selectOne.do",
		data: { m_num: '${param.m_num}' },
		method: 'GET',
		dataType: 'json', 
		success: function(vo2) {
			console.log(vo2);
			
			 $("#m_name").val(vo2.m_name);
			 $("#m_cash").val(vo2.m_cash);
			 $("#m_num").val(vo2.m_num);
			
			let tag_vo2 = `
					<tr>		
						<td>\${vo2.m_num}</td>
						<td>\${vo2.m_name}</td>
						<td>\${vo2.m_type}</td>
						<td>\${vo2.m_cash}</td>
						<td>\${vo2.m_info}</td>
						<td>\${vo2.m_date}</td>					
					</tr>
				`;
			
			
			$("#vo2").html(tag_vo2);
		},
		error: function(xhr, status, error) {
			console.log('xhr.status:', xhr.status);
		}
	});
});

</script>
</head>
<body>
<h1>
	결제하기
</h1>
<form name="frm" action="p_purchaseOK.do" method="post"
					onsubmit="return validateForm()" enctype="multipart/form-data">
					
					<div class="mb-3 row">
						<span class="notice">회원번호</span>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="m_num" name="m_num" readonly>
						</div>												
					</div>
					
					
					<div class="mb-3 row">
						<span class="notice">이름</span>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="m_name" name="m_name" readonly>
						</div>												
					</div>
					
					<div class="mb-3 row">
						<span class="notice">보유금액</span>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="m_cash" name="m_cash" readonly>
						</div>												
					</div>
																																				
					
					<div class="mb-3 row">
						<span class="notice">결제금액</span>						
						<div class="col">
							<input class="form-control" id="cost" name="cost">
						</div>				
					</div> 
					
							
					<div class="mb-3 row">
						<span class="notice">결제 후 남은 금액</span>						
						<div class="col">
							<input class="form-control" id="remain" name="remain">
						</div>				
					</div> 
									
		
					<input class="btn btn-primary w-100 py-2" type="submit" value="결제하기" style="margin-bottom:10%">																																									
				</form>	



</body>
<script type="text/javascript">
    $(document).ready(function () {
        // "cost" 입력 필드에 입력 이벤트 리스너 추가
        $("#cost").on("input", function () {
            // "m_cash"와 "cost"의 값을 가져옴
            var mCash = parseFloat($("#m_cash").val()) || 0;
            var cost = parseFloat($(this).val()) || 0;

            // "remain" 입력 필드의 값을 "m_cash"에서 "cost"를 뺀 값으로 설정
            $("#remain").val(mCash - cost);
        });
    });
    
    function validateForm() {
        // "remain" 값이 0보다 작은 경우 확인 대화 상자 표시
        if (parseFloat($("#remain").val()) < 0) {
            var confirmResult = confirm("결제금액이 보유금액을 초과합니다. 그래도 계속하시겠습니까?");

            // 사용자가 확인을 선택한 경우 true 반환하여 폼이 제출되도록 함
            if (confirmResult) {
                return true;
            } else {
                // 사용자가 취소를 선택한 경우 false 반환하여 폼 제출 방지
                return false;
            }
        }

        // 추가적인 유효성 검사 로직이 있다면 여기에 추가 가능

        // 모든 유효성 검사를 통과하면 true를 반환하여 폼이 제출되도록 함
        return true;
    }
    
</script>
</html>


