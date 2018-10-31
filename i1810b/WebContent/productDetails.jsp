<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/product.css">
		<title>商品詳細</title>
	</head>
	<body>
		<s:include value="header.jsp" />
		<div class="contentForm productContent">
			<div class = "left_contents">
				<h1>商品詳細</h1>
				<div class="content_img">
					<img src='<s:property value="%{#session.imageFilePath}" />
					/<s:property value="%{#session.imageFileName}" />' />
				</div>
			</div>
			<div class = "right_contents">
				<h1>商品詳細</h1>
				<s:form method = "post" action="AddCartAction">
					<table class = "table table_sm">
						<tr>
							<th>商品名</th>
							<td><s:property value="%{#session.productName}" /></td>
						</tr>
						<tr>
							<th>商品名<br>ふりがな</th>
							<td><s:property value="%{#session.productNameKana}" /></td>
						</tr>
						<tr>
							<th>値段</th>
							<td><s:property value="%{#session.price}" />円</td>
						</tr>
						<tr>
							<th>購入個数</th>
							<td><s:select name="productCount" list="%{#session.productCountList}" /></td>
						</tr>
						<tr>
							<th>発売会社名</th>
							<td><s:property value="%{#session.releaseCompany}" /></td>
						</tr>
						<tr>
							<th>発売年月日</th>
							<td><s:property value="%{#session.releaseDate}" /></td>
						</tr>
						<tr>
							<th>商品詳細情報</th>
							<td><s:property value="%{#session.productDescription}" /></td>
						</tr>
					</table>
					<!-- tokenタグ -->
					<s:token/>
					<div class="btn_box">
						<s:submit class="btn_primary" value="カートに追加" />
					</div>
					<s:hidden name= "productId" value="%{#session.productId}"/>
				</s:form>
			</div>
			<div class="bottom_contents">
				<div class = "relation">
					<p>関連商品</p>
					<ul>
						<s:iterator value="#session.productInfoDtoList">
							<li><a href='<s:url action="ProductDetailsAction">
							<s:param name="productId" value="%{productId}" />
							</s:url>'>
							<img src='<s:property value="imageFilePath" />
							/<s:property value="imageFileName" />'></a>
							<p><s:property value="productName" /></p>
							<p class = "price"><s:property value="%{#session.price}" />円<p></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>