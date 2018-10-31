package com.internousdev.i1810b.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class InputChecker {

	//文字数・文字種判定
	public List<String> doCheck(String propertyName, String value, int minLength, int maxLength, boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana, boolean availableHalfWidthDigit, boolean availableHalfWidthSymbols, boolean availableKatakana, boolean availableFullWidthSymbols){

		List<String> stringList = new ArrayList<String>();
		List<String> characterTypeList = new ArrayList<String>();

		if(StringUtils.isEmpty(value)){
			stringList.add(propertyName + "を入力してください。");
		}

		if(value.length() < minLength || value.length() > maxLength){
			stringList.add(propertyName + "は" + minLength + "文字以上" + maxLength + "文字以下で入力してください。");
		}

//		ここから入力された文字を判定
		String regularExpression = "";

		if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableHalfWidthSymbols || availableKatakana || availableFullWidthSymbols){
			regularExpression = "[";
		}

		if(availableAlphabeticCharacters){
			regularExpression += "a-zA-Z";
			characterTypeList.add("半角英字");
		}

		if(availableKanji){
			regularExpression += "一-龠";
			characterTypeList.add("漢字");
		}

		if(availableHiragana){
			regularExpression += "ぁ-んー";
			characterTypeList.add("ひらがな");
		}

		if(availableHalfWidthDigit){
			regularExpression += "0-9";
			characterTypeList.add("半角数字");
		}

		if(availableHalfWidthSymbols){
			regularExpression += "@.,;:!#$%&'*+-/=?^_`{|}~ ";
			characterTypeList.add("半角記号");
		}

		if(availableKatakana){
			regularExpression += "ァ-ヶ -";
			characterTypeList.add("カタカナ");
		}

		if(availableFullWidthSymbols){
			regularExpression += "、。＠．，；：！＃＄％＆’＊＋ー／＝？＾＿｀｛｜｝〜・　";
			characterTypeList.add("全角記号");
		}

		if(!StringUtils.isEmpty(regularExpression)){
			regularExpression +="]+";
		}

//		ここまで


//		判別された結果に応じてエラーメッセージを返す
		String characterType = "";
		for(int i = 0; i < characterTypeList.size(); i++){
			if(i == 0){
				characterType += characterTypeList.get(i).toString();
			}else{
				characterType += "、" + characterTypeList.get(i).toString();
			}
		}

		if(!value.matches(regularExpression) && !value.equals("")){
			stringList.add(propertyName + "は" + characterType + "で入力してください。");
		}
		return stringList;
	}

//	パスワード再設定時、二回とも同じパスワードが入力されているか検証
	public List<String> doPasswordCheck(String newPassword, String reConfirmationPassword){
		List<String> stringList = new ArrayList<String>();
		if(!(newPassword.equals(reConfirmationPassword))){
			stringList.add("入力されたパスワードが異なります。");
		}
		return stringList;
	}

}
