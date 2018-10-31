<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>エラー</title>
		<style type="text">
		</style>
		<link rel="stylesheet" type="text/css" href="./css/common.css">
	</head>
	<body>
		<div class="complete">
				<h1>正しい処理がおこなわれませんでした。</h1>
				<div class="com_des">
					<a href='<s:url action = "LogoutAction" />'><span class="first">最初から</span></a>やり直してください。
				</div>
		</div>
	</body>
</html>