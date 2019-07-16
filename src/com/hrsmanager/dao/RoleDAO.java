package com.hrsmanager.dao;

import java.util.List;

import com.hrsmanager.model.Roles;

public interface RoleDAO {

	public Roles findRoles(Integer role_id);
	public List<Roles> listRoles();
}
