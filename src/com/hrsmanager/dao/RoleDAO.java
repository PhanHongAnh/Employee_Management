package com.hrsmanager.dao;

import java.util.List;

import com.hrsmanager.model.Roles;

public interface RoleDAO {
	public List<Roles> listRoles();
	public Roles findRolesByID(Integer role_id);
	public Roles findRolesByName(String role_name);

}
