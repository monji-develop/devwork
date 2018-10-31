package com.internousdev.i1810b.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private Map<String, Object> session;

	public String execute(){

		String result;
		UserInfoDAO userInfoDao = new UserInfoDAO();
		String loginedId = String.valueOf(session.get("loginId"));
		boolean savedLoginId = Boolean.valueOf(String.valueOf(session.get("savedLoginId")));

		userInfoDao.logout(loginedId);
		session.clear();
		session.put("savedLoginId", savedLoginId);
		session.put("loginedId", loginedId);

		result = SUCCESS;

		return result;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
