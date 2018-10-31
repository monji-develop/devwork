package com.internousdev.i1810b.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.MCategoryDAO;
import com.internousdev.i1810b.dto.MCategoryDTO;
import com.internousdev.i1810b.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private String categoryId;
	private Map<String, Object> session;

	public String execute() {

//		セッション中にloginIdが含まれていなく，かつtempUserIdもセッション中に含まれていない場合，
//		commonUtilityから仮IDを生成し，セッション中にtempUserIdとして格納
		 if (!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))) {
			 CommonUtility commonUtility = new CommonUtility();
			 session.put("tempUserId", commonUtility.getRandomValue());
		}

//		セッション中にloginedが含まれていない場合，セッション中のloginedに0を入れて保管（ログイン中でないことを確認）
		if(!session.containsKey("logined")) {
			session.put("logined", 0);
		}

//		セッション中にregistFlgが含まれている場合、セッション中のloginedに1を入れて保管（ログイン状態にする）
		if(session.containsKey("registFlg")){
			session.put("logined", 1);
		}

//		セッション中にmCategoryListが含まれていない場合，mCategoryDAOから，mCategoryListを取得しセッションに保管
		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return SUCCESS;
	}

//	getter 及び setter
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}
	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}