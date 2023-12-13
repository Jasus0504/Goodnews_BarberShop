<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<jsp:include page="../css.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../top_menu.jsp"></jsp:include>
<h1>
	회원추가 하기	
</h1>
<form name="frm" action="m_insertOK.do" method="post"
					onsubmit="return validateForm()" enctype="multipart/form-data">
					
					
					<div class="mb-3 row">
						<span class="notice">이름</span>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="m_name" name="m_name" value="">
						</div>												
					</div>
					
																			
					<div class="mb-3 row">
						<span class="notice">특이사항</span>
						<div class="col-sm-9">
							<input class="form-control" name="m_info" id="m_info" value="" oninput="passConfirm()" 
							style="height: 100px">
						</div>								
					</div>								
		
					<input class="btn btn-primary w-100 py-2" type="submit" value="맴버십 등록" style="margin-bottom:10%">																																									
				</form>	



</body>
</html>
