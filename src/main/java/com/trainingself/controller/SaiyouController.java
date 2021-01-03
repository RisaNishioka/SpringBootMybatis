package com.trainingself.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.trainingself.dto.Reserve;
import com.trainingself.form.InquiryForm;
import com.trainingself.service.ReserveService;

@Controller
@SessionAttributes(value = { "inquiryForm", "mendanForm"})
public class SaiyouController {

	@Autowired
	private ReserveService rs;

	/**
	 * 採用トップ画面を表示
	 * http://localhost:8080/saiyouTop
	 *
	 */
	@RequestMapping(value = "/saiyou", method = RequestMethod.GET)
	public String saiyouTop(Model model) {
		return "saiyo/saiyouTop";
	}

	/**
	 * 面談日程一覧画面（初期状態）を表示
	 * http://localhost:8080/menndanScheduleList
	 *
	 */
	@RequestMapping(value = "/menndanScheduleList", method = RequestMethod.GET)
	public String menndanScheduleListFirst(Model model) {

		InquiryForm form = new InquiryForm();
		Calendar cal = Calendar.getInstance();
		DateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dfTime = new SimpleDateFormat("HH:MM");

		// StartDate・StartTime
		form.setStartDate(dfDate.format(cal.getTime()));
		form.setStartTime(dfTime.format(cal.getTime()));

		// EndDate・EndTime
		form.setEndDate(dfDate.format(cal.getTime()));
		form.setEndTime(dfTime.format(cal.getTime()));

		model.addAttribute("inquiryForm", form);

		// エントリー情報・日程をDBから取得
		Reserve reserveDto = new Reserve();

		List<Map<String, Object>> ls = new ArrayList<Map<String, Object>>();
		ls = rs.selectAllMybatis();

		System.out.println(rs.selectAllMybatis());

		for(Map<String, Object> map :ls) {
			reserveDto.setName((String)map.get("name"));
			reserveDto.setRequestDate1((Date)map.get("requestDate1"));
			reserveDto.setRequestDate2((Date)map.get("requestDate2"));
//			reserveDto.setDev((boolean)map.get("dev"));
			reserveDto.setSchool((String)map.get("school"));
		}

		System.out.println(reserveDto.getSchool());

		return "saiyo/menndanScheduleList";
	}

	/**
	 * 面談日程一覧画面（照会状態）を表示
	 * http://localhost:8080/menndanScheduleList
	 *
	 */
	@RequestMapping(value = "/menndanScheduleListInquiry", method = RequestMethod.GET)
	public String menndanScheduleListInquiry(Model model) {
		return "saiyo/menndanScheduleList";
	}

	/**
	 * 内容変更画面を表示
	 * http://localhost:8080/contentUpdate
	 *
	 */
	@RequestMapping(value = "/contentUpdate", method = RequestMethod.POST)
	public String contentUpdate(Model model) {
		return "saiyo/contentUpdate";
	}

}
