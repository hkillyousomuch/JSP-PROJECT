<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>${userid }'s myPage</title>
</head>
<body>
	<h1>${userid }���� ����������</h1>
	<a href="${pageContext.request.contextPath }/myPage/UserInfoCheck.bo">
		[ȸ������ ����]
	</a><br>
	<a href="${pageContext.request.contextPath }/myPage/OrderList.bo">
		[���� ����]
	</a><br>
	<a href="${pageContext.request.contextPath }/myPage/.bo">
		[���� ����]
	</a><br>
	<a href="${pageContext.request.contextPath }/main/main-page.jsp">
		[���� ������]
	</a><br>
</body>
</html>