package com.hrsmanager.dao;

import java.util.List;

import com.hrsmanager.model.Status;

public interface StatusDAO {

	public Status findStatus(Integer status_id);
	public List<Status> listStatus();
}
