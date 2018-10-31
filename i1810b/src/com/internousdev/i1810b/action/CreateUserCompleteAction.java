package com.internousdev.i1810b.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.CartInfoDAO;
import com.internousdev.i1810b.dao.UserInfoDAO;
import com.internousdev.i1810b.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String loginID;
	private String password;
	private String categoryId;
	private Map<String, Object> session;
	public String execute() {

		String result = "login";

		try{

			//sessinが切れてたらホームへ
			if(!session.containsKey("logined")){
					result = "login";
					return result;
			}

			UserInfoDAO UserInfoDao = new UserInfoDAO();

			familyName=String.valueOf(session.get("familyName"));
			firstName=String.valueOf(session.get("firstName"));
			familyNameKana=String.valueOf(session.get("familyNameKana"));
			firstNameKana=String.valueOf(session.get("firstNameKana"));
			email=String.valueOf(session.get("email"));
			loginID=String.valueOf(session.get("loginID"));
			password=String.valueOf(session.get("password"));

			sex=String.valueOf(session.get("sex"));
			if(sex.equals("男性")){
				sex="0";
			}
			else{
				sex="1";
			}


			int count = UserInfoDao.createUser(familyName,firstName,familyNameKana,firstNameKana,sex,email,loginID,password);
			if(count > 0) {
				if(UserInfoDao.login(loginID, password) > 0){
					UserInfoDTO userInfoDTO = UserInfoDao.getUserInfo(loginID, password);
					session.put("loginId", userInfoDTO.getUserId());
					session.put("registFlg", "success");

					CartInfoDAO cartInfoDao = new CartInfoDAO();
					cartInfoDao.linkToLoginId(String.valueOf(session.get("tempUserId")), loginID);
					result = SUCCESS;
				}else{
					return result;
				}
			}
		}catch(NullPointerException e){
			return result;
		}
		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
