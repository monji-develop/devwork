　<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<link rel="stylesheet" type="text/css" href="./css/common.css">
			<title>ヘッダー</title>
			<script>
				function goLoginAction(){
					document.getElementById("form").action="GoLoginAction";
				}
				function goMyPageAction(){
					document.getElementById("form").action="MyPageAction";
				}
				function goCartAction(){
					document.getElementById("form").action="CartAction";
				}
				function goProductListAction(){
					document.getElementById("categoryId").value=1;
					document.getElementById("form").action="ProductListAction";
				}
				function goLogoutAction(){
					document.getElementById("form").action="LogoutAction";
				}
				function goSearchItemAction(){
					document.getElementById("form_search").action="SearchItemAction";
				}
				/* 	 直接リンク禁止　直接入力された場合は、ホームに戻されます*/
				  var refinfo=document.referrer;
				  if (!(refinfo)){
					   location.href = "HomeAction";
				  }
			</script>
			<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
		</head>
		<body>
			<header>
				<div id="header">
					<div id="top">
						<div id="top_left">
							<h3 id="logo_title">i1810b</h3>
						</div>
						<div id="top_right">
							<s:form id="form">
								<ul id="list_container">
									<li class="lists"><button type="submit" class="submit_btn nav_btn" onclick="goCartAction();" ><i class="fas fa-shopping-cart"></i>カート</button><li>
									<li class="lists"><button type="submit" class="submit_btn nav_btn" onclick="goProductListAction();" ><i class="fas fa-gift"></i>商品一覧</button><li>
									<!-- セッション中のloginedが1ならば，つまりログイン中ならば，マイページボタンを表示 -->
									<s:if test="#session.logined==1">
										<li class="lists"><button type="submit" class="submit_btn nav_btn" onclick="goMyPageAction();" ><i class="fas fa-user-circle"></i>マイページ</button><li>
									</s:if>
									<!-- セッション中のloginedが1ならば，つまりログイン中ならば，ログアアウトボタンを表示 -->
									<s:if test="#session.logined==1">
										<li class="lists"><button type="submit" class="submit_btn nav_btn" onclick="goLogoutAction();" ><i class="fas fa-sign-in-alt"></i>ログアウト</button><li>
									</s:if>
									<s:else>
										<li class="lists"><button type="submit" class="submit_btn nav_btn" onclick="goLoginAction();" ><i class="fas fa-sign-in-alt"></i>ログイン</button><li>
									</s:else>
								</ul>
							</s:form>
						</div>
					</div>
					<div id="bottom">
						<s:form id="form_search">
							<ul id="search_container">
								<li><s:select name="categoryId" list="#session.mCategoryDtoList" listValue="categoryName" listKey="categoryId" class="cs_div select_category" id="categoryId"/></li>
								<li><s:textfield name="keywords" class="txt_keywords search_keywords" placeholder="検索ワード" /></li>
								<li><button type="submit" class="submit_btn search_btn" onclick="goSearchItemAction();" ><i class="fas fa-search"></i></button><li>
							</ul>
						</s:form>
					</div>
				</div>
			</header>
		</body>
	</html>