package com.trainingself.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trainingself.dto.Reserve;
import com.trainingself.service.ReserveService;

@Repository("ReserveDao")
public class ReserveDao {

	@Autowired
	JdbcTemplate jdbc;

//	enum cols {
//		RECEPTION_NO, REQUEST_DATE1, REQUEST_DATE2, NAME, SCHOOL, DEV, MATCHING_POINT, CREATE_DATE, UPDATE_DATE
//	}

	SqlSessionFactory factory;

	public ReserveDao() {

		try (InputStream in = ReserveService.class.getResourceAsStream("/mybatis-config.xml")) {

			this.factory = new SqlSessionFactoryBuilder().build(in);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 1件登録
	public int insertOne(Reserve reserve) throws DataAccessException{

		// 1件登録
		int rowNumber = jdbc.update("INSERT INTO RESERVE_MEETING("
				+ "REQUEST_DATE1,"
				+ "REQUEST_DATE2,"
				+ "NAME,"
				+ "SCHOOL,"
				+ "DEV,"
				+ "MATCHING_POINT,"
				+ "CREATE_DATE,"
				+ "UPDATE_DATE"
				+ ")"
				+ "VALUES(?,?,?,?,?,?,?,?)",
				reserve.getRequestDate1(),
				reserve.getRequestDate2(),
				reserve.getName(),
				reserve.getSchool(),
				reserve.getDev(),
				reserve.getMatchingPoint(),
				new Date(),
				new Date()
				);

		return rowNumber;
	}

	/**
	 * H2DB
	 * SELECT パターン１：汎用MapでIF
	 * @return
	 */
	public List<Map<String, Object>> selectAll() {
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM RESERVE_MEETING");
		return getList;
	}

	/**
	 * mybatis
	 * SELECT パターン１：汎用MapでIF
	 * @return
	 */
	public List<Map<String, Object>> selectAllMybatis() {
		try (SqlSession session = factory.openSession()) {
			return session.selectList("reserveMapper.selectAll");
		}
	}


}
