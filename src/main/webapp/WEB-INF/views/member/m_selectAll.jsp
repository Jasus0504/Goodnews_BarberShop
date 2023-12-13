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

$(function(){
	console.log("onload...");
	$.ajax({
		url: "json_m_selectAll.do",
		method: 'GET',
		dataType: 'json', 
		success: function(data) {
			console.log(data);
			let tag_vo2 = "";
			for (let i = 0; i < data.length; i++) {
				let vo2 = data[i];
				tag_vo2 += `
					<tr>		
						<td><a href="m_selectOne.do?m_num=\${vo2.m_num}">\${vo2.m_name}</td>											
						<td>\${vo2.m_cash}</td>
						<td>\${vo2.m_info}</td>								
						<td><a href="c_charge.do?m_num=\${vo2.m_num}">충전하기</td>
						<td><a href="p_purchase.do?m_num=\${vo2.m_num}">결제하기</td>
						<td><a href ="r_selectOne.do?m_num=\${vo2.m_num}">회원 이용목록</a></td>
						<td colspan="5"><a href="m_update.do?m_num=\${vo2.m_num}">회원수정</a>/<a href="#" onclick="confirmDelete(\${vo2.m_num})">회원삭제</a>
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
	<h1>전체 회원 목록</h1>
	
	
	<form class="my-auto p-2 d-flex justify-content-end" role="search"
						action="m_searchList.do">
						<select name="searchKey" id="searchKey" style="padding-left:6px;border-color:#ced4da;border-top-left-radius:6px; border-bottom-left-radius:6px;border-top-right-radius:0; border-bottom-right-radius:0;">
							<option value="name">이름</option>
							<!-- <option value="racket">라켓</option> -->
						</select> 
						<input type="text" name="searchWord" id="searchWord"
							class="form-control" placeholder="맴버십 검색" style="width:50%;border-top-left-radius:0; border-bottom-left-radius:0;">
					</form>
	
	<table id="memberList">
		<thead>
			<tr>				
				<th>이름</th>		
				<th>보유금액</th>
				<th>특이사항</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody id="vo2">
		</tbody>
		<tfoot>			
		</tfoot>	
	</table>
	
</body>

<script type="text/javascript">

function confirmDelete(memberNumber) {
    var confirmResult = confirm("정말 삭제하시겠습니까?");
    if (confirmResult) {
        // 사용자가 확인을 눌렀을 때 실행할 코드
        window.location.href = "m_deleteOK.do?m_num=" + memberNumber;
    }
}
</script>
</html>
