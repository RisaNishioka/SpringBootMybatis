package com.trainingself.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.trainingself.controller.service.GakuseiService;
import com.trainingself.domain.model.Reserve;

/**
 * MybatisのMapperを使用したSQL発行の基本的な挙動を確認するためのクラス
 * 本来はSpringの場合はアノテーションでインジェクションしたりapplication.propertiesを使ったりして
 * 定義するもの。ここではフレームワークに依存しない形で動かして基本的な形を理解する。
 *
 * @author hatsu
 *
 */
public class ReserveDao {

	SqlSessionFactory factory;

	/**
	 * コンストラクタにてmybatisのconfigを読み込みfactoryを初期化する
	 *
	 */
	public ReserveDao() {

		try (InputStream in = GakuseiService.class.getResourceAsStream("/mybatis-config.xml")) {

			this.factory = new SqlSessionFactoryBuilder().build(in);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * SELECT パターン１：汎用MapでIF
	 * @return
	 */
	public List<Map<String, Object>> selectAll() {

		try (SqlSession session = factory.openSession()) {

			return session.selectList("reserveMapper.selectAll");

		}

	}

	/**
	 * パターン２：JavaBeans(DTO)でIF
	 * @return
	 */
	public List<Reserve> selectAllWithDto() {
		try (SqlSession session = factory.openSession()) {
			return session.selectList("reserveMapper.selectAllWithDto");
		}
	}

	/**
	 * パターン３：１件照会
	 *
	 * @return
	 */
	public Reserve selectbyPK(Integer receptionNo) {

		try (SqlSession session = factory.openSession()) {
			return session.selectOne("reserveMapper.selectbyPK", receptionNo);
		}

	}

	/**
	 * パターン４：複数条件(map)・複数結果
	 *
	 * @return
	 */
	public List<Reserve> selectCondition1(Map<String,Object> condition) {
		try (SqlSession session = factory.openSession()) {
			return session.selectList("reserveMapper.selectCondition1", condition);
		}

	}

	/**
	 * SELECT パターン４：複数条件(dto)・複数結果
	 * @return
	 */
	public List<Reserve> selectCondition2(Reserve condition) {
		try (SqlSession session = factory.openSession()) {
			return session.selectList("reserveMapper.selectCondition2", condition);

		}

	}

	/**
	 * SELECT パターン５：動的なSQL・条件１
	 *
	 * @return
	 */
	public List<Reserve> selectCondition3_1(Reserve condition) {
		try (SqlSession session = factory.openSession()) {
			return session.selectList("reserveMapper.selectCondition3", condition);
		}

	}

	/**
	 * SELECT パターン５：動的なSQL・条件２
	 *
	 * @return
	 */
	public List<Reserve> selectCondition3_2(Reserve condtion) {
		try (SqlSession session = factory.openSession()) {
			return session.selectList("reserveMapper.selectCondition3", condtion);
		}

	}

	/**
	 * 登録(insert)用
	 * @return
	 */
	public int insert(Reserve insertDto ) {
		try (SqlSession session = factory.openSession()) {
			return session.insert("reserveMapper.insert", insertDto);
		}
	}

	/**
	 * 更新(update)用
	 */
	public int update(Reserve updateDto) {
		try (SqlSession session = factory.openSession()) {
			return session.update("reserveMapper.update", updateDto);
		}
	}




}
