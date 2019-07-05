package com.hrsmanager.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsmanager.dao.PositionDAO;
import com.hrsmanager.mapper.PositionMapper;
import com.hrsmanager.model.PositionInfo;

@Service
@Transactional
public class PositionDAOImpl extends JdbcDaoSupport implements PositionDAO{

	@Autowired
	public PositionDAOImpl (DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public List<PositionInfo> listPositions() {
		String sql = "Select * from Positions";
		return getJdbcTemplate().query(sql, new PositionMapper());
	}
	
	@Override
	public PositionInfo findPositionByID(Integer position_id) {
		String sql = "select *from Positions p where p.position_id = ?";
		Object[]params = new Object[] {position_id};
		PositionMapper mapper = new PositionMapper();
		try {
			PositionInfo position = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return position;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public PositionInfo findPositionByName(String position_name) {
		String sql = "select *from Positions p where p.position_name = ?";
		Object[]params = new Object[] {position_name};
		PositionMapper mapper = new PositionMapper();
		try {
			PositionInfo position = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return position;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
