package com.internousdev.i1810b.dto;

import java.util.Date;

public class MCategoryDTO {

//	商品ID
	private int id;

//	カテゴリID
	private int categoryId;

//	カテゴリ名
	private String categoryName;

//	カテゴリ詳細
	private String categoryDescription;

//	登録日
	private Date insertDate;

//	更新日
	private Date updateDate;

//	getter 及び setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
