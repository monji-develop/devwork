package com.internousdev.i1810b.util;

public class CommonUtility {

	//16桁の乱数を返すメソッド
	public String getRandomValue(){
		String value="";
		double d;
		for(int i=1; i<=16; i++){
			d = Math.random() * 10;
			value = value + ((int)d);
		}
		return value;
	}

	//文字列を分割するメソッド
	public String[] parseArrayList(String s){
		return s.split(", ",0);
	}

}
