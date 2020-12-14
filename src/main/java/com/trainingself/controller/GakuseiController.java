package com.trainingself.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = { "mendanForm", "entryInputForm" })
public class GakuseiController {

	private static final Logger logger = LoggerFactory.getLogger(GakuseiController.class);

	/**
	 * 学生トップ画面を表示
	 * http://localhost:8080/gakuseiTop
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gakuseiTop(Model model) {
		return "gakusei/gakuseiTop";
	}

	/**
	 * 学生トップ画面　→　面談日程伺い画面
	 * http://localhost:8080/mendanInput
	 *
	 */
	@RequestMapping(value = "/toMenndanInput", method = RequestMethod.GET)
	public String menndanInput(Model model) {

		MendanForm form = new MendanForm();
		model.addAttribute("mendanForm", form);

		return "gakusei/menndanInput";
	}

	/**
	 * 面談日程伺い画面　→　エントリーシート入力画面
	 * http://localhost:8080/entryInput
	 *
	 */
	@RequestMapping(value = "/toEntryInput", method = RequestMethod.POST)
	public String entryInput(MendanForm inputForm, Model model) throws ParseException {

		System.out.println(inputForm.toString());
		System.out.println(inputForm.toString());

		MendanForm form = new MendanForm();
		form.setRequestDate1(new Date());

		System.out.println(form.getReqdate1());
		System.out.println(form.getReqtime1());

		model.addAttribute("mendanForm", form);

		return "gakusei/entryInput";
	}

	/**
	 * エントリーシート入力画面　→　入力内容確認画面
	 * http://localhost:8080/confirm
	 *
	 */
	@RequestMapping(value = "/toConfirm", method = RequestMethod.GET)
	public String confirm(Locale locale, Model model) {
		return "gakusei/confirm";
	}

	/**
	 * 入力内容確認画面　→　登録完了画面
	 * http://localhost:8080/finish
	 *
	 */
	@RequestMapping(value = "/toFinish", method = RequestMethod.GET)
	public String finish(Locale locale, Model model) {
		return "gakusei/finish";
	}

	/**
	 * 登録完了画面　→　学生トップ画面
	 * http://localhost:8080/gakuseiTop
	 *
	 */
	@RequestMapping(value = "/toGakuseiTop", method = RequestMethod.GET)
	public String returnTop(Locale locale, Model model) {
		return "gakusei/gakuseiTop";
	}

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

}
