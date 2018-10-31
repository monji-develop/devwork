package com.internousdev.i1810b.dto;

import java.util.Date;

/*
 * PurchaseHistoryActionで用いる
 * DAOがDBから引き出した情報を格納するクラスでありゲッター及びセッター
 *
 * おそらく必要なのは画面表示せよと指示されている
 * 商品名
 * ふりがな
 * 商品画像ファイル名
 * 商品画像パス名
 * 値段
 * 発売会社名
 * 発売年月日
 *
 * のみである
 *
 * カート画面で必要となる
 * productCount(購入数)
 * destinationId(宛先情報ID)
 * subtotal(カート内の合計金額)
 * の3件を追加 梅山
 * */

public class PurchaseHistoryInfoDTO {

	private String userId;
	private int productId;
	private String productName;
	private String productNameKana;
	private String imageFileName;
	private String imageFilePath;
	private int price;
	private String releaseCompany;
	private Date releaseDate;
	private int productCount;
	private int destinationId;
	private int subtotal;


	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId=userId;
	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId=productId;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductName(String productName){
		this.productName=productName;
	}

	public String getProductNameKana(){
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana){
		this.productNameKana=productNameKana;
	}

	public String getImageFileName(){
		return imageFileName;
	}

	public void setImageFileName(String imageFileName){
		this.imageFileName=imageFileName;
	}

	public String getImageFilePath(){
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath){
		this.imageFilePath=imageFilePath;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price=price;
	}

	public String getReleaseCompany(){
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany=releaseCompany;
	}

	public Date getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate){
		this.releaseDate=releaseDate;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}


}
