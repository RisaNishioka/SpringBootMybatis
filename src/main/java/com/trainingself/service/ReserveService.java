package com.trainingself.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingself.dao.ReserveDao;
import com.trainingself.dto.Reserve;

@Service
public class ReserveService {

	@Autowired
	ReserveDao targetDao;

	public int daoCallInsertOne(Reserve dto){
		return targetDao.insertOne(dto);
	}

	public List<Map<String, Object>> daoCallSelectAll(){
		return targetDao.selectAll();
	}

	public List<Map<String, Object>> selectAllMybatis(){
		return targetDao.selectAllMybatis();
	}
}
