<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>購入履歴</title>
		<link rel="stylesheet" href="./css/purchaseHistory.css">
	</head>
	<body>
	<s:include value="header.jsp" />
	<div class="contentForm purchaseContent">
		<div class="pageTitle">購入履歴</div>
		    <!-- 条件分岐：Listに何もない場合はこっち -->
		    <s:if test="purchaseHistoryInfoDTOList.size()>0">
		         <div class="btn_box">
		            <s:form action="DeletePurchaseHistoryAction">
		                <s:submit value="履歴を全削除" class="btn_danger"/>
		            </s:form>
	        	 </div>
	        	<s:iterator value="purchaseHistoryInfoDTOList">
	            	<div class="purchaseDetails">
	                    <!-- 左の画像部分 -->
	                    <div class="left_contents">
	                           <img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'/>
	                    </div>
	                    <!-- テーブル定義 -->
	                    <div class="right_contents">
	                        <table class="purchaseHistory">
	                            <!-- table以下iteratorで繰り返し -->
	                            <!-- ここから右に回りこむ -->
	                            <tr>
	                                <th></th>
	                                <td><s:property value="productNameKana"/></td>
	                            </tr>
	                            <tr>
	                                <th><s:label value="商品名"/></th>
	                                <td><s:property value="productName"/></td>
	                            </tr>
	                            <tr>
	                                <th><s:label value="金額"/></th>
	                                <td>￥<s:property value="price"/></td>
	                            </tr>
	                            <tr>
	                                <th><s:label value="発売会社名"/></th>
	                                <td><s:property value="releaseCompany"/></td>
	                            </tr>
	                            <tr>
	                                <th><s:label value="発売年月日"/></th>
	                                <td><s:property value="releaseDate"/></td>
	                            </tr>
	                        </table>
	                    </div>
	                </div>
	            </s:iterator>
		    </s:if>
		    <!-- 条件分岐:Listの中身が1以上である場合はテーブルを作成 -->
		    <s:else>
		    	<span class="errorMessage">商品購入履歴情報はありません。</span>
		    </s:else>
	</div>
		<s:include value="footer.jsp" />
	</body>
</html>