package com.trainingself.form;

public class EntryForm {

	private String name; // 氏名
	private String finalEducation; // 最終学歴
	private boolean devExp; // 開発経験有無
	private String matchingPoint; // 弊社とのマッチングポイント

	@Override
	public String toString() {
		return "EntryForm [name=" + name + ", finalEducation=" + finalEducation + ", devExp=" + devExp
				+ ", matchingPoint=" + matchingPoint + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFinalEducation() {
		return finalEducation;
	}
	public void setFinalEducation(String finalEducation) {
		this.finalEducation = finalEducation;
	}
	public boolean getDevExp() {
		return devExp;
	}
	public void setDevExp(boolean devExp) {
		this.devExp = devExp;
	}
	public String getMatchingPoint() {
		return matchingPoint;
	}
	public void setMatchingPoint(String matchingPoint) {
		this.matchingPoint = matchingPoint;
	}

}
