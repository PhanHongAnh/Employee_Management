package com.hrsmanager.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsmanager.dao.EmployeeDAO;
import com.hrsmanager.mapper.EmployeeMapper;
import com.hrsmanager.model.EmployeeInfo;

@Service
@Transactional
public class EmployeeDAOImpl extends JdbcDaoSupport implements EmployeeDAO{
	
	@Autowired
	public EmployeeDAOImpl (DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	@Override
	public EmployeeInfo findEmployeeInfo(Integer employee_id) {
		String sql = "Select * from Employees emp where emp.employee_id = ? ";
		Object[] params = new Object[] {employee_id};
		EmployeeMapper mapper = new EmployeeMapper();
		try {
			EmployeeInfo emp = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return emp;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

}
