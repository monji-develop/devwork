package com.internousdev.i1810b.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.CartInfoDAO;
import com.internousdev.i1810b.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		String userId = null;
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();

		//session_timeoutしていたらホームへ遷移
		if(!session.containsKey("logined")){
			result = "login";
			return result;
		}


		//checkListErrorMessageListをsessionから消去
		if(session.containsKey("checkListErrorMessageList")){
			session.remove("checkListErrorMessageList");
		}

		//useIdの設定
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}else if(session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
		}

		//カート情報の取得、sessionへ格納
		cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			cartInfoDtoList = null;
		}
		session.put("cartInfoDtoList", cartInfoDtoList);

		//カートの合計金額を取得、sessionへ格納
		int totalPrice = cartInfoDao.getTotalPrice(userId);
		session.put("totalPrice", totalPrice);

		result = SUCCESS;

		return result;
	}


	public Map<String,Object> getSession() {
	    return session;
	}
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}



}
