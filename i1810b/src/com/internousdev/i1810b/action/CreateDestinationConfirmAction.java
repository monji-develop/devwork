package com.internousdev.i1810b.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private List<String> sexList = new ArrayList<String>();
	private String sex;
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;
	private String email;
	private String telNumber;
	private String userAddress;

	private List<String> familyNameErrorMessageList = new ArrayList<String>();
	private List<String> firstNameErrorMessageList = new ArrayList<String>();
	private List<String> familyNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> firstNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> emailErrorMessageList = new ArrayList<String>();
	private List<String> telNumberErrorMessageList = new ArrayList<String>();
	private List<String> userAddressErrorMessageList = new ArrayList<String>();

	private String categoryId;
	private Map<String,Object> session;

	public String execute(){

		String result = "login";
		try{

			//sessinが切れてたらホームへ
			if(!session.containsKey("logined")){
				result = "login";
				return result;
			}

			//Confirm通るときにremoveする
			if(session.containsKey("familyName")){
				session.remove("familyName");
				session.remove("firstName");
				session.remove("familyNameKana");
				session.remove("firstNameKana");
				session.remove("userAddress");
				session.remove("email");
			}


			result = ERROR;
			InputChecker ipc = new InputChecker();
			//入力した値をエラーチェック
			familyNameErrorMessageList = ipc.doCheck("姓", familyName, 1, 16, true, true, true, false, false, false, false);
			firstNameErrorMessageList = ipc.doCheck("名", firstName, 1, 16, true, true, true, false, false, false, false);
			familyNameKanaErrorMessageList = ipc.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false, false, false);
			firstNameKanaErrorMessageList = ipc.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false, false);
			userAddressErrorMessageList = ipc.doCheck("住所", userAddress, 15, 50, true, true, true, true, true, true, false);
			telNumberErrorMessageList = ipc.doCheck("電話番号", telNumber, 10, 13, false, false, false, true, false, false, false);
			emailErrorMessageList = ipc.doCheck("メールアドレス", email, 14, 32, true, false, false, true, true, false, false);

			if(familyNameErrorMessageList.size()==0
				&& firstNameErrorMessageList.size()==0
				&&	familyNameKanaErrorMessageList.size()==0
				&&	firstNameKanaErrorMessageList.size()==0
				&&	emailErrorMessageList.size()==0
				&&	telNumberErrorMessageList.size()==0
				&&	userAddressErrorMessageList.size()==0) {

				session.put("familyName", familyName);
				session.put("firstName", firstName);
				session.put("familyNameKana", familyNameKana);
				session.put("firstNameKana", firstNameKana);
				session.put("userAddress",userAddress );
				session.put("telNumber", telNumber);
				session.put("email",email );

				result = SUCCESS;
			}else{
				session.put("familyNameErrorMessageList", familyNameErrorMessageList);
				session.put("firstNameErrorMessageList", firstNameErrorMessageList);
				session.put("familyNameKanaErrorMessageList", familyNameKanaErrorMessageList);
				session.put("firstNameKanaErrorMessageList", firstNameKanaErrorMessageList);
				session.put("emailErrorMessageList", emailErrorMessageList);
				session.put("telNumberErrorMessageList", telNumberErrorMessageList);
				session.put("userAddressErrorMessageList", userAddressErrorMessageList);
				result = ERROR;
			}
			sexList.add(MALE);
			sexList.add(FEMALE);
		}catch(Exception e){
			result = "login";
			return result;
		}
		return result;
	}
	public String getDefaultSexValue() {
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
		this.defaultSexValue = defaultSexValue;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public List<String> getFamilyNameErrorMessageList() {
		return familyNameErrorMessageList;
	}
	public void setFamilyNameErrorMessageList(List<String> familyNameErrorMessageList) {
		this.familyNameErrorMessageList = familyNameErrorMessageList;
	}
	public List<String> getFirstNameErrorMessageList() {
		return firstNameErrorMessageList;
	}
	public void setFirstNameErrorMessageList(List<String> firstNameErrorMessageList) {
		this.firstNameErrorMessageList = firstNameErrorMessageList;
	}
	public List<String> getFamilyNameKanaErrorMessageList() {
		return familyNameKanaErrorMessageList;
	}
	public void setFamilyNameKanaErrorMessageList(List<String> familyNameKanaErrorMessageList) {
		this.familyNameKanaErrorMessageList = familyNameKanaErrorMessageList;
	}
	public List<String> getFirstNameKanaErrorMessageList() {
		return firstNameKanaErrorMessageList;
	}
	public void setFirstNameKanaErrorMessageList(List<String> firstNameKanaErrorMessageList) {
		this.firstNameKanaErrorMessageList = firstNameKanaErrorMessageList;
	}
	public List<String> getEmailErrorMessageList() {
		return emailErrorMessageList;
	}
	public void setEmailErrorMessageList(List<String> emailErrorMessageList) {
		this.emailErrorMessageList = emailErrorMessageList;
	}
	public List<String> getTelNumberErrorMessageList() {
		return telNumberErrorMessageList;
	}
	public void setTelNumberErrorMessageList(List<String> telNumberErrorMessageList) {
		this.telNumberErrorMessageList = telNumberErrorMessageList;
	}
	public List<String> getUserAddressErrorMessageList() {
		return userAddressErrorMessageList;
	}
	public void setUserAddressErrorMessageList(List<String> userAddressErrorMessageList) {
		this.userAddressErrorMessageList = userAddressErrorMessageList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
