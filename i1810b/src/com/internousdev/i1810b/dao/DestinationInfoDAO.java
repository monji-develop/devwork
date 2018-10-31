package com.internousdev.i1810b.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.i1810b.dto.DestinationInfoDTO;
import com.internousdev.i1810b.util.DBConnector;
public class DestinationInfoDAO {

	public int insert(String userId,String familyName,String firstName,String familyNameKana,String firstNameKana,String email,String telNumber,String userAddress){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="insert into destination_info(user_id,family_name,first_name,family_name_Kana,first_name_kana,email,tel_number,user_address,regist_date,update_date)values(?,?,?,?,?,?,?,?,now(),now())";
		int count = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, familyName);
			ps.setString(3, firstName);
			ps.setString(4, familyNameKana);
			ps.setString(5, firstNameKana);
			ps.setString(6, email);
			ps.setString(7, telNumber);
			ps.setString(8, userAddress);

			count = ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}


		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	public List<DestinationInfoDTO> getDestinationInfo(String loginId)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		List<DestinationInfoDTO> didto = new ArrayList<DestinationInfoDTO>();

		String sql ="select id,family_name,first_name,family_name_kana,first_name_kana,user_address,tel_number,email from destination_info where user_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				DestinationInfoDTO ddto = new DestinationInfoDTO();
				ddto.setId(rs.getInt("id"));

				ddto.setFirstName(rs.getString("first_name"));
				ddto.setFamilyName(rs.getString("family_name"));
				ddto.setFirstNameKana(rs.getString("first_name_kana"));
				ddto.setFamilyNameKana(rs.getString("family_name_kana"));
				ddto.setUserAddress(rs.getString("user_address"));
				ddto.setEmail(rs.getString("email"));
				ddto.setTelNumber(rs.getString("tel_number"));
				didto.add(ddto);
			}
		}catch(SQLException e){
			e.printStackTrace();

		}finally{
			con.close();
		}
		return didto;


	}
}