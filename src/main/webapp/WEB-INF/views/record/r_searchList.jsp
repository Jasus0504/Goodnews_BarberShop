<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<jsp:include page="../css.jsp"></jsp:include>
<jsp:include page="../top_menu.jsp"></jsp:include>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">

var searchKey = "${param.searchKey}";
var searchWord = "${param.searchWord}";
$(function(){
	console.log("onload...");
	
	$.ajax({
		url: "json_r_searchList.do",
		data: { searchKey: searchKey, searchWord: searchWord },
		method: 'GET',
		dataType: 'json', 
		success: function(data) {
			console.log(data);
			let tag_vo2 = "";
			for (let i = 0; i < data.length; i++) {
				let vo2 = data[i];
				tag_vo2 += `
					<tr>								
						<td>\${vo2.m_name}</td>
						<td>\${vo2.m_num}</td>
						<td>\${vo2.r_cash}</td>
						<td>\${vo2.r_type}</td>
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
	<h1>전체 이용 목록</h1>
	
	
	<form class="my-auto p-2 d-flex justify-content-end" role="search"
						action="m_searchList.do">
						<select name="searchKey" id="searchKey" style="padding-left:6px;border-color:#ced4da;border-top-left-radius:6px; border-bottom-left-radius:6px;border-top-right-radius:0; border-bottom-right-radius:0;">
							<option value="cost">가격</option>													
						</select> 
						<input type="text" name="searchWord" id="searchWord"
							class="form-control" placeholder="맴버십 검색" style="width:50%;border-top-left-radius:0; border-bottom-left-radius:0;">
					</form>
	<table id="memberList">
		<thead>
			<tr>				
				<th>번호</th>
				<th>이름</th>				
				<th>금액</th>
				<th>충전/결제</th>
				<th>결제시간</th>
				
			</tr>
		</thead>
		<tbody id="vo2">
		</tbody>
		<tfoot>			
		</tfoot>	
	</table>
	
</body>
</html>
