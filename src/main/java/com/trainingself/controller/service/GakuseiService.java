package com.trainingself.controller.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.trainingself.domain.model.Reserve;

@Service
public class GakuseiService {

	private static final Logger logger = LoggerFactory.getLogger(GakuseiService.class);

	/**
	 * 予約データを抽出する
	 * @return
	 * @throws IOException
	 */
	public List<Reserve> getAllReserveData() throws IOException {


		try (InputStream in = GakuseiService.class.getResourceAsStream("/mybatis-config.xml")) {

			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

			try (SqlSession session = factory.openSession()) {

				List<Map<String,Object>> reserveList = session.selectList("reserveMapper.selectAll");

				reserveList.forEach((result) -> {
					logger.info(result.toString());
				});

				return null;
			}

		}
	}
}
