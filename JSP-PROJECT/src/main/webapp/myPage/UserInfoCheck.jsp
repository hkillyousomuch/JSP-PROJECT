<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��й�ȣ Ȯ��</title>
</head>
<body>
	<c:if test="${not empty param.flag}">
		<c:if test="${not param.flag}">
			<script>
				alert("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			</script>
		</c:if>
	</c:if>
	<h2>��й�ȣ Ȯ��</h2>
    <p style="font-size: 14px; line-height: 22px; letter-spacing: -0.01em; color: #595959;">${userid }���� ������ ����������ȣ�� ���� ��й�ȣ�� �Է��� �ּ���.</p>
    <hr>
    <form action="${pageContext.request.contextPath}/myPage/UserInfoChange.bo" method="post">
        <label for="userpw" style="padding: 12px 10px; font-size: 14px; font-weight: 600;">��й�ȣ</label>
        <input type="password" id="userpw" name="userpw" required placeholder="��й�ȣ�� �Է��� �ּ���.">
        <input type="submit" value="Ȯ��">
    </form>
</body>
</body>
</html>