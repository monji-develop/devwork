<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>パスワード再設定確認</title>
		<link rel="stylesheet" href="./css/reset.css">
	</head>
	<body>
		<s:include value="header.jsp" />
		<!-- コンテントフォームここから -->
		<div class="contentForm resetContent">
			<!-- ページタイトル -->
			<div class="resetTitle">
				<i class="fas fa-unlock-alt"></i>パスワード再設定確認<i class="fas fa-unlock-alt"></i>
			</div>
			<p align="center">登録する内容は以下でよろしいですか？</p>
			<!-- メインフォーム -->
			<div class="mainForm">
				<s:form action="ResetPasswordCompleteAction">
					<table class="vertical_list_table">
						<tr>
							<th scope="row"><s:label value="ログインID"/></th>
							<td><s:property value="loginId" /></td>
						</tr>
						<tr>
							<th scope="row"><s:label value="新しいパスワード"/></th>
							<td><s:property value="concealedPassword" /></td>
						</tr>
					</table>
					<div class="btn_box">
						<s:submit value="送信" class="btn_primary" />
					</div>
				</s:form>
			</div>
		</div>
		<s:include value="footer.jsp" />
	</body>
</html>