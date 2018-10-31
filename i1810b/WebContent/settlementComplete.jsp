<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="refresh" content="3;URL='HomeAction'"/>
		<link rel="stylesheet" href="./css/settlement.css">
		<title>決済完了</title>
	</head>
	<body>
	  <s:include value="header.jsp" />
	  <div style="height: 100vh;">
		  <div class="complete" >
		    <h1>決済完了</h1>
		    <div class="com_des">
		    	決済が完了しました<br>
		    	ご注文ありがとうございました
		    </div>
		  </div>
	  </div>
	  <s:include value="footer.jsp"/>
	</body>
</html>