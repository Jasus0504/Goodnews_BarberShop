	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">	
<head>
 <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GoodNews BarberShop Database</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        h5 {
            margin: 10px 0;
        }

        a {
            text-decoration: none;
            color: #007BFF;
            transition: color 0.3s;
        }

        a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>✝️ GoodNews BarberShop Database 💈</h1>
    
     <h4 id ="login"><a href="login.do">로그인 </a></h4> <h4 id ="logout"> <a href="logout.do">로그아웃</a></h4>
	
    <h2><a href="m_insert.do">신규회원</a></h2>
    <h2><a href="m_selectAll.do">전체회원</a></h2>
    <h2><a href="r_selectAll.do">사용내역</a></h2>

    
    <script type="text/javascript">
    
    if ('${id}' === 'sola') {
        $('#login').hide();
    } else {
        $('#login').show();
        $('#logout').hide();
    }
</script>
</body>
		</html>


