<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.7.0.min.js"></script>
</head>
<body>
<div>
	<div><h1>로그인</h1></div>
	<div>
		<form action="memberLogin.do" id="frm" method="post">
			<tr>
				<th width="150">아 이 디</th>
				<td width="200">				
					<input type="text" id="memberId" name="memberId">
				</td> 
			</tr>
			
			<tr>
				<th width="150">패스워드</th>
				<td>				
					<input type="text" id="memberPassword" name="memberPassword">
				</td>
			</tr>
			
			<button type="submit">로그인</button>
			<button>취소</button>
			
		</form>
	</div>
</div>
</body>
</html>