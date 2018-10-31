<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規ユーザー登録</title>
		<link rel="stylesheet" type="text/css" href="./css/create.css">
	</head>
	<body>
		<s:include value="header.jsp" />

		<div class="contentForm createContent">
			<div class="pageTitle">アカウント新規登録</div>

			<!-- エラーメッセージの挿入ここから -->
			<div class="errorMessage">
				<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
					<s:iterator value="#session.familyNameErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
					<s:iterator value="#session.firstNameErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
					<s:iterator value="#session.familyNameKanaErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
					<s:iterator value="#session.firstNameKanaErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.emailErrorMessageList.isEmpty()">
					<s:iterator value="#session.emailErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
					<s:iterator value="#session.loginIdErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.passwordErrorMessageList.isEmpty()">
					<s:iterator value="#session.passwordErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
			</div>
			<!-- エラーメッセージの挿入ここまで -->

			<s:form action="CreateUserConfirmAction">
				<div class="mainForm">
					<div class="box">
						<div class="title">姓<span class="hissu">必須</span></div>
						<s:textfield name="familyName" placeholder="姓" class="inputForm" />
					</div>
					<div class="box">
						<div class="title">名<span class="hissu">必須</span></div>
						<s:textfield name="firstName" placeholder="名" class="inputForm" />
					</div>
					<div class="box">
						<div class="title">姓ふりがな<span class="hissu">必須</span></div>
						<s:textfield name="familyNameKana" placeholder="姓ふりがな" class="inputForm" />
					</div>
					<div class="box">
						<div class="title">名ふりがな<span class="hissu">必須</span></div>
						<s:textfield name="firstNameKana" placeholder="名ふりがな" class="inputForm" />
					</div>
					<div class="box">
						<div class="title">性別<span class="hissu">必須</span></div>
						<s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" label="性別" placeholder="性別"/><br>
					</div>
					<div class="box">
						<div class="title">メールアドレス<span class="hissu">必須</span></div>
						<s:textfield name="email" placeholder="メールアドレス" class="inputForm" />
					</div>
					<div class="box">
						<div class="title">ログインID<span class="hissu">必須</span></div>
						<s:textfield name="loginID" placeholder="ログインID" class="inputForm" />
					</div>
					<div class="box">
						<div class="title">パスワード<span class="hissu">必須</span></div>
						<s:password name="password" placeholder="パスワード" class="inputForm" />
					</div>
					<div class="btn_box">
						<button type="submit" class="btn_primary">登録情報を確認</button>
					</div>
				</div>
			</s:form>
		</div>
		<s:include value="footer.jsp" />
	</body>
</html>