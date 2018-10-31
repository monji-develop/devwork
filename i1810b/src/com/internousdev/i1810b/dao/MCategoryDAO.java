package com.internousdev.i1810b.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.i1810b.dto.MCategoryDTO;
import com.internousdev.i1810b.util.DBConnector;

public class MCategoryDAO {

//	商品情報の取得
//	使用Action:HomeAction

	public List<MCategoryDTO> getMCategoryList() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<MCategoryDTO> mCategoryDTOList = new ArrayList<>();
		String sql = "SELECT * FROM m_category";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				MCategoryDTO mCategoryDTO = new MCategoryDTO();
				mCategoryDTO.setId(rs.getInt("id"));
				mCategoryDTO.setCategoryId(rs.getInt("category_id"));
				mCategoryDTO.setCategoryName(rs.getString("category_name"));
				mCategoryDTO.setCategoryDescription(rs.getString("category_description"));
				mCategoryDTO.setInsertDate(rs.getDate("insert_date"));
				mCategoryDTO.setUpdateDate(rs.getDate("update_date"));
				mCategoryDTOList.add(mCategoryDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mCategoryDTOList;
	}
}
