package com.trainingself.dto;

import java.util.Date;

public class Reserve {
	Date requestDate1;
	Date requestDate2;
	String name;
	String school;
	boolean dev;
	String matchingPoint;

	public Date getRequestDate1() {
		return requestDate1;
	}
	public void setRequestDate1(Date requestDate1) {
		this.requestDate1 = requestDate1;
	}
	public Date getRequestDate2() {
		return requestDate2;
	}
	public void setRequestDate2(Date requestDate2) {
		this.requestDate2 = requestDate2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public boolean getDev() {
		return dev;
	}
	public void setDev(boolean dev) {
		this.dev = dev;
	}
	public String getMatchingPoint() {
		return matchingPoint;
	}
	public void setMatchingPoint(String matchingPoint) {
		this.matchingPoint = matchingPoint;
	}

}
