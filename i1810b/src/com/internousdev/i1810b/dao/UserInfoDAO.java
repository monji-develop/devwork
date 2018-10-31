package com.internousdev.i1810b.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.i1810b.dto.UserInfoDTO;
import com.internousdev.i1810b.util.DBConnector;


public class UserInfoDAO {
	public int createUser(String familyName, String firstName, String familyNameKana,
			String firstNameKana, String sex, String email, String loginId, String password){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;

		String sql = "insert into user_info(user_id, password, family_name, first_name, family_name_kana,"
				+ " first_name_kana, sex, email, status, logined, regist_date, update_date)"
				+ " values (BINARY ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), now())";

	try{
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, loginId);
		preparedStatement.setString(2, password);
		preparedStatement.setString(3, familyName);
		preparedStatement.setString(4, firstName);
		preparedStatement.setString(5, familyNameKana);
		preparedStatement.setString(6, firstNameKana);
		preparedStatement.setString(7, sex);
		preparedStatement.setString(8, email);
		preparedStatement.setInt(9,0);
		preparedStatement.setInt(10, 1);
		count = preparedStatement.executeUpdate();
	}catch (SQLException e){
		e.printStackTrace();
	}
	try{
		connection.close();
	}catch (SQLException e){
		e.printStackTrace();
	}
	return count;

	}

	public boolean isExistsUserInfo(String loginId, String password){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		boolean result = false;
		String sql= "select count(*) as count from user_info where user_id= BINARY ? and password= BINARY ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				if(resultSet.getInt("count") > 0){
					result = true;
				}

				}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public UserInfoDTO getUserInfo(String loginId, String password) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "select * from user_info where user_id= BINARY ? and password= BINARY ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				userInfoDTO.setId(resultSet.getInt("id"));
				userInfoDTO.setUserId(resultSet.getString("user_id"));
				userInfoDTO.setPassword(resultSet.getString("password"));
				userInfoDTO.setFamilyName(resultSet.getString("family_name"));
				userInfoDTO.setFirstName(resultSet.getString("first_name"));
				userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				userInfoDTO.setSex(resultSet.getInt("sex"));
				userInfoDTO.setEmail(resultSet.getString("email"));
				userInfoDTO.setStatus(resultSet.getString("status"));
				userInfoDTO.setLogined(resultSet.getInt("status"));
				userInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;
	}

	public UserInfoDTO getUserInfo(String loginId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql ="SELECT * from user_info where user_id= BINARY ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,loginId);
			ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			userInfoDTO.setId(resultSet.getInt("id"));
			userInfoDTO.setUserId(resultSet.getString("user_id"));
			userInfoDTO.setPassword(resultSet.getString("password"));
			userInfoDTO.setFamilyName(resultSet.getString("family_name"));
			userInfoDTO.setFirstName(resultSet.getString("first_name"));
			userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
			userInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
			userInfoDTO.setSex(resultSet.getInt("sex"));
			userInfoDTO.setEmail(resultSet.getString("email"));
			userInfoDTO.setStatus(resultSet.getString("status"));
			userInfoDTO.setLogined(resultSet.getInt("logined"));
			userInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
			userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
		}
		}catch (SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userInfoDTO;
		}

	public int resetPassword(String loginId, String password){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "update user_info set password= BINARY ? where user_id= BINARY ?";
		int result = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, loginId);
			result = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public int login(String loginId, String password){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "update user_info set logined=1 where user_id= BINARY ? and password= BINARY ?";
		int result = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public int logout(String loginId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "update user_info set logined=0 where user_id= BINARY ?";
		int result = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			result = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public String concealPassword(String newPassword){

		int beginIndex = 0;
		int endIndex = 1;

		StringBuilder stringBuilder = new StringBuilder("********");

		String concealedPassword = stringBuilder.replace(beginIndex, endIndex, newPassword.substring(beginIndex, endIndex)).toString();
		return concealedPassword;
	}

	public boolean checkDuplication(String loginId){
		boolean result = false;
		DBConnector dbCon = new DBConnector();
		Connection con = dbCon.getConnection();
		String sql = "select * from user_info where user_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				result = true;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
			return result;
		}
}