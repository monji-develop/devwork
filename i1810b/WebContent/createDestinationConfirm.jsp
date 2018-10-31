<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/create.css">
		<title>宛先情報確認</title>
	</head>
	<body>
		<s:include value="header.jsp" />
		<div class="contentForm createContent">
			<div class="pageTitle">宛先情報確認</div>
			<p class="titleMessage">以下の内容で登録します</p><br>
			<s:form action="CreateDestinationCompleteAction">
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
							<th scope="row"><s:label value="姓かな"/></th>
							<td><s:property value="familyNameKana"/></td>
						</tr>
						<tr class="CUbox">
							<th scope="row"><s:label value="名かな"/></th>
							<td><s:property value="firstNameKana"/></td>
						</tr>
						<tr class="CUbox">
							<th scope="row"><s:label value="性別"/></th>
							<td><s:property value="sex"/><s:hidden name="sex" value="%{sex}"/></td>
						</tr>
						<tr class="CUbox">
							<th scope="row"><s:label value="住所"/></th>
							<td><s:property value="userAddress"/></td>
						</tr>
						<tr class="CUbox">
							<th scope="row"><s:label value="電話"/></th>
							<td><s:property value="telNumber"/></td>
						</tr>
						<tr class="CUbox">
							<th scope="row"><s:label value="メール"/></th>
							<td><s:property value="email"/></td>
						</tr>
					</table>
					<div class="btn_box">
						<s:submit value="登録情報を確定" class="btn_primary"/>
					</div>
				</div>
			</s:form>
		</div>
		<s:include value="footer.jsp" />
	</body>
</html>