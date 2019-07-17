package com.hrsmanager.dao;

import java.util.List;

import com.hrsmanager.model.Status;

public interface StatusDAO {
	public List<Status> listStatus();
	public Status findStatusByID(Integer status_id);
	public Status findStatusByName(String status_name);
}
