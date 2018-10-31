<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/create.css">
		<title>登録内容確認</title>
	</head>
	<body>
		<s:include value="header.jsp" />
			<div class="contentForm createContent">
				<div class="pageTitle">登録内容確認画面</div>
				<br><p align="center">以下の内容で登録します</p><br>
				<s:form action="CreateUserCompleteAction">
					<div class="mainForm">
						<table>
							<tr class="CUbox">
								<th scope="row"><s:label value="姓"/></th>
								<td><s:property value="familyName"/></td>
							</tr>
							<tr class="CUbox">
								<th scope="row"><s:label value="名"/></th>
								<td><s:property value="firstName"/></td>
							</tr>
							<tr class="CUbox">
								<th scope="row"><s:label value="姓ふりがな"/></th>
								<td><s:property value="familyNameKana"/></td>
							</tr>
							<tr class="CUbox">
								<th scope="row"><s:label value="名ふりがな"/></th>
								<td><s:property value="firstNameKana"/></td>
							</tr>
							<tr class="CUbox">
								<th scope="row"><s:label value="性別"/></th>
								<td><s:property value="sex"/></td>
							</tr>
							<tr class="CUbox">
								<th scope="row"><s:label value="メールアドレス"/></th>
								<td><s:property value="email"/></td>
							</tr>
							<tr class="CUbox">
								<th scope="row"><s:label value="ログインID"/></th>
								<td><s:property value="loginID"/></td>
							</tr>
							<tr class="CUbox">
								<th scope="row"><s:label value="パスワード"/></th>
								<td><s:property value="password"/></td>
							</tr>
						</table>
						<div class="btn_box">
							<s:submit value="登録情報を確定" class="btn_primary" />
						</div>

					</div>
				</s:form>
			</div>
			<s:include value="footer.jsp"/>
	</body>
</html>