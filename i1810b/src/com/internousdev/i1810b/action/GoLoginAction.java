package com.internousdev.i1810b.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction extends ActionSupport implements SessionAware {


	private Map<String, Object> session;

	public String execute(){

		if(!session.containsKey("logined")){
			String result = "login";
			return result;
		}

		session.put("loginIdErrorMessageList", "");
		session.put("passwordErrorMessageList", "");
		session.put("loginErrorMessage", "");
		session.remove("settlementFlg");

		return SUCCESS;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
