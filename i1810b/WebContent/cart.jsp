<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/cart.css">
		<title>カート</title>
		<script type="text/javascript">
	 		function goDeleteCartAction() {
		  		document.getElementById("form").action='DeleteCartAction';
	  		}
		</script>
	</head>
	 <body>
	 	<s:include value="header.jsp" />

		<div class="contentForm cartContent">
			<div class="pageTitle">カート</div>

			<!-- エラーメッセージの挿入ここから -->
			<s:if test="#session.checkListErrorMessageList!=null">
					<div class="errorMessage">
						<s:iterator value="#session.checkListErrorMessageList">
							<s:property />
						</s:iterator>
					</div>
			</s:if>
			<!-- エラーメッセージの挿入ここまで -->

			<!-- カート内の商品情報の表示 -->
			<s:if test="#session.cartInfoDtoList.size()>0">
				<p class="titleMessage">カートには以下の商品が入っています</p>
				<s:form id="form1" action="SettlementConfirmAction">
						<s:iterator value="#session.cartInfoDtoList">
							<div class="product_image_checkbox">
								<div class="checkbox">
									<s:checkbox name="checkList" value="checked" fieldValue="%{productId}"/>
								</div>
								<img class="product_image" src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' />
							</div>
							<div class="text">
								<div class="name">
									<div class="product_name_kana">
										<s:property value="productNameKana"/>
									</div>
									<div class="product_name">
										商品名: <s:property value="productName"/>
									</div>
								</div>
								<div class="price_count">
									<div class="price">
										価格:￥<s:property value="price" />
									</div>
									<div class="count">
										(購入数: <s:property value="productCount" />点)
									</div>
								</div>
								<div class="company">
									発売会社 : <s:property value="releaseCompany" /><br>
									発売日 : <s:property value="releaseDate" />
								</div>
								<div class="subtotal">
									合計金額 : ￥<s:property value="subtotal" />
								</div>
							</div>
							<div class="border floatclear"></div>
						</s:iterator>
					<h2 class="totalprice"><s:label value="カート合計金額：￥"/><s:property value="#session.totalPrice"/></h2><br>
					<div class="btn_box">
  						<s:submit value="決済" class="btn_primary"/>
						<s:submit value="削除" class="btn_danger" onclick="this.form.action='DeleteCartAction';"/>
					</div>
				</s:form>
			</s:if>
			<s:else>
				<p>カート情報はありません。</p>
			</s:else>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>
