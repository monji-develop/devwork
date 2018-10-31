package com.internousdev.i1810b.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.CartInfoDAO;
import com.internousdev.i1810b.dao.PurchaseHistoryInfoDAO;
import com.internousdev.i1810b.dto.CartInfoDTO;
import com.internousdev.i1810b.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware{
	private String id;
	private String categoryId;
	private Map<String, Object> session;

	public String execute(){

		try{

			//sessinが切れてたらホームへ
			if(!session.containsKey("logined")){
					String result = "login";
					return result;
			}

		  String result = ERROR;

		  @SuppressWarnings("unchecked")
		  List<CartInfoDTO> cartInfoDtoList = (ArrayList<CartInfoDTO>) session.get("cartInfoDtoList");
		  if(session.containsKey("settlementFlg") && (!(cartInfoDtoList==null))){
			  session.remove("settlementFlg");
			  @SuppressWarnings("unchecked")
			  ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = (ArrayList<PurchaseHistoryInfoDTO>)session.get("purchaseHistoryInfoDTOList");
			  session.remove("purchaseHistoryInfoDTOList");

			  //DestinationIdを設定
			  for(int i=0; i<purchaseHistoryInfoDTOList.size(); i++){
				  purchaseHistoryInfoDTOList.get(i).setDestinationId(Integer.parseInt(id));
			  }

			  //決済した商品情報を購入履歴へ登録
			  PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
			  int count = 0;
			  for(int i=0; i<purchaseHistoryInfoDTOList.size(); i++){
				  count += purchaseHistoryInfoDAO.regist(
						String.valueOf(session.get("loginId")),
						purchaseHistoryInfoDTOList.get(i).getProductId(),
						purchaseHistoryInfoDTOList.get(i).getProductCount(),
						purchaseHistoryInfoDTOList.get(i).getDestinationId(),
						purchaseHistoryInfoDTOList.get(i).getSubtotal()
						);
			  }

			  //カート情報を全削除
			  if(count > 0){
				CartInfoDAO cartInfoDAO = new CartInfoDAO();
				count = cartInfoDAO.deleteAll(String.valueOf(session.get("loginId")));
			  //カート情報の更新
				if(count > 0){
					cartInfoDtoList = cartInfoDAO.getCartInfoDtoList(String.valueOf(session.get("loginId")));
					Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
					if(!(iterator.hasNext())){
						cartInfoDtoList = null;
					}
					session.put("cartInfoDtoList", cartInfoDtoList);

					int totalPrice = cartInfoDAO.getTotalPrice(String.valueOf(session.get("loginId")));
					session.put("totalPrice", totalPrice);
					result = SUCCESS;
				}
			  }
			  return result;
		  }else{
			  return LOGIN;
		  }
		}catch (Exception e){
			 String result = "login";
			return result;
		}
	}


	public String getId() {
	    return id;
	}
	public void setId(String id) {
	    this.id = id;
	}

	public String getCategoryId() {
	    return categoryId;
	}
	public void setCategoryId(String categoryId) {
	    this.categoryId = categoryId;
	}

	public Map<String,Object> getSession() {
	    return session;
	}
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}


}
