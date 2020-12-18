package com.trainingself.controller.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.trainingself.domain.model.Reserve;
import com.trainingself.repository.ReserveDao;

@Service
public class GakuseiService {

	private static final Logger logger = LoggerFactory.getLogger(GakuseiService.class);

	public void executeDaoMethodAll() throws IOException {
		ReserveDao reserveDao = new ReserveDao();


		//パターン１：Outを汎用MapでIF
		List<Map<String,Object>> resultList = reserveDao.selectAll();
		logger.info("selectAll"+resultList.toString());

		//パターン２：JavaBeans(DTO)でIF
		List<Reserve> reserve= reserveDao.selectAllWithDto();
		logger.info("selectAllWithDto"+reserve.toString());

		//パターン３：１件照会
		Integer receptionNo =1;
		Reserve reservedto = reserveDao.selectbyPK(receptionNo);
		logger.info("selectbyPK"+reservedto.toString());


		//パターン４：複数条件(map)・複数結果
		Map<String,Object> map = new HashMap<>();
		map.put("school", "Hoge大学");
		map.put("name", "名前１");
		reserveDao.selectCondition1(map);


		//パターン４：複数条件(dto)・複数結果
		Reserve condtion = new Reserve();
		condtion.setName("名前２");
		condtion.setSchool("Fuga大学");
		reserveDao.selectCondition2(condtion);

		//SELECT パターン５：動的なSQL
		Reserve condition2 = new Reserve();
		condition2.setReceptionNo("1");
		List<Reserve> reserve4 = reserveDao.selectCondition3_1(condition2);
		logger.info("●"+reserve4.toString());


		//SELECT パターン６：動的なSQL
		Reserve condtion3 = new Reserve();
		condtion3.setName("名前３");
		List<Reserve> reserve5 = reserveDao.selectCondition3_2(condtion3);
		logger.info("◇"+reserve5.toString());


		//insert
		Reserve insertDto = new Reserve();
		insertDto.setCreateDate(new Date());
		insertDto.setDev(true);
		insertDto.setMachingPoint("インサートテスト　マッチングポイント");
		insertDto.setName("インサート名前");
		insertDto.setReceptionNo(null);
		insertDto.setRequestDate1(new Date());
		insertDto.setRequestDate2(new Date());
		insertDto.setSchool("学校名");
		insertDto.setUpdateDate(new Date());
		int insertCount = reserveDao.insert(insertDto);
		logger.info("insertCount{}",insertCount);


		//update
		Reserve updateDto = new Reserve();
		updateDto.setRequestDate1(new Date());
		updateDto.setRequestDate2(new Date());
		updateDto.setSchool("学校名更新後");
		updateDto.setUpdateDate(new Date());
		updateDto.setReceptionNo("5");

		int updateCount = reserveDao.update(updateDto);
		logger.info("updateCount{}",updateCount);







	}
////
////	/**
////	 * 予約データを抽出する
////	 * @return
////	 * @throws IOException
////	 */
////	public List<Reserve> getAllReserveData() throws IOException {
////
////
////		try (InputStream in = GakuseiService.class.getResourceAsStream("/mybatis-config.xml")) {
////
////			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
////
////			try (SqlSession session = factory.openSession()) {
////
////
////				//SELECT パターン１：汎用Mapでの受け
////				List<Map<String,Object>> reserveList = session.selectList("reserveMapper.selectAll");
////				reserveList.forEach((result) -> {
////					logger.info("□"+result.toString());
////				});
////
////				//SELECT パターン２：JavaBeans(DTO)での受け
////				List<Reserve> reserveList2 = session.selectList("reserveMapper.selectAllWithDto");
////				reserveList2.forEach((result) -> {
////					logger.info("▼"+result.toString());
////				});
////
////				//SELECT パターン３：１件照会
////				Integer receptionNo = 1;
////				Reserve reserve = session.selectOne("reserveMapper.selectbyPK",receptionNo);
////				logger.info("★"+reserve.toString());
////
////2
////				//SELECT パターン４：複数条件(map)・複数結果
////				Map<String,Object> map = new HashMap<>();
////				map.put("school", "Hoge大学");
////				map.put("name", "名前１");
////				List<Reserve> reserve2 = session.selectList("reserveMapper.selectCondition1",map);
////				logger.info("▲"+reserve2.toString());
////
////
////
////				//SELECT パターン４：複数条件(dto)・複数結果
////				Reserve condtion = new Reserve();
////				condtion.setName("名前２");
////				condtion.setSchool("Fuga大学");
////				List<Reserve> reserve3 = session.selectList("reserveMapper.selectCondition2",condtion);
////				logger.info("◎"+reserve3.toString());
////
////
////
////				//SELECT パターン５：動的なSQL
////				Reserve condtion2 = new Reserve();
////				condtion2.setReceptionNo("1");
////				List<Reserve> reserve4 = session.selectList("reserveMapper.selectCondition3",condtion2);
////				logger.info("●"+reserve4.toString());
////
////
////				//SELECT パターン６：動的なSQL
////				Reserve condtion3 = new Reserve();
////				condtion3.setName("名前３");
////				List<Reserve> reserve5 = session.selectList("reserveMapper.selectCondition3",condtion3);
////				logger.info("◇"+reserve5.toString());
////
////
////				//insert
////				Reserve insertDto = new Reserve();
////				insertDto.setCreateDate(new Date());
////				insertDto.setDev(true);
////				insertDto.setMachingPoint("インサートテスト　マッチングポイント");
////				insertDto.setName("インサート名前");
////				insertDto.setReceptionNo(null);
////				insertDto.setRequestDate1(new Date());
////				insertDto.setRequestDate2(new Date());
////				insertDto.setSchool("学校名");
////				insertDto.setUpdateDate(new Date());
////				int insertCount = session.insert("reserveMapper.insert", insertDto);
////				logger.info("insertCount{}",insertCount);
////
////
////				Reserve selectCondition = new Reserve();
////				selectCondition.setName("インサート名前");
////
////				List<Reserve> reserve6 = session.selectList("reserveMapper.selectCondition3",selectCondition);
////				logger.info("◆"+reserve6.toString());
////
////
////				Reserve updateDto = new Reserve();
////				updateDto.setRequestDate1(new Date());
////				updateDto.setRequestDate2(new Date());
////				updateDto.setSchool("学校名更新後");
////				updateDto.setUpdateDate(new Date());
////				updateDto.setReceptionNo("5");
////
////				int updateCount = session.update("reserveMapper.update", updateDto);
////				logger.info("updateCount{}",updateCount);
////
////				List<Reserve> reserve7 = session.selectList("reserveMapper.selectCondition3",selectCondition);
////				logger.info("※"+reserve7.toString());
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
//
//
//
//				return null;
//			}
//
//		}
//	}
}
