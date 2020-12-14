package com.trainingself.domain.model;

import java.util.Date;

public class Reserve {

	private String receptionNo;//受付番号

	private Date requestDate1;//希望日程１

	private Date requestDate2;//希望日程2

	private String name; //氏名

	private String school; //最終学歴

	private boolean dev; //開発経験有無

	private String machingPoint; //マッチングポイント

	private Date createDate; //登録日時

	private Date updateDate; //更新日時

	public String getReceptionNo() {
		return receptionNo;
	}

	public void setReceptionNo(String receptionNo) {
		this.receptionNo = receptionNo;
	}

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

	public String getMachingPoint() {
		return machingPoint;
	}

	public void setMachingPoint(String machingPoint) {
		this.machingPoint = machingPoint;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	@Override
	public String toString() {
		return "Reserve [receptionNo=" + receptionNo + ", requestDate1=" + requestDate1 + ", requestDate2="
				+ requestDate2 + ", name=" + name + ", school=" + school + ", dev=" + dev + ", machingPoint="
				+ machingPoint + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
