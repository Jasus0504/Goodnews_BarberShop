<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	
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
	충전하기
</h1>
<form name="frm" action="c_chargeOK.do" method="post"
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
						<span class="notice">충전금액</span>						
						<div class="col">
							<input class="form-control" id="cost" name="cost">
						</div>				
					</div> 
					
					<div class="mb-3 row">
						<span class="notice">충전 후 남은 금액</span>						
						<div class="col">
							<input class="form-control" id="remain" name="remain">
						</div>				
					</div> 
									
		
					<input class="btn btn-primary w-100 py-2" type="submit" value="충전하기" style="margin-bottom:10%">																																									
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
            $("#remain").val(mCash + cost);
        });
    });
</script>
</html>


