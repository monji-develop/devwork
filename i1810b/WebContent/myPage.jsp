<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>マイページ</title>
		<link rel="stylesheet" type="text/css" href="./css/myPage.css">
	</head>
	<body>
		<s:include value="header.jsp" />
		<div class="contentForm myContent">
			<div class="pageTitle">会員登録情報</div>
			<table class="table table_lg">
				<tr>
					<th>姓</th>
					<td><s:property value="#session.familyName"/></td>
				</tr>
				<tr>
					<th>名</th>
					<td><s:property value="#session.firstName"/></td>
				</tr>
				<tr>
					<th>姓（ふりがな）</th>
					<td><s:property value="#session.familyNameKana"/></td>
				</tr>
				<tr>
					<th>名（ふりがな）</th>
					<td><s:property value="#session.firstNameKana"/></td>
				</tr>
				<tr>
					<th>性別</th>
					<td><s:if test="#session.sex==0">男性</s:if><s:if test="#session.sex==1">女性</s:if></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:property value="#session.email"/></td>
				</tr>
			</table>
			<div class="btn_box">
				<s:form action="PurchaseHistoryAction">
						<s:submit value="購入履歴" class="btn_primary"/>
				</s:form>
			</div>
		</div>
		<s:include value="footer.jsp" />
	</body>
</html>