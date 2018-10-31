<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="refresh" content="3; URL='HomeAction'">
		<link rel="stylesheet" href="./css/reset.css">
		<title>パスワード再設定完了</title>
	</head>
	<body>
		<s:include value="header.jsp" />
		<div class="complete">
			<h1>パスワード変更</h1>
			<div class="com_des">
				パスワードを変更しました！
			</div>
		</div>
		<s:include value="footer.jsp" />
	</body>
</html>