<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/product.css">
		<title>商品一覧</title>
	</head>
	<body>
		<s:include value="header.jsp" />
		<div class="contentForm">
			<h1>商品一覧画面</h1>

			<s:if test="!#session.keywordsErrorMessageList.isEmpty()">
						<s:iterator value="#session.keywordsErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
			</s:if>
			<!-- productInfoDtoListがnullだったら検索結果なしと表示 -->
			<s:elseif test="productInfoDtoList==null">
				<div id = "info">
					検索結果がありません。
				</div>
			</s:elseif>
			<!-- リストに情報が入っている場合 -->
			<s:else>
				<div id = "product_list">
					<!-- List内の商品すべて、以下の通りの情報を表示する -->
					<div class = "product_list_box">
						<ul>
							<s:iterator value="#session.productInfoDtoList">
								<li><a href ='<s:url action = "ProductDetailsAction">
								<s:param name= "productId" value="%{productId}"/>
								</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
								class=	"item_image_box_200"/></a>
								<a><s:property value="productName"/></a><br>
								<a><s:property value="productNameKana"/><br></a>
								<a><s:property value="price"/>円</a></li>
							</s:iterator>
						</ul>
					</div>
				</div>
				<!-- ページ数の表示_ページ数をクリックした際のアクションと送信するパラメーター情報に関して -->
				<div class="page">
					<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
						<s:if test = "#session.currentPageNumber == #pageNo.count">
							<s:property value = "%{#pageNo.count}"/>
						</s:if>
						<s:else>
							<a href = "<s:url action='SearchItemAction'><s:param name='pageNo' value='%{#pageNo.count}'/>
							<s:param name='categoryId' value='%{category}'/><s:param name='keywords' value='%{keywords}'/>
							</s:url>"><s:property value="%{#pageNo.count}"/></a>
						</s:else>
					</s:iterator>
				</div>
			</s:else>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>