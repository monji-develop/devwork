<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>宛先情報選択</title>
		<link rel="stylesheet" href="./css/settlement.css">
	</head>
	<body>
		<s:include value="header.jsp" />
		<div class="goComplete">
			<s:if test="#session.destinationInfoDtoList.size()>0">
				<s:form id="form" action="SettlementCompleteAction" >

					<s:iterator value="#session.destinationInfoDtoList" status="st">
						<div class="Check">
						<table>
							<tr>
								<td>
									<s:if test="#st.index == 0">
										<input type="radio" name="id" checked="checked" value="<s:property value='id'/>"/>
										お届け先情報
									</s:if><s:else>
										<input type="radio" name="id" value="<s:property value='id'/>"/>
										お届け先情報
									</s:else>
								</td>
							</tr>
						</table>
						</div>
						<div class="notCheck">
							<table>
								<tr>
									<td class="left">ふりがな</td>
									<td class="right">
										<s:property value="familyNameKana"/><span>　</span><s:property value="firstNameKana"/><br>
									</td>
								</tr>
								<tr>
									<td class="left">名前</td>
									<td class="right">
										<s:property value="familyName" /><span>　</span><s:property value="firstName" /><br>
									</td>
								</tr>
								<tr>
									<td class="left">住所</td>
									<td class="right">
										<s:property value="userAddress" />
									</td>
								</tr>
								<tr>
									<td class="left">電話番号</td>
									<td class="right">
										<s:property value="telNumber"/>
									</td>
								</tr>
								<tr>
									<td class="left">メール</td>
									<td class="right">
										<s:property value="email"/>
									</td>
								</tr>
							</table>
						</div>
					</s:iterator>
					<div class="btn_box">
						<s:submit value="決済" class="btn_primary"/>
					</div>
				</s:form>
				<div class="btn_box">
					<s:form action="CreateDestinationAction" class="com.internousdev.i1810b.action.CreateDestinationAction">
						<s:submit value="新規宛先登録" class="btn_secondary" />
					</s:form>
				</div>
			</s:if>
			<s:else>
				<div class="errorComment">
					<h1>宛先情報がありません</h1>
				</div>
				<div class="btn_box">
					<s:form action="CreateDestinationAction" class="com.internousdev.i1810b.action.CreateDestinationAction">
						<s:submit value="新規宛先登録" class="btn_secondary" />
					</s:form>
				</div>
			</s:else>
		</div>
		<s:include value="footer.jsp" />
	</body>
</html>