package com.internousdev.i1810b.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.UserInfoDAO;
import com.internousdev.i1810b.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


/*
 * ◆概要

 *
 * ログインした状態のみアクセス可能な「マイページ」に遷移する為のAction
 * 実行するとUserInfoDAO/DTOを生成してDBのuser_infoテーブルから各個人情報を受け取り、
 * それをsessionに格納する。
 * (なお、この際受け取るのは姓・名・ふりがな・性別・メールアドレスである。)
 *
 * 最後にSUCCESSを返しmyPage.jspに遷移する。
 * */


public class MyPageAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;


	public String execute() {

		//sessionが切れてたらホームへ
		if(!session.containsKey("logined")){
			String result = "login";
			return result;
		}

		//ユーザーインフォメーションテーブルにアクセスするDAOを生成
		//このDAOとDTOの作成はログイン認証担当者が担当する
		UserInfoDAO userInfoDAO=new UserInfoDAO();


		//セッションからLoginIdをゲットし、それを引数に対象ユーザーを特定し、DAOのgetUserInfoメソッドを実行する
		//なお、ここでのloginIdとはuser_infoテーブルにおけるuser_idを指している
		UserInfoDTO userInfoDTO=userInfoDAO.getUserInfo(String.valueOf(session.get("loginId")));


		//一応正常にDTOに値を入れられたかで条件分岐しておく
		if(userInfoDTO!=null){
			session.put("familyName", userInfoDTO.getFamilyName());
			session.put("firstName",userInfoDTO.getFirstName());
			session.put("familyNameKana",userInfoDTO.getFamilyNameKana());
			session.put("firstNameKana",userInfoDTO.getFirstNameKana());
			session.put("sex",userInfoDTO.getSex());
			session.put("email",userInfoDTO.getEmail());
		}


		return SUCCESS;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
