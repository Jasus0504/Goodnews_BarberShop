<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 이용기록</title>
<jsp:include page="../css.jsp"></jsp:include>
<jsp:include page="../top_menu.jsp"></jsp:include>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
	console.log("onload...");
	
	$.ajax({
		url: "json_r_selectOne.do",
		data: {m_num: '${param.m_num}'},
		method: 'GET',
		dataType: 'json', 
		success: function(data) {
			console.log(data);
			let tag_vo2 = "";
			for (let i = 0; i < data.length; i++) {
				let vo2 = data[i];
				tag_vo2 += `
					<tr>		
						<td>\${vo2.m_num}</td>										
						<td>\${vo2.m_name}</td>	
						<td>\${vo2.r_cash}</td>	
						<td>\${vo2.r_type}</td>	
						<td>\${vo2.m_cash}</td>	
						<td>\${vo2.r_date}</td>	
						
					</tr>
				`;
			}
			
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
	<h1>회원정보</h1>
	<table id="memberList">
		<thead>
			<tr>
				<th>가입자 번호</th>
				<th>가입자 이름</th>
				<th>금액</th>
				<th>결제/충전</th>
				<th>보유금액</th>
				<th>결제날짜</th>

			</tr>
		</thead>
		<tbody id="vo2">
		</tbody>
		<tfoot>
		</tfoot>
	</table>

</body>
</html>
