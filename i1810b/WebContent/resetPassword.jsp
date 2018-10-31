<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>パスワード再設定</title>
		<!-- Font Awesome -->
		<link rel="stylesheet" href="./css/reset.css">
		<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
	</head>
	<body>
		<s:include value="header.jsp" />
		<!-- ページコンテントここから -->
		<div class="contentForm resetContent">
			<!-- ページタイトル -->
			<div class="resetTitle">
				<i class="fas fa-unlock-alt"></i>パスワード再設定<i class="fas fa-unlock-alt"></i>
			</div>
			<!-- エラーメッセージの挿入ここから -->
			<div class="errorMessage">
				<s:if test="!session.loginIdErrorMessageList.isEmpty()">
					<s:iterator value="#session.loginIdErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!session.passwordErrorMessageList.isEmpty()">
					<s:iterator value="#session.passwordErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!session.newPasswordErrorMessageList.isEmpty()">
					<s:iterator value="#session.newPasswordErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!session.reConfirmationNewPasswordErrorMessageList.isEmpty()">
					<s:iterator value="#session.reConfirmationNewPasswordErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!session.passwordIncorrectErrorMessageList.size == 0">
					<s:iterator value="#session.passwordIncorrectErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
			</div>
			<!-- エラーメッセージの挿入ここまで -->
			<!-- メインフォーム -->
			<div class="mainForm">
				<s:form action="ResetPasswordConfirmAction">
					<table class="vertical_list_table">
						<tr>
							<th scope="row"><s:label value="ログインID"/></th>
							<td><s:textfield name="loginId" placeholder="ログインID" class="txt" /></td>
						</tr>
						<tr>
							<th scope="row"><s:label value="現在のパスワード"/></th>
							<td><s:password name="password" placeholder="現在のパスワード" class="txt" /></td>
						</tr>
						<tr>
							<th scope="row"><s:label value="新しいパスワード"/></th>
							<td><s:password name="newPassword" placeholder="新しいパスワード" class="txt" /></td>
						<tr>
							<th scope="row"><s:label value="確認用パスワード"/></th>
							<td><s:password name="reConfirmationPassword" placeholder="確認用パスワード" class="txt" /></td>
						</tr>
					</table>
					<div class = "btn_box">
					<s:submit value="確認画面へ" class="btn_primary" />
					</div>
				</s:form>
			</div>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>