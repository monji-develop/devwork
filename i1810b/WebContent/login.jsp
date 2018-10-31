<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
//ブラウザのキャッシュを無効にする。
// Last-Modified(最終更新日) : 本日
// Expires(有効期限)         : 過去日(1970/01/01)
// pragma no-cache           : HTTP1.0仕様に基づく「キャッシュ無効指示」
// Cache-Control no-cache    : HTTP1.1仕様に基づく「キャッシュ無効指示」
java.util.Calendar objCal1=java.util.Calendar.getInstance();
java.util.Calendar objCal2=java.util.Calendar.getInstance();
objCal2.set(1970,0,1,0,0,0);
response.setDateHeader("Last-Modified",objCal1.getTime().getTime());
response.setDateHeader("Expires",objCal2.getTime().getTime());
response.setHeader("progma","no-cache");
response.setHeader("Cache-Control","no-cache");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/login.css">
		<title>ログイン</title>
		<script>
			function goLoginAction(){
				document.getElementById("form").action="LoginAction";
			}
			function goCreateUserAction(){
				document.getElementById("form").action="CreateUserAction";
			}
		</script>
	</head>
	<body>
		<s:include value="header.jsp" />
		<!-- コンテントフォームここから -->
		<div class="contentForm loginContent">
			<!-- ページタイトル -->
			<div class="pageTitle">ログイン</div>
			<!-- エラーメッセージの挿入ここから -->
			<div class="errorMessage">
				<s:if test="!#session.loginErrorMessage.isEmpty()">
						<s:iterator value="#session.loginErrorMessage"><s:property /><br></s:iterator>
				</s:if>
				<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
					<s:iterator value="#session.loginIdErrorMessageList"><s:property /><br></s:iterator>
				</s:if>
				<s:if test="!#session.passwordErrorMessageList.isEmpty()">
					<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
				</s:if>
			</div>
			<!-- エラーメッセージの挿入ここまで -->
			<!-- メインフォーム -->
			<div class="mainForm">
				<s:form id="form" action="LoginAction">
					<div class="box">
						<div class="title">
							ログインID：
						</div>
						<s:if test="#session.savedLoginId==true">
							<s:textfield name="loginId" class="inputForm" placeholder="ログインID" value='%{#session.loginedId}' autocomplete="off"/>
						</s:if>
						<s:else>
							<s:textfield name="loginId" class="inputForm" placeholder="ログインID" autocomplete="off"/>
						</s:else>
					</div>
					<div class="box">
						<div class="title">
							パスワード：
							<p id="resetText" onclick="location.href='resetPassword.jsp'">パスワードの変更</p>
							<%-- <p id="resetText">
								<a href='<s:url action="ResetPasswordAction" />'>パスワードの変更</a>
							</p> --%>
						</div>
							<s:password name="password" class="inputForm" placeholder="パスワード" autocomplete="off"/>
					</div>
					<div class="box">
						<s:if test="#session.savedLoginId==true">
							<s:checkbox name="savedLoginId" checked="checked"/>
						</s:if>
						<s:else>
							<s:checkbox name="savedLoginId"/>
						</s:else>
						<s:label value="ログインID保存"/><br>
					</div>
					<div class="btn_lg_box">
						<s:submit value="ログイン" class="btn_primary" onclick="goLoginAction();"/>
					</div>
				</s:form>
			</div>
			<div class="btn_box">
				<s:form action="CreateUserAction">
					<s:submit value="新規ユーザー登録" class="btn_secondary" />
				</s:form>
			</div>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>