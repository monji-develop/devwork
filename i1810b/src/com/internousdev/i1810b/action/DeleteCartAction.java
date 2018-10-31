package com.internousdev.i1810b.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.CartInfoDAO;
import com.internousdev.i1810b.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware{
	private Collection<String> checkList;
	private Map<String, Object> session;


	public String execute() {
		String result=ERROR;
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		int count = 0;
		List<String> checkListErrorMessageList = new ArrayList<String>();

		//session_timeoutしていたらホームへ遷移
		if(!session.containsKey("logined")){
			result = "login";
			return result;
		}

		//チェックリストにチェックが無いときエラーメッセージを設定
		if(checkList==null) {
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}

		//useIdの設定
		String userId = null;
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
		if(session.containsKey("loginId")) {
			userId = String.valueOf(session.get("loginId"));
		}else if (session.containsKey("tempUserId")) {
			userId = String.valueOf(session.get("tempUserId"));
		}

		//選択された商品情報の削除
		for(String productId:checkList) {
			count += cartInfoDAO.delete(userId, productId);
		}
		if(count <= 0) {
			//商品情報が正しく削除されていなければエラーメッセージを設定
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}else {
			//checkListErrorMessageListをsessionから消去
			if(session.containsKey("checkListErrorMessageList")){
				session.remove("checkListErrorMessageList");
			}

			//削除した後のカート情報の更新
			cartInfoDtoList = cartInfoDAO.getCartInfoDtoList(userId);
			Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
			if(!(iterator.hasNext())) {
				cartInfoDtoList = null;
			}
			session.put("cartInfoDtoList", cartInfoDtoList);

			int totalPrice = cartInfoDAO.getTotalPrice(userId);
			session.put("totalPrice", totalPrice);
		}
		return result;
	}


	public Collection<String> getCheckList() {
	    return checkList;
	}
	public void setCheckList(Collection<String> checkList) {
	    this.checkList = checkList;
	}

	public Map<String,Object> getSession() {
	    return session;
	}
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}



}
