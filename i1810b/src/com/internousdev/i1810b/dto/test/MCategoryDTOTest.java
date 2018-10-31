package com.internousdev.i1810b.dto.test;


import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.internousdev.i1810b.dto.MCategoryDTO;



public class MCategoryDTOTest {

	int max=2147483647;
	int min=-2147483648;
	String exmax="214748364";
	String exmin="-214748364";

	@Test
	public void testGetId1(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=0;
		dto.setId(expected);
		int actual=dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetId2(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=max;
		dto.setId(expected);
		int actual=dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetId3(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=min;
		dto.setId(expected);
		int actual=dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetId4() throws Exception{
		MCategoryDTO dto=new MCategoryDTO();

		try{
		int expected=Integer.parseInt(exmax);
		dto.setId(expected);
		int actual=dto.getId();
		assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	@Test
	public void testGetId5() throws Exception{
		MCategoryDTO dto=new MCategoryDTO();

		try{
		int expected=Integer.parseInt(exmin);
		dto.setId(expected);
		int actual=dto.getId();
		assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}

//	set Id test
	@Test
	public void testSetId1(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=0;
		dto.setId(expected);
		int actual=dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetId2(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=max;
		dto.setId(expected);
		int actual=dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetId3(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=min;
		dto.setId(expected);
		int actual=dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetId4() throws Exception{
		MCategoryDTO dto=new MCategoryDTO();
		try{
			int expected=Integer.parseInt(exmax);
			dto.setId(expected);
			int actual=dto.getId();
			assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	@Test
	public void testSetId5() throws Exception{
		MCategoryDTO dto=new MCategoryDTO();
		try{
			int expected=Integer.parseInt(exmin);
			dto.setId(expected);
			int actual=dto.getId();
			assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"-2147483648\"");
		}
	}

//	get categoryId test
	@Test
	public void testGetCategoryId1(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=0;
		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetCategoryId2(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=max;
		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetCategoryId3(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=min;
		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetCategoryId4() throws Exception{
		MCategoryDTO dto=new MCategoryDTO();
		try{
			int expected=Integer.parseInt(exmax);
			dto.setCategoryId(expected);
			int actual=dto.getCategoryId();
			assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	@Test
	public void testGetCategoryId5() throws Exception{
		MCategoryDTO dto=new MCategoryDTO();
		try{
			int expected=Integer.parseInt(exmin);
			dto.setCategoryId(expected);
			int actual=dto.getCategoryId();
			assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"-2147483648\"");
		}
	}

//	set categoryId test
	@Test
	public void testSetCategoryId1(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=0;
		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetCategoryId2(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=max;
		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetCategoryId3(){
		MCategoryDTO dto=new MCategoryDTO();
		int expected=min;
		dto.setCategoryId(expected);
		int actual=dto.getCategoryId();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetCategoryId4() throws Exception{
		MCategoryDTO dto=new MCategoryDTO();
		try{
			int expected=Integer.parseInt(exmax);
			dto.setCategoryId(expected);
			int actual=dto.getCategoryId();
			assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string \"2147483648\"");
		}
	}

	@Test
	public void testSetCategoryId5() throws Exception{
		MCategoryDTO dto=new MCategoryDTO();
		try{
			int expected=Integer.parseInt(exmin);
			dto.setCategoryId(expected);
			int actual=dto.getCategoryId();
			assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string \"-2147483648\"");
		}
	}

//	get categoryName test
	@Test
	public void testGetCategoryName1(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="0";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName2(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=exmax;
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName3(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=exmin;
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName4(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="null";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName5(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName6(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=" ";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName7(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="　";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName8(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName9(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="あいう１２３";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName10(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123あいう１２３";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName11(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123あいう１２３漢字";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryName12(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="ａｂｃあいう１２３漢字";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

//	set categoryName test
	@Test
	public void testSetCategoryName1(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="0";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName2(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=exmax;
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName3(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=exmin;
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName4(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="null";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName5(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName6(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=" ";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName7(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="　";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName8(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName9(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="あいう１２３";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName10(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123あいう１２３";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName11(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123あいう１２３漢字";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryName12(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="ａｂｃあいう１２３漢字";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

//	get categoryDescription test
	@Test
	public void testGetCategoryDescription1(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="0";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription2(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=exmax;
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription3(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=exmin;
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription4(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="null";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription5(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription6(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=" ";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription7(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="　";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription8(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription9(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="あいう１２３";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription10(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123あいう１２３";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription11(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123あいう１２３漢字";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetCategoryDescription12(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="ａｂｃあいう１２３漢字";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

//	set categoryDescription test
	@Test
	public void testSetCategoryDescription1(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="0";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription2(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=exmax;
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription3(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=exmin;
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription4(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="null";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription5(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription6(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted=" ";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription7(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="　";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription8(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription9(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="あいう１２３";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription10(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123あいう１２３";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription11(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="abc123あいう１２３漢字";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetCategoryDescription12(){
		MCategoryDTO dto=new MCategoryDTO();
		String excepted="ａｂｃあいう１２３漢字";
		dto.setCategoryName(excepted);
		String actual=dto.getCategoryName();
		assertEquals(excepted,actual);
	}

//	get insertDate test
	@Test
	public void testGetInsertDate1(){
		MCategoryDTO dto=new MCategoryDTO();
		Date excepted=null;
		dto.setInsertDate(excepted);
		Date actual=dto.getInsertDate();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetInsertDate2() throws ParseException{
		MCategoryDTO dto=new MCategoryDTO();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date excepted=sdf.parse("20180420 12:00:00");
		dto.setInsertDate(excepted);
		assertEquals(excepted,dto.getInsertDate());
	}
//	set insertDate test
	@Test
	public void testSetInsertDate1(){
		MCategoryDTO dto=new MCategoryDTO();
		Date excepted=null;
		dto.setInsertDate(excepted);
		Date actual=dto.getInsertDate();
		assertEquals(excepted,actual);
	}

	@Test
	public void testSetInsertDate2() throws ParseException{
		MCategoryDTO dto=new MCategoryDTO();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date excepted=sdf.parse("20180420 12:00:00");
		dto.setInsertDate(excepted);
		assertEquals(excepted,dto.getInsertDate());
	}

//	get updateDate test
	@Test
	public void testGetUpdateDate1(){
		MCategoryDTO dto=new MCategoryDTO();
		Date excepted=null;
		dto.setUpdateDate(excepted);
		Date actual=dto.getUpdateDate();
		assertEquals(excepted,actual);
	}

	@Test
	public void testGetUpdateDate2() throws ParseException{
		MCategoryDTO dto=new MCategoryDTO();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date excepted=sdf.parse("20180420 12:00:00");
		dto.setUpdateDate(excepted);
		assertEquals(excepted,dto.getUpdateDate());
	}

//	set updateDate test
	@Test
	public void testSetUpadataDate1(){
		MCategoryDTO dto=new MCategoryDTO();
		Date expected=null;
		dto.setUpdateDate(expected);
		Date actual=dto.getUpdateDate();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetUpdateDate2() throws ParseException{
		MCategoryDTO dto=new MCategoryDTO();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected=sdf.parse("20180420 12:00:00");
		dto.setUpdateDate(expected);
		assertEquals(expected,dto.getUpdateDate());
	}
}