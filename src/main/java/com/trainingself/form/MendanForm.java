package com.trainingself.form;

import java.util.Date;

public class MendanForm {

	private String reqdate1; //希望日１（日付）
	private String reqtime1; //希望日１（時刻）
	private Date requestDate1; //希望日１（日付・時刻（Date））
	private String reqdate2; //希望日２（日付）
	private String reqtime2; //希望日２（時刻）
	private Date requestDate2; //希望日２（日付・時刻（Date））

	@Override
	public String toString() {
		return "MendanForm [reqdate1=" + reqdate1 + ", reqtime1=" + reqtime1 + ", requestDate1=" + requestDate1
				+ ", reqdate2=" + reqdate2 + ", reqtime2=" + reqtime2 + ", requestDate2=" + requestDate2 + "]";
	}

	public String getReqdate1() {
		return reqdate1;
	}

	public void setReqdate1(String reqdate1) {
		this.reqdate1 = reqdate1;
	}

	public String getReqtime1() {
		return reqtime1;
	}

	public void setReqtime1(String reqtime1) {
		this.reqtime1 = reqtime1;
	}

	public Date getRequestDate1() {
		return requestDate1;
	}

	public void setRequestDate1(Date requestDate1) {
		this.requestDate1 = requestDate1;
	}

	public String getReqdate2() {
		return reqdate2;
	}

	public void setReqdate2(String reqdate2) {
		this.reqdate2 = reqdate2;
	}

	public String getReqtime2() {
		return reqtime2;
	}

	public void setReqtime2(String reqtime2) {
		this.reqtime2 = reqtime2;
	}

	public Date getRequestDate2() {
		return requestDate2;
	}

	public void setRequestDate2(Date requestDate2) {
		this.requestDate2 = requestDate2;
	}

}
