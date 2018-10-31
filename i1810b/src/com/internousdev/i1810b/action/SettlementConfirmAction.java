package com.internousdev.i1810b.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.DestinationInfoDAO;
import com.internousdev.i1810b.dto.CartInfoDTO;
import com.internousdev.i1810b.dto.DestinationInfoDTO;
import com.internousdev.i1810b.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute(){

		String result = "login";

		try{

			if(!session.containsKey("logined")){
				return result;
			}

			session.put("settlementFlg", "aiueo");
			session.remove("loginIdErrorMessageList");
			session.remove("passwordErrorMessageList");
			session.remove("loginErrorMessage");

			@SuppressWarnings("unchecked")
			ArrayList<CartInfoDTO> cartInfoDtoList = (ArrayList<CartInfoDTO>) session.get("cartInfoDtoList");
			if(!(cartInfoDtoList==null)){
				//新規宛先情報を登録した時は、すでに買うものが「purchaseHistoryInfoDtoList」がすでに入っているのでif分けている
				if(session.containsKey("loginId")){
					DestinationInfoDAO didao = new DestinationInfoDAO();
					List<DestinationInfoDTO> didtoList = new ArrayList<>();
					try{
						//DB(destination_info)からloginしているアカウントの宛先情報を取り出す
						didtoList = didao.getDestinationInfo(String.valueOf(session.get("loginId")));
						Iterator<DestinationInfoDTO> iterator = didtoList.iterator();
						if(!(iterator.hasNext())){
							didtoList = null;
						}
						//取り出した宛先情報一覧をput
						session.put("destinationInfoDtoList", didtoList);
					}catch (SQLException e){
						e.printStackTrace();
					}
				}

				List<PurchaseHistoryInfoDTO> phidtoList = new ArrayList<PurchaseHistoryInfoDTO>();

				if (!session.containsKey("purchaseHistoryInfoDtoList")) {
					for (int i = 0; i < cartInfoDtoList.size(); i++) {
						//商品情報をset
						PurchaseHistoryInfoDTO phidto = new PurchaseHistoryInfoDTO();
						phidto.setUserId(String.valueOf(session.get("loginId")));
						phidto.setProductId(cartInfoDtoList.get(i).getProductId());
						phidto.setProductName(cartInfoDtoList.get(i).getProductName());
						phidto.setProductNameKana(cartInfoDtoList.get(i).getProductNameKana());
						phidto.setImageFilePath(cartInfoDtoList.get(i).getImageFilePath());
						phidto.setImageFileName(cartInfoDtoList.get(i).getImageFileName());
						phidto.setPrice(cartInfoDtoList.get(i).getPrice());
						phidto.setReleaseCompany(cartInfoDtoList.get(i).getReleaseCompany());
						phidto.setReleaseDate(cartInfoDtoList.get(i).getReleaseDate());
						phidto.setProductCount(cartInfoDtoList.get(i).getProductCount());
						phidto.setSubtotal(cartInfoDtoList.get(i).getSubtotal());
						phidtoList.add(phidto);
					}
					session.put("purchaseHistoryInfoDTOList", phidtoList);


					}
					if(!session.containsKey("loginId")) {
						result = ERROR;
					}else{
						result = SUCCESS;
					}
			}
		}catch (Exception e){
			result = "login";
			return result;
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