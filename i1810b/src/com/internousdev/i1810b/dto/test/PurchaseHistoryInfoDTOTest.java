package com.internousdev.i1810b.dto.test;


import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.internousdev.i1810b.dto.PurchaseHistoryInfoDTO;



public class PurchaseHistoryInfoDTOTest {

	int max=2147483647;
	int min=-2147483648;
	String exmax="2147483648";
	String exmin="-2147483649";

	@Test
	public void testGetUserId1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=null;
		dto.setUserId(expected);
		String actual=dto.getUserId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetUserId2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="";
		dto.setUserId(expected);
		String actual=dto.getUserId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetUserId3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=" ";
		dto.setUserId(expected);
		String actual=dto.getUserId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetUserId4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="　";
		dto.setUserId(expected);
		String actual=dto.getUserId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetUserId5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123";
		dto.setUserId(expected);
		String actual=dto.getUserId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetUserId6(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="あいう１２３";
		dto.setUserId(expected);
		String actual=dto.getUserId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetUserId7(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３";
		dto.setUserId(expected);
		String actual=dto.getUserId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetUserId8(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="ａｂｃ１２３あいう漢字";
		dto.setUserId(expected);
		String actual=dto.getUserId();
		assertEquals(expected,actual);
	}


	@Test
	public void testGetProductId1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=0;
		dto.setProductId(expected);
		int actual=dto.getProductId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductId2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=max;
		dto.setProductId(expected);
		int actual=dto.getProductId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductId3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=min;
		dto.setProductId(expected);
		int actual=dto.getProductId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductId4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();

		try{
		int expected=Integer.parseInt(exmax);
		dto.setProductId(expected);
		int actual=dto.getProductId();
		assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	@Test
	public void testGetProductId5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();

		try{
		int expected=Integer.parseInt(exmin);
		dto.setProductId(expected);
		int actual=dto.getProductId();
		assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"-2147483649\"");
		}
	}

	@Test
	public void testGetProductName1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=null;
		dto.setProductName(expected);
		String actual=dto.getProductName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductName2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="";
		dto.setProductName(expected);
		String actual=dto.getProductName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductName3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=" ";
		dto.setProductName(expected);
		String actual=dto.getProductName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductName4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="　";
		dto.setProductName(expected);
		String actual=dto.getProductName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductName5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123";
		dto.setProductName(expected);
		String actual=dto.getProductName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductName6(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="あいう１２３";
		dto.setProductName(expected);
		String actual=dto.getProductName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductName7(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３";
		dto.setProductName(expected);
		String actual=dto.getProductName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductName8(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３漢字";
		dto.setProductName(expected);
		String actual=dto.getProductName();
		assertEquals(expected,actual);
	}


	@Test
	public void testGetProductNameKana1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=null;
		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductNameKana2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="";
		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductNameKana3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=" ";
		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductNameKana4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="　";
		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductNameKana5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123";
		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductNameKana6(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="あいう１２３";
		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductNameKana7(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３";
		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductNameKana8(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３漢字";
		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();
		assertEquals(expected,actual);
	}


	@Test
	public void testGetImageFileName1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=null;
		dto.setImageFileName(expected);
		String actual=dto.getImageFileName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFileName2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="";
		dto.setImageFileName(expected);
		String actual=dto.getImageFileName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFileName3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=" ";
		dto.setImageFileName(expected);
		String actual=dto.getImageFileName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFileName4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="　";
		dto.setImageFileName(expected);
		String actual=dto.getImageFileName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFileName5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123";
		dto.setImageFileName(expected);
		String actual=dto.getImageFileName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFileName6(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="あいう１２３";
		dto.setImageFileName(expected);
		String actual=dto.getImageFileName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFileName7(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３";
		dto.setImageFileName(expected);
		String actual=dto.getImageFileName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFileName8(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３漢字";
		dto.setImageFileName(expected);
		String actual=dto.getImageFileName();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFilePath1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=null;
		dto.setImageFilePath(expected);
		String actual=dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFilePath2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="";
		dto.setImageFilePath(expected);
		String actual=dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFilePath3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=" ";
		dto.setImageFilePath(expected);
		String actual=dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFilePath4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="　";
		dto.setImageFilePath(expected);
		String actual=dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFilePath5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123";
		dto.setImageFilePath(expected);
		String actual=dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFilePath6(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="あいう１２３";
		dto.setImageFilePath(expected);
		String actual=dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFilePath7(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３";
		dto.setImageFilePath(expected);
		String actual=dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetImageFilePath8(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３漢字";
		dto.setImageFilePath(expected);
		String actual=dto.getImageFilePath();
		assertEquals(expected,actual);
	}


	@Test
	public void testGetPrice1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=0;
		dto.setPrice(expected);
		int actual=dto.getPrice();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetPrice2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=max;
		dto.setPrice(expected);
		int actual=dto.getPrice();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetPrice3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=min;
		dto.setPrice(expected);
		int actual=dto.getPrice();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetPrice4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();

		try{
		int expected=Integer.parseInt(exmax);
		dto.setPrice(expected);
		int actual=dto.getPrice();
		assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	@Test
	public void testGetPrice5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();

		try{
		int expected=Integer.parseInt(exmin);
		dto.setPrice(expected);
		int actual=dto.getPrice();
		assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}


	@Test
	public void testReleaseCompany1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=null;
		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();
		assertEquals(expected,actual);
	}

	@Test
	public void testReleaseCompany2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="";
		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();
		assertEquals(expected,actual);
	}

	@Test
	public void testReleaseCompany3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected=" ";
		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();
		assertEquals(expected,actual);
	}

	@Test
	public void testReleaseCompany4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="　";
		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();
		assertEquals(expected,actual);
	}

	@Test
	public void testReleaseCompany5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123";
		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();
		assertEquals(expected,actual);
	}

	@Test
	public void testReleaseCompany6(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="あいう１２３";
		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();
		assertEquals(expected,actual);
	}

	@Test
	public void testReleaseCompany7(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３";
		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();
		assertEquals(expected,actual);
	}

	@Test
	public void testReleaseCompany8(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		String expected="abc123あいう１２３漢字";
		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();
		assertEquals(expected,actual);
	}


	@Test
	public void testReleaseDate1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		Date expected=null;
		dto.setReleaseDate(expected);
		Date actual=dto.getReleaseDate();
		assertEquals(expected,actual);
	}

	@Test
	public void testReleaseDate2()throws ParseException{
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected=sdf.parse("20180420 12:00:00");
		dto.setReleaseDate(expected);
		assertEquals(expected,dto.getReleaseDate());
	}


	@Test
	public void testGetProductCount1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=0;
		dto.setProductCount(expected);
		int actual=dto.getProductCount();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductCount2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=max;
		dto.setProductCount(expected);
		int actual=dto.getProductCount();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductCount3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=min;
		dto.setProductCount(expected);
		int actual=dto.getProductCount();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetProductCount4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		try{
		int expected=Integer.parseInt(exmax);
		dto.setProductCount(expected);
		int actual=dto.getProductCount();
		assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	@Test
	public void testGetProductCount5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		try{
		int expected=Integer.parseInt(exmin);
		dto.setProductCount(expected);
		int actual=dto.getProductCount();
		assertEquals(expected,actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"-2147483649\"");
		}
	}

	@Test
	public void testDestinationId1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=0;
		dto.setDestinationId(expected);
		int actual=dto.getDestinationId();
		assertEquals(expected,actual);
	}

	@Test
	public void testDestinationId2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=max;
		dto.setDestinationId(expected);
		int actual=dto.getDestinationId();
		assertEquals(expected,actual);
	}

	@Test
	public void testDestinationId3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=min;
		dto.setDestinationId(expected);
		int actual=dto.getDestinationId();
		assertEquals(expected,actual);
	}

	@Test
	public void testDestinationId4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();

		try{
		int expected=Integer.parseInt(exmax);
		dto.setDestinationId(expected);
		int actual=dto.getDestinationId();
		assertEquals(actual,expected);
		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	@Test
	public void testDestinationId5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();

		try{
		int expected=Integer.parseInt(exmin);
		dto.setDestinationId(expected);
		int actual=dto.getDestinationId();
		assertEquals(actual,expected);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}


	@Test
	public void testSubtotal1(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=0;
		dto.setSubtotal(expected);
		int actual=dto.getSubtotal();
		assertEquals(actual,expected);
	}

	@Test
	public void testSubtotal2(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=max;
		dto.setSubtotal(expected);
		int actual=dto.getSubtotal();
		assertEquals(actual,expected);
	}

	@Test
	public void testSubtotal3(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();
		int expected=min;
		dto.setSubtotal(expected);
		int actual=dto.getSubtotal();
		assertEquals(actual,expected);
	}

	@Test
	public void testSubtotal4(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();

		try{
		int expected=Integer.parseInt(exmax);
		dto.setDestinationId(expected);
		int actual=dto.getDestinationId();
		assertEquals(actual,expected);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	@Test
	public void testSubtotal5(){
		PurchaseHistoryInfoDTO dto=new PurchaseHistoryInfoDTO();

		try{
		int expected=Integer.parseInt(exmin);
		dto.setDestinationId(expected);
		int actual=dto.getDestinationId();
		assertEquals(actual,expected);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}
}
