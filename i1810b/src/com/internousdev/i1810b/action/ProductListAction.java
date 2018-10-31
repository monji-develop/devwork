package com.internousdev.i1810b.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.MCategoryDAO;
import com.internousdev.i1810b.dao.ProductInfoDAO;
import com.internousdev.i1810b.dto.MCategoryDTO;
import com.internousdev.i1810b.dto.PaginationDTO;
import com.internousdev.i1810b.dto.ProductInfoDTO;
import com.internousdev.i1810b.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware{
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;

	private String categoryId;
	private String keywords;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

	private Map<String, Object> session;
	public String execute(){

		if(!session.containsKey("logined")){
			String result = "login";
			return result;
		}

		String result = ERROR;

		session.remove("keywordsErrorMessageList");

		ProductInfoDAO productInfoDao = new ProductInfoDAO();
		productInfoDtoList = productInfoDao.getProductInfoList();
		Pagination pagination = new Pagination();
		PaginationDTO paginationDTO = pagination.initialize(productInfoDtoList,9);
		session.put("totalPageSize", paginationDTO.getTotalPageSize());
		session.put("currentPageNumber", paginationDTO.getCurrentPageNo());
		session.put("totalRecordNo", paginationDTO.getTotalRecordSize());
		session.put("startRecordNo", paginationDTO.getStartRecordNo());
		session.put("endRecordNo", paginationDTO.getEndRecordNo());
		session.put("pageNumberList", paginationDTO.getPageNumberList());
		session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());
		session.put("hasNextPage", paginationDTO.hasNextPage());
		session.put("hasPreviousPage", paginationDTO.hasPreviousPage());
		session.put("nextPageNo", paginationDTO.getNextPageNo());
		session.put("previousPageNo", paginationDTO.getPreviousPageNo());

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("MCategoryDtoList", mCategoryDtoList);
		}
		result = SUCCESS;
		return  result;
	}

	public List<MCategoryDTO> getmCategoryDtoList(){
		return mCategoryDtoList;
	}

	public void setCategoryDtoList(List<MCategoryDTO>mCategoryDtoList){
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductNameKana(){
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana){
		this.productNameKana = productNameKana;
	}

	public String getImageFilePath(){
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath){
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName(){
		return imageFileName;
	}
	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getKeywords(){
		return keywords;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public List<ProductInfoDTO> getProductInfoDtoList(){
		return productInfoDtoList;
	}

	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList){
		this.productInfoDtoList = productInfoDtoList;
	}

	public Map<String, Object> getsession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
