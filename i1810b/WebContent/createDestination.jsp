<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="./css/create.css">
		<title>新規宛先情報入力</title>
	</head>
	<body>
		<s:include value="header.jsp" />
		<div class="contentForm createContent">
			<div class="pageTitle">新規宛先情報入力</div>

			<!-- エラーメッセージの挿入ここから -->
			<div class="errorMessage">
				<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
					<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
				</s:if>
				<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
					<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
				</s:if>
				<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
					<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
				</s:if>
				<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
					<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
				</s:if>
				<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
					<s:iterator value="#session.userAddressErrorMessageList"><s:property /><br></s:iterator>
				</s:if>
				<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
					<s:iterator value="#session.telNumberErrorMessageList"><s:property /><br></s:iterator>
				</s:if>
				<s:if test="!#session.emailErrorMessageList.isEmpty()">
					<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
				</s:if>
			</div>
			<!-- エラーメッセージの挿入ここまで -->

			<p class="titleMessage">下記に必要事項を入力してください</p>
			<s:form action="CreateDestinationConfirmAction">
				<div class="mainForm">
					<div class="box">
						<div class="title">姓<span class="hissu">必須</span></div>
						<s:textfield name="familyName" class="inputForm" />
					</div>
					<div class="box">
						<div class="title">名<span class="hissu">必須</span></div>
						<s:textfield name="firstName" class="inputForm" />
					</div>
					<div class="box">
						<div class="title">姓ふりがな<span class="hissu">必須</span></div>
						<s:textfield name="familyNameKana" class="inputForm" />
					</div>
					<div class="box">
						<div class="title">名ふりがな<span class="hissu">必須</span></div>
						<s:textfield name="firstNameKana" class="inputForm" />
					</div>
					<div class="box">
						<div class="title">性別<span class="hissu">必須</span></div>
						<s:radio name="sex" list="sexList" value="defaultSexValue" label="性別" placeholder="性別"/><br>
					</div>
					<div class="box">
						<div class="title">住所<span class="hissu">必須</span></div>
						<s:textfield name="userAddress" class="inputForm"/>
					</div>
					<div class="box">
						<div class="title">電話番号<span class="hissu">必須</span></div>
						<s:textfield name="telNumber" class="inputForm"/>
					</div>
					<div class="box">
						<div class="title">メールアドレス<span class="hissu">必須</span></div>
						<s:textfield name="email" class="inputForm" />
					</div>
					<div class="btn_box">
						<s:submit value="登録情報確認" class="btn_primary"/>
					</div>
				</div>
			</s:form>
		</div>
		<s:include value="footer.jsp" />
	</body>
</html>
