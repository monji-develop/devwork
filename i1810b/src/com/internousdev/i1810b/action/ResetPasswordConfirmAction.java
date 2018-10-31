package com.internousdev.i1810b.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.UserInfoDAO;
import com.internousdev.i1810b.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware {

	private String loginId;
	private String password;
	private String newPassword;
	private String reConfirmationPassword;
	private String concealedPassword;

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> passwordIncorrectErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordErrorMessageList = new ArrayList<String>();
	private List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();

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
			session.remove("passwordIncorrectErrorMessageList");
			session.remove("newPasswordErrorMessageList");
			session.remove("reConfirmationNewPasswordErrorMessageList");


			InputChecker inputChecker = new InputChecker();

	//		ログインID:1文字以上8文字以下、半角英数字
			loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false);

	//		現在のパスワード:1文字以上16文字以下、半角英数字
			passwordErrorMessageList = inputChecker.doCheck("現在のパスワード", password, 1, 16, true, false, false, true, false, false, false);

	//		新しいパスワード:1文字以上16文字以下、半角英数字
			newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード", newPassword, 1, 16, true, false, false, true, false, false, false);

	//		確認用パスワード:1文字以上16文字以下、半角英数字
			reConfirmationNewPasswordErrorMessageList = inputChecker.doCheck("確認用パスワード", reConfirmationPassword, 1, 16, true, false, false, true, false, false, false);

	//		確認用パスワードが一致しているか検証
			passwordIncorrectErrorMessageList = inputChecker.doPasswordCheck(newPassword, reConfirmationPassword);

			if(loginIdErrorMessageList.size() == 0
			&& passwordErrorMessageList.size() == 0
			&& newPasswordErrorMessageList.size() == 0
			&& reConfirmationNewPasswordErrorMessageList.size() == 0
			&& passwordIncorrectErrorMessageList.size() == 0){

				UserInfoDAO userInfoDAO = new UserInfoDAO();
				if(userInfoDAO.isExistsUserInfo(loginId, password)){
					concealedPassword = userInfoDAO.concealPassword(newPassword);

						result = SUCCESS;
				}else{
					passwordIncorrectErrorMessageList.add("入力されたパスワードが異なります。");
					session.put("passwordIncorrectErrorMessageList", passwordIncorrectErrorMessageList);
				}
			}else{
				session.put("loginIdErrorMessageList", loginIdErrorMessageList);
				session.put("passwordErrorMessageList", passwordErrorMessageList);
				session.put("newPasswordErrorMessageList", newPasswordErrorMessageList);
				session.put("reConfirmationNewPasswordErrorMessageList", reConfirmationNewPasswordErrorMessageList);
				session.put("passwordIncorrectErrorMessageList", passwordIncorrectErrorMessageList);
			}

		}catch(Exception e){
			result = "login";
			return result;
		}

		return result;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getReConfirmationPassword() {
		return reConfirmationPassword;
	}

	public void setReConfirmationPassword(String reConfirmationPassword) {
		this.reConfirmationPassword = reConfirmationPassword;
	}

	public String getConcealedPassword() {
		return concealedPassword;
	}

	public void setConcealedPassword(String concealedPassword) {
		this.concealedPassword = concealedPassword;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
