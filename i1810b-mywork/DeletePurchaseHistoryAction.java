package com.internousdev.i1810b.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.PurchaseHistoryInfoDAO;
import com.internousdev.i1810b.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware {


	private Map<String,Object> session;

	public String execute(){

		//sessionが切れてたらホームへ
		if(!session.containsKey("logined")){
			String result = "login";
			return result;
		}

		String result = ERROR;
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		int count = purchaseHistoryInfoDAO.deleteAll(String.valueOf(session.get("loginId")));
		if(count > 0){
			List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.getPurchaseHistoryList(String.valueOf(session.get("loginId")));
			Iterator<PurchaseHistoryInfoDTO> iterator = purchaseHistoryInfoDTOList.iterator();
			if(!(iterator.hasNext())){
				purchaseHistoryInfoDTOList = null;
			}

			session.put("purchaseHistoryInfoDTOList", purchaseHistoryInfoDTOList);

			result = SUCCESS;
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
