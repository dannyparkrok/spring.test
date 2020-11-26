package com.dannypark.springtest.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * PotlUsrDao
 * @author DannyPark.
 */
@Repository
public class PotlUsrDao {
	private static final Logger logger = LoggerFactory.getLogger(PotlUsrDao.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 포탈사용자 조회
	 * @param map
	 * @return
	 */
	public List<HashMap> selectPotlUsr(HashMap map) {
		return sqlSession.selectList("potlUsrDao.selectPotlUsr", map);
	}
}
