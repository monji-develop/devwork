package com.internousdev.i1810b.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810b.dao.MCategoryDAO;
import com.internousdev.i1810b.dao.ProductInfoDAO;
import com.internousdev.i1810b.dto.MCategoryDTO;
import com.internousdev.i1810b.dto.PaginationDTO;
import com.internousdev.i1810b.dto.ProductInfoDTO;
import com.internousdev.i1810b.util.InputChecker;
import com.internousdev.i1810b.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private String keywords;
	private String pageNo;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute() {

		if(!session.containsKey("logined")){
			String result = "login";
			return result;
		}

		String result = ERROR;
		InputChecker inputChecker = new InputChecker();

		session.remove("keywordsErrorMessageList");

//		検索ワードがnullの場合に，空文字を挿入
		if(StringUtils.isBlank(keywords)){  //null,ブランク扱いをtrue/falseで返すメソッドで検証
			keywords = "";
		}else{
			keywords = keywords.replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		}

		if(!(keywords.equals(""))){
//		入力された検索ワードが有効かどうかinputCheckerを用いて検証
		keywordsErrorMessageList = inputChecker.doCheck("検索ワード", keywords, 0, 16, true, true, true, true, false,true,false);
		}

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();

//		categoryIdが1の場合は，全てのジャンルから検索，
//		categoryIdが2,3,4,5,6,7の場合は，それぞれのカテゴリーが選択される
//		商品一覧から検索された際の処理をelseで定義
		if("1".equals(categoryId)) {
			productInfoDtoList = productInfoDAO.getProductInfoListAll(keywords.split(" "));
			result = SUCCESS;
		} else if ("2".equals(categoryId) || "3".equals(categoryId) || "4".equals(categoryId) || "5".equals(categoryId) || "6".equals(categoryId) || "7".equals(categoryId)) {
			productInfoDtoList = productInfoDAO.getProductInfoListByKeywords(keywords.split(" "), categoryId);
			result = SUCCESS;
		} else {
			productInfoDtoList=productInfoDAO.getProductInfoListAll(keywords.split(" "));
			result=SUCCESS;
		}

//		Iteratorを用いてリスト内のデータを順に参照し，
//		次のデータがなくなった時に空データnullを挿入
		Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();
		if(!(iterator.hasNext())) {
			productInfoDtoList = null;
		}
		session.put("keywordsErrorMessageList", keywordsErrorMessageList);

//		セッション内にMCategoryListが無い場合，
//		mCategoryDTOListに，mCategoryDAOListの値を格納
		if(!(session.containsKey("mCategoryList"))) {
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}

//		productInfoDTOListがnullでない場合，かつ，
//		pageNoがnullであれば1p目の取得，そうでなければ任意のページ情報の取得
		if(!(productInfoDtoList == null)) {
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO = new PaginationDTO();

			if(pageNo == null) {
				paginationDTO = pagination.initialize(productInfoDtoList, 9);
			} else {
				paginationDTO = pagination.getPage(productInfoDtoList, 9, pageNo);
			}

//			各データをセッションに保管(ProductListActionでセッションに格納済み？)
			session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());
			session.put("totalPageSize", paginationDTO.getTotalPageSize());
			session.put("currentPageNumber", paginationDTO.getCurrentPageNo());
			session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
			session.put("endRecordNo", paginationDTO.getEndRecordNo());
			session.put("previousPage", paginationDTO.hasPreviousPage());
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());
			session.put("nextPage", paginationDTO.hasNextPage());
			session.put("nextPageNo", paginationDTO.getNextPageNo());
		} else {
//			puroductInfoDTOListがnullの場合は，puroductInfoDTOListのセッション中にnullを保管
			session.put("productInfoDtoList", null);
		}
		return result;

	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public List<MCategoryDTO> getmCategoryDTOList() {
		return mCategoryDTOList;
	}
	public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDTOList) {
		this.mCategoryDTOList = mCategoryDTOList;
	}
	public List<String> getKeywordsErrorMessageList() {
		return keywordsErrorMessageList;
	}
	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList) {
		this.keywordsErrorMessageList = keywordsErrorMessageList;
	}
	public List<ProductInfoDTO> getProductInfoDtoList() {
		return productInfoDtoList;
	}
	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList) {
		this.productInfoDtoList = productInfoDtoList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
