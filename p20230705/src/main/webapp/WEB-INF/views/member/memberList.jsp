<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>회 원 목 록</h1></div>
	<div>
		<form action="" id="frm" method="post">
			<label>검색할 키 선택</label>
			<select name="key" id="key">
				<option value="name">이름</option>
				<option value="tel">전화번호</option>
				<option value="address">주소</option>
				<option value="all">전체</option>
			</select>
			<input type="text" id="val" name="val">
			<button type="button" onclick="memberSearch()">검색</button>
		</form>
	</div>
	<div>
	<table border="1">
		<thead>
			<tr>
				<th width="150">아이디</th>
				<th width="150">이름</th>
				<th width="150">전화번호</th>
				<th width="200">주소</th>
				<th width="150">가입일자</th>
				<th width="100">권한</th>
				<th width="150">탈퇴일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${members }" var="m">
				<tr>
					<td align="center">${m.memberId}</td>
					<td align="center">${m.memberName}</td>
					<td align="center">${m.memberTel}</td>
					<td>${m.memberAddress}</td>
					<td align="center">${m.memberEdate}</td>
					<td align="center">${m.memberAuthor}</td>
					<td align="center">${m.memberDdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<script type="text/javascript">
	function memberSearch(){
		let key = document.getElementById("key").value;
		let val = document.getElementById("val").value;
		let payload = "key="+key+"&val="+val;
		let url= "ajaxMemberSearchList.do"
		fetch(url,{
			method: "POST",
			headers:{
				"Content-type": "application/x-www-form-urlencoded"
			},
				body:payload
		}).then(response => response.json())
		  .then(json => viewHtml(json));
	}

	function viewHtml(datas){
		<!-- 화면 출력 --> //기존화면을 지우고 넘어온 새로운 데이터를 뿌리기
		document.querySelector('tbody').remove();
		const tbody = document.createElement('tbody');
		tbody.innerHTML = datas.map(data => htmlConvert(data)).join('');
		document.querySelector('table').appendChild(tbody);
	}
	
	function htmlConvert(data){
		console.log(data);
		let t = (data.memberDdate == null)? '' : data.memberDate;
		let str = '<tr>';
			str += '<tr>';
		str +=	'<td align="center">' + data.memberId + '</td>';
		str +=	'<td align="center"> ' + data.memberName + '</td>';
		str +=	'<td align="center">' + data.memberTel + '</td>';
		str +=	'<td>' + data.memberAddress + '</td>';
		str +=	'<td align="center">' + data.memberEdate  + '</td>';
		str +=	'<td align="center">' + data.memberAuthor + '</td>';
		str +=	'<td align="center">' + t + '</td>';
		str +=	'</tr>';
		return str;
	}
</script>
</body>
</html>