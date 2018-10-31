package com.internousdev.i1810b.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.i1810b.dto.PurchaseHistoryInfoDTO;
import com.internousdev.i1810b.util.DBConnector;


/*
 * PurchaseHistoryActionよりDTOとともに呼び出されるクラス
 * DBにアクセスしてSQL文を通し、情報のリードだけを行う
 *
 * 必要なのはおそらくgetPurchaseHistoryListメソッドのみである
 *
 * 購入履歴の登録に必要なregistメソッド、パスワード再設定に必要なdeleteAllメソッドを追加 梅山
 * */

public class PurchaseHistoryInfoDAO {

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryList(String loginId){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		//DTOのリストを定義
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList=new ArrayList<PurchaseHistoryInfoDTO>();

		//SQL文
		String sql="select "
				+ "phi.user_id as user_id,"/*ユーザーID*/
				+ "pi.product_id as product_id,"/*商品ID*/
				+ "pi.product_name as product_name,"/*商品名*/
				+ "pi.product_name_kana as product_name_kana,"/*商品名かな*/
				+ "pi.image_file_name as image_file_name,"/*画像名*/
				+ "pi.image_file_path as image_file_path,"/*画像パス*/
				+ "phi.price as price,"/*値段*/
				+ "pi.release_company,"/*発売会社名*/
				+ "pi.release_date"/*発売日*/
				+ " FROM purchase_history_info as phi"
				+ " LEFT JOIN product_info as pi"
				+ " ON phi.product_id = pi.product_id"
				+ " WHERE phi.user_id=?";


		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,loginId);

			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				PurchaseHistoryInfoDTO purchaseHistoryInfoDTO=new PurchaseHistoryInfoDTO();
				purchaseHistoryInfoDTO.setUserId(resultSet.getString("user_id"));
				purchaseHistoryInfoDTO.setProductId(resultSet.getInt("product_id"));
				purchaseHistoryInfoDTO.setProductName(resultSet.getString("product_name"));
				purchaseHistoryInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				purchaseHistoryInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				purchaseHistoryInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				purchaseHistoryInfoDTO.setPrice(resultSet.getInt("price"));
				purchaseHistoryInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				purchaseHistoryInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				purchaseHistoryInfoDTOList.add(purchaseHistoryInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return purchaseHistoryInfoDTOList;
	}


	public int regist(String loginId, int productId, int productCount, int destinationId, int price){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "insert into purchase_history_info(user_id, product_id, product_count, price, destination_id, regist_date, update_date) "
				+ "values (?, ?, ?, ?, ?, now(), now())";
		int count = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, productCount);
			preparedStatement.setInt(4, price);
			preparedStatement.setInt(5, destinationId);
			count = preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	public int deleteAll(String loginId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "delete from purchase_history_info where user_id=?";
		int count = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			count = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}


}
