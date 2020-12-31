package com.trainingself.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.trainingself.dto.Reserve;
import com.trainingself.form.EntryForm;
import com.trainingself.form.MendanForm;
import com.trainingself.service.ReserveService;

@Controller
@SessionAttributes(value = { "mendanForm", "entryForm" })
public class GakuseiController {

	private static final Logger logger = LoggerFactory.getLogger(GakuseiController.class);

	@Autowired
	private ReserveService rs;

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
		Calendar cal = Calendar.getInstance();
		DateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dfTime = new SimpleDateFormat("HH:MM");

		form.setReqdate1(dfDate.format(cal.getTime()));
		form.setReqtime1(dfTime.format(cal.getTime()));

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

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM");

		// 日付をいっこにする
		// 希望日１
		inputForm.setRequestDate1(df.parse(inputForm.getReqdate1() + " " + inputForm.getReqtime1()));

		// 希望日２
		if (inputForm.getReqdate2() != "" && inputForm.getReqtime2() != "") {
			inputForm.setRequestDate2(df.parse(inputForm.getReqdate2() + " " + inputForm.getReqtime2()));
		} else {
			inputForm.setReqdate2("なし");
		}

		System.out.println(inputForm.toString());

		// 型を作るところ
		EntryForm eform = new EntryForm();
		model.addAttribute("entryForm", eform);

		return "gakusei/entryInput";
	}

	/**
	 * エントリーシート入力画面　→　入力内容確認画面
	 * http://localhost:8080/confirm
	 *
	 */
	@RequestMapping(value = "/toConfirm", method = RequestMethod.POST)
	public String confirm(EntryForm inputForm, Model model) throws ParseException {

		System.out.println(inputForm.toString());

		EntryForm form = new EntryForm();

		// 氏名
		form.setName(inputForm.getName());

		// 最終学歴
		form.setFinalEducation(inputForm.getFinalEducation());

		// 開発経験有無
		form.setDevExp(inputForm.getDevExp());

		// 弊社とのマッチングポイント
		form.setMatchingPoint(inputForm.getMatchingPoint());

		System.out.println(form.toString());

		return "gakusei/confirm";
	}

	/**
	 * 入力内容確認画面　→　登録完了画面
	 * http://localhost:8080/finish
	 *
	 */
	@RequestMapping(value = "/toFinish", method = RequestMethod.POST)
	public String finish(Locale locale, Model model, @ModelAttribute(value="entryForm")EntryForm entryForm, @ModelAttribute(value="mendanForm")MendanForm mendanForm) {

		Reserve reserveDto = new Reserve();

		// mendanForm
		reserveDto.setRequestDate1(mendanForm.getRequestDate1());
		reserveDto.setRequestDate2(mendanForm.getRequestDate2());

		// entryForm
		reserveDto.setName(entryForm.getName());
		reserveDto.setSchool(entryForm.getFinalEducation());
		reserveDto.setDev(entryForm.getDevExp());
		reserveDto.setMatchingPoint(entryForm.getMatchingPoint());

		System.out.println(entryForm.getDevExp());

		System.out.println(rs.daoCallInsertOne(reserveDto));

//		List resultList = rs.daoCallSelectAll();
		List resultList = rs.selectAllMybatis();
		System.out.println(resultList.get(resultList.size()-1));

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

}
