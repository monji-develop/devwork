package com.internousdev.i1810b.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.PurchaseHistoryInfoDAO;
import com.internousdev.i1810b.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;



/*
 * ◆概要
 *
 * マイページからクリックでアクセス可能な「購入履歴」に遷移する為のAction
 * 実行するとPurchaseHistoryDAO/DTOを生成してDBのpurchase_history_infoテーブルから購入情報を受け取り、
 * それをsessionに格納する
 * (なお、この際受け取るのは商品名・ふりがな・商品画像・値段・発売会社名・発売年月日である)
 *
 * 各DTOには1履歴しか格納できないので、リスト管理をしてsessionにはリストを渡す
 *
 * 最後にSUCCESSを返しpurchaseHistory.jspに遷移する
 * */


public class PurchaseHistoryAction extends ActionSupport implements SessionAware{
	//購入履歴1つ1つのDTOを一括管理するListを生成
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList=new ArrayList<PurchaseHistoryInfoDTO>();
	private Map<String,Object> session;

	public String execute(){

		//sessinが切れてたらホームへ
		if(!session.containsKey("logined")){
			String result = "login";
			return result;
		}

		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO=new PurchaseHistoryInfoDAO();
		purchaseHistoryInfoDTOList = null;
		//セッションからloginIdをゲットし、それを引数に対象ユーザーを特定し、DAOのgetPurchaseHistoryListメソッドを実行する
		//loginIdとはpurchase_history_infoテーブルにおけるuser_idを指している
		purchaseHistoryInfoDTOList=purchaseHistoryInfoDAO.getPurchaseHistoryList(String.valueOf(session.get("loginId")));

		return SUCCESS;
	}

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTOList() {
		return purchaseHistoryInfoDTOList;
	}

	public void setPurchaseHistoryInfoDTOList(List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList) {
		this.purchaseHistoryInfoDTOList = purchaseHistoryInfoDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}


}
