package com.internousdev.i1810b.dto.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.internousdev.i1810b.dto.DestinationInfoDTO;

public class DestinationInfoDTOTest {
	//get Id test
		@Test
		public void testGetId1(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			int expected=0;

			dto.setId(expected);
			int actual = dto.getId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetId2(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			int expected = 214783647;

			dto.setId(expected);
			int actual = dto.getId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetId3(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			int expected = -214783643;
			dto.setId(expected);

			int actual = dto.getId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetId4() throws Exception{
			DestinationInfoDTO dto = new DestinationInfoDTO();
			try{
				int postalMax = Integer.parseInt("214783647");
				dto.setId(postalMax);
			}catch(RuntimeException e){
				assertEquals(e.getMessage(),"For input string: \"214783647\"");
			}
		}

		@Test
		public void testGetId5() throws Exception{
			DestinationInfoDTO dto = new DestinationInfoDTO();
			try{
				int postalMin = Integer.parseInt("-214783647");
				dto.setId(postalMin);
			}catch(RuntimeException e){
				assertEquals(e.getMessage(),"For input string: \"-214783647\"");
			}
		}

		@Test
		public void testSetId1(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			int expected = 0;

			dto.setId(expected);
			int actual = dto.getId();
			assertEquals(expected,actual);
		}

		// get UserId

		@Test
		public void testGetUserId1(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "0";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId2(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "214783647";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId3(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "-214783647";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId4(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "null";

			dto.setUserId(expected);
			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId5(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId6(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = " ";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId7(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "　";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId8(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId9(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "あいう１２３";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId10(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう１２３";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId11(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう１２３漢字";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetUserId12(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "ａｂｃあいう１２３漢字";
			dto.setUserId(expected);

			String actual = dto.getUserId();
			assertEquals(expected,actual);
		}

		//get familyName test

		@Test
		public void testGetFamilyName1(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected="0";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName2(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "214783647";
			dto.setFamilyName(expected);

			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName3(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "-214783647";
			dto.setFamilyName(expected);

			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName4(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "null";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName5(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "";
			dto.setFamilyName(expected);

			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName6(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = " ";
			dto.setFamilyName(expected);

			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName7(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "　";
			dto.setFamilyName(expected);

			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName8(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123";
			dto.setFamilyName(expected);

			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName9(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "あいう１２３";
			dto.setFamilyName(expected);

			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName10(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう１２３";
			dto.setFamilyName(expected);

			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName11(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう１２３漢字";
			dto.setFamilyName(expected);

			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyName12(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "ａｂｃあいう１２３漢字";
			dto.setFamilyName(expected);

			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		//get FirstName test
		@Test
		public void testGetFirstName1(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "0";

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFirstName2(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "214783647";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFirstName3(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "-214783647";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFirstName4(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "null";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFirstName5(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFirstName6(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = " ";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFirstName7(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "　";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFirstName8(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFirstName9(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "あいう１２３";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFirstName10(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう１２３";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFirstName11(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう１２３漢字";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstName12(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "ａｂｃあいう１２３漢字";
			dto.setFirstName(expected);

			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}

		// get FamilyNameKana test
		@Test
		public void testGetFamilyNameKana1(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "0";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFamilyNameKana2(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "214783647";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFamilyNameKana3(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "-214783647";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFamilyNameKana4(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "null";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFamilyNameKana5(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFamilyNameKana6(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = " ";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFamilyNameKana7(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "　";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetFamilyNameKana8(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyNameKana9(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "あいう123";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyNameKana10(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう123";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyNameKana11(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう漢字";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFamilyNameKana12(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "ａｂｃ123あいう漢字";

			dto.setFamilyNameKana(expected);
			String actual = dto.getFamilyNameKana();
			assertEquals(expected,actual);
		}

		// get FirstNameKana test

		@Test
		public void testGetFirstNameKana1(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "0";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana2(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "214783647";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana3(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "-214783647";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana4(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "null";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana5(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana6(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = " ";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana7(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "　";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana8(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana9(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "あいう１２３";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana10(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう１２３";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana11(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう１２３漢字";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetFirstNameKana12(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "ａｂｃあいう１２３漢字";

			dto.setFirstNameKana(expected);
			String actual = dto.getFirstNameKana();
			assertEquals(expected,actual);
		}

		//get UserAddress test

		@Test
		public void testGetUserAddress1(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "0";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress2(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "214783647";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress3(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "-214783647";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress4(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "null";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress5(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress6(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = " ";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress7(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "　";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress8(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress9(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "あいう１２３";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress10(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう１２３";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress11(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "abc123あいう１２３漢字";
			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void testGetUserAddress12(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected = "ａｂｃあいう１２３漢字";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		//get Telnumber test

		@Test
		public void testGetTelNumber1(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected="0";

			dto.setTelNumber(expected);
			String acutual = dto.getTelNumber();
			assertEquals(expected,acutual);
		}

		@Test
		public void testGetTelNumber4(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected="null";

			dto.setTelNumber(expected);
			String acutual = dto.getTelNumber();
			assertEquals(expected,acutual);
		}

		@Test
		public void testGetTelNumber5(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected="";

			dto.setTelNumber(expected);
			String acutual = dto.getTelNumber();
			assertEquals(expected,acutual);
		}

		@Test
		public void testGetTelNumber6(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected=" ";

			dto.setTelNumber(expected);
			String acutual = dto.getTelNumber();
			assertEquals(expected,acutual);
		}

		@Test
		public void testGetTelNumber7(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected="　";

			dto.setTelNumber(expected);
			String acutual = dto.getTelNumber();
			assertEquals(expected,acutual);
		}

		@Test
		public void testGetTelNumber8(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected="abc123";

			dto.setTelNumber(expected);
			String actual = dto.getTelNumber();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetTelNumber9(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected="あいう123";

			dto.setTelNumber(expected);
			String actual = dto.getTelNumber();
			assertEquals(expected,actual);
		}

		@Test
		public void testGetTelNumber10() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "abc123あいう１２３";

			dto.setTelNumber(expected);
			String actual = dto.getTelNumber();
			assertEquals(expected, actual);
		}
		@Test
		public void testGetTelNumber11() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "abc123あいう１２３漢字";

			dto.setTelNumber(expected);
			String actual = dto.getTelNumber();
			assertEquals(expected, actual);
		}
		@Test
		public void testGetTelNumber12() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "ａｂｃあいう１２３漢字";

			dto.setTelNumber(expected);
			String actual = dto.getTelNumber();
			assertEquals(expected, actual);
		}

		//Test get Email

		@Test
		public void testGetEmail1() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "0";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		@Test
		public void testGetEmail2() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "2147483647";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		@Test
		public void testGetEmail3() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "-2147483647";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		@Test
		public void testGetEmail4() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "null";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		@Test
		public void testGetEmail5() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		@Test
		public void testGetEmail6() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= " ";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		@Test
		public void testGetEmail7() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "　";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		@Test
		public void testGetEmail8() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "abc123";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		@Test
		public void testGetEmail9() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "あいう１２３";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}
		@Test
		public void testGetEmail10() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "abc123あいう１２３";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		@Test
		public void testGetEmail11() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "abc123あいう１２３漢字";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		@Test
		public void testGetEmail12() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			String expected= "ａｂｃあいう１２３漢字";

			dto.setEmail(expected);
			String actual = dto.getEmail();
			assertEquals(expected, actual);
		}

		//Test get RegistDate

		public void testGetRegistDate1(){
			DestinationInfoDTO dto = new DestinationInfoDTO();
			Date expected = null;

			dto.setRegistDate(expected);
			Date actual = dto.getRegistDate();
			assertEquals(expected,actual);
		}

		public void testGetRegistDate2() throws ParseException{
			DestinationInfoDTO dto = new DestinationInfoDTO();

			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
			Date expected = sdf.parse("20180420 12:00:00");
			dto.setUpdateDate(expected);
			Date actual = dto.getRegistDate();
			assertEquals(expected,actual);
		}

		// get UpdateDate test
		@Test
		public void testGetUpdateDate1() {
			DestinationInfoDTO dto = new DestinationInfoDTO();
			Date expected = null;

			dto.setUpdateDate(expected);
			Date actual = dto.getUpdateDate();
			assertEquals(expected, actual);
		}
		@Test
		public void testGetUpdateDate2() throws ParseException{
			DestinationInfoDTO dto = new DestinationInfoDTO();

			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
			Date expected = sdf.parse("20180420 12:00:00");
			dto.setUpdateDate(expected);
			assertEquals(expected,dto.getUpdateDate());
		}





}
