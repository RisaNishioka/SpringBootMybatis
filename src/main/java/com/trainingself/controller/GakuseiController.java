package com.trainingself.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.trainingself.controller.service.GakuseiService;
import com.trainingself.form.MendanForm;

@Controller
@SessionAttributes(value = { "mendanForm","entryInputForm" })
public class GakuseiController {

	private static final Logger logger = LoggerFactory.getLogger(GakuseiController.class);

	@Autowired
	GakuseiService gakuseiSrv;


	/**
	 * 学生トップ画面を表示
	 * http://localhost:8080/gakuseiTop
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gakuseiTop(Model model) {


		try {

			gakuseiSrv.getAllReserveData();

		} catch (IOException e) {
			e.printStackTrace();
		}



		return "gakusei/gakuseiTop";
	}


	@RequestMapping(value = "/toMenndanInput", method = RequestMethod.GET)
	public String menndanInput(Model model) throws ParseException {

		MendanForm form = new MendanForm();
		model.addAttribute("mendanForm", form);

		return "gakusei/menndanInput";
	}



	@RequestMapping(value = "/toEntryInput", method = RequestMethod.POST)
	public String entryInput(MendanForm inputForm, Model model) {

		logger.info(inputForm.toString());

		MendanForm form = new MendanForm();
		form.setRequestDate1(new Date());

		model.addAttribute("mendanForm",form);

		return "gakusei/entryInput";
	}

	@RequestMapping(value = "/toConfirm", method = RequestMethod.GET)
	public String confirm(Locale locale, Model model) {
		return "gakusei/confirm";
	}


	@RequestMapping(value = "/toFinish", method = RequestMethod.GET)
	public String finish(Locale locale, Model model) {
		return "gakusei/finish";
	}

	@RequestMapping(value = "/toGakuseiTop", method = RequestMethod.GET)
	public String returnTop(Locale locale, Model model) {
		return "gakusei/gakuseiTop";
	}




}
