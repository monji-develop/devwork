package com.internousdev.i1810b.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.CartInfoDAO;
import com.internousdev.i1810b.dao.ProductInfoDAO;
import com.internousdev.i1810b.dto.CartInfoDTO;
import com.internousdev.i1810b.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{

	private int productId;
	private String productCount;
	private Map<String, Object> session;

	public String execute() {
		String result=ERROR;
		String userId = null;
		String tempUserId = null;

		//session_timeoutしていたらホームへ遷移
		if(!session.containsKey("logined")){
				result = "login";
				return result;
		}

		//デベロッパーツールでの数値の書き換え対策
		//productCountが５以上の時、商品詳細画面へ戻る
		if(Integer.parseInt(productCount)>5){
			result = "goproduct";
			return result;
		}

		//checkListErrorMessageListをsessionから消去
		if(session.containsKey("checkListErrorMessageList")){
			session.remove("checkListErrorMessageList");
		}

		//userIdの設定
		if(session.containsKey("loginId")) {
			userId = String.valueOf(session.get("loginId"));
		}
		if (!(session.containsKey("loginId")) && session.containsKey("tempUserId")) {
			userId = String.valueOf(session.get("tempUserId"));
			tempUserId = String.valueOf(session.get("tempUserId"));
		}


		//渡されたprodctIdでDBから商品情報を取得
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		productInfoDTO = productInfoDAO.getProductInfo(productId);
		session.put("price", productInfoDTO.getPrice());

		//選択された商品情報をDB（cart_infoテーブル）に登録
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		int count = cartInfoDao.regist(userId, tempUserId, productId, productCount, productInfoDTO.getPrice());
		if(count > 0) {
			result=SUCCESS;
		}

		//カート情報の更新
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
		cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
		if(!(iterator.hasNext())) {
			cartInfoDtoList = null;
		}
		session.put("cartInfoDtoList", cartInfoDtoList);

		int totalPrice = cartInfoDao.getTotalPrice(userId);
		session.put("totalPrice", totalPrice);

		return result;
	}


	public int getProductId() {
	    return productId;
	}
	public void setProductId(int productId) {
	    this.productId = productId;
	}

	public String getProductCount() {
	    return productCount;
	}
	public void setProductCount(String productCount) {
	    this.productCount = productCount;
	}

	public Map<String,Object> getSession() {
	    return session;
	}
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}



}
