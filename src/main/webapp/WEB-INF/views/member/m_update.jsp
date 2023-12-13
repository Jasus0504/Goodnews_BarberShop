<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<jsp:include page="../css.jsp"></jsp:include>
<jsp:include page="../top_menu.jsp"></jsp:include>
</head>
<body>
<%-- <jsp:include page="../top_menu.jsp"></jsp:include> --%>
	<h1>회원수정</h1>

	<form action="m_updateOK.do" method="post">
		<table id="memberList">
			<tr>
				<td><label for="m_num">num:</label></td>
				<td><span id="span_num">${vo2.m_num}</span><input type="hidden" id="m_num" name="m_num"
					value="${vo2.m_num}"></td>
			</tr>
			<tr>
				<td><label for="m_name">이름:</label></td>
				<td><input type="text" id="m_name" name="m_name"
					value="${vo2.m_name}"></td>
			</tr>
			<tr>
				<td><label for="m_info">정보:</label></td>
				<td><input type="text" id="m_info" name="m_info"
					value="${vo2.m_info}"></td>
			</tr>	
			<tr>
				<td colspan="2"><input type="submit" value="회원수정완료"></td>
			</tr>
		</table>
	</form>


</body>
</html>