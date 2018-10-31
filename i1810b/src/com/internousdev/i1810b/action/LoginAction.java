package com.internousdev.i1810b.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.CartInfoDAO;
import com.internousdev.i1810b.dao.DestinationInfoDAO;
import com.internousdev.i1810b.dao.MCategoryDAO;
import com.internousdev.i1810b.dao.UserInfoDAO;
import com.internousdev.i1810b.dto.CartInfoDTO;
import com.internousdev.i1810b.dto.DestinationInfoDTO;
import com.internousdev.i1810b.dto.MCategoryDTO;
import com.internousdev.i1810b.dto.PurchaseHistoryInfoDTO;
import com.internousdev.i1810b.dto.UserInfoDTO;
import com.internousdev.i1810b.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private String loginId;
	private String password;
	private boolean savedLoginId;
	private String loginErrorMessage;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;

	public String execute(){

		String result = "login";

		try{

			if(!session.containsKey("logined")){
				result = "login";
				return result;
			}

			result = ERROR;

			session.remove("loginIdErrorMessageList");
			session.remove("passwordErrorMessageList");
			session.remove("loginErrorMessage");

			if(savedLoginId == true){
				session.put("savedLoginId", true);
			}else{
				session.put("savedLoginId", false);
			}

			InputChecker inputChecker = new InputChecker();
			loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false);
			passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false);

			if(loginIdErrorMessageList.size()!= 0
					|| passwordErrorMessageList.size()!= 0){
				session.put("loginIdErrorMessageList", loginIdErrorMessageList);
				session.put("passwordErrorMessageList", passwordErrorMessageList);
				session.put("logined", 0);
				result = ERROR;
			} else {
				UserInfoDAO userInfoDao = new UserInfoDAO();
				if(userInfoDao.isExistsUserInfo(loginId, password)){
					if(userInfoDao.login(loginId, password) > 0){
						UserInfoDTO userInfoDTO = userInfoDao.getUserInfo(loginId, password);
						session.put("loginId", userInfoDTO.getUserId());

						CartInfoDAO cartInfoDao = new CartInfoDAO();

						int count = 0;
						count = cartInfoDao.linkToLoginId(String.valueOf(session.get("tempUserId")), loginId);
						if(count > 0){
							DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
							try{
								List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();
								destinationInfoDtoList = destinationInfoDao.getDestinationInfo(loginId);

								//未ログインから商品購入のためにログインした場合の処理
								List<PurchaseHistoryInfoDTO> phidtoList = new ArrayList<PurchaseHistoryInfoDTO>();
								List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
								CartInfoDAO dao = new CartInfoDAO();
								cartInfoDtoList = dao.getCartInfoDtoList(loginId);

								for (int i = 0; i < cartInfoDtoList.size(); i++) {
									//商品情報をset
									PurchaseHistoryInfoDTO phidto = new PurchaseHistoryInfoDTO();
									phidto.setUserId(loginId);
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

								Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
								if(!(iterator.hasNext())){
									destinationInfoDtoList = null;
								}
								session.put("destinationInfoDtoList", destinationInfoDtoList);
							}catch(SQLException e){
								e.printStackTrace();
							}
							if(!(session.containsKey("settlementFlg"))){
								result = SUCCESS;
							}else{
								result = "settlement";
							}
						}else{
							result = SUCCESS;
						}
					}
					session.put("logined", 1);
				}else{
					loginErrorMessage = "パスワードが異なります。";
					session.put("loginErrorMessage", loginErrorMessage);
					result = ERROR;
				}
			}

			if(!session.containsKey("mCategoryList")){
				MCategoryDAO mCategoryDao = new MCategoryDAO();
				mCategoryDtoList = mCategoryDao.getMCategoryList();
				session.put("mCategoryDtoList", mCategoryDtoList);
			}

		}catch (Exception e){
			result = "login";
			return result;
		}
		return result;
	}


	public String getLoginErrorMessage() {
		return loginErrorMessage;
	}


	public void setLoginErrorMessage(String loginErrorMessage) {
		this.loginErrorMessage = loginErrorMessage;
	}


	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String  loginId){
		this.loginId = loginId;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public boolean isSavedloginId(){
		return savedLoginId;
	}

	public void setSavedLoginId(boolean savedLoginId){
		this.savedLoginId = savedLoginId;
	}

	public List<String> getLoginIdErrorMessageList(){
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList){
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList(){
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList){
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
