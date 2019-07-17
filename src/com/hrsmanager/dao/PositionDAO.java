package com.hrsmanager.dao;

import java.util.List;

import com.hrsmanager.model.PositionInfo;

public interface PositionDAO {
	public List<PositionInfo> listPositions();
	public PositionInfo findPositionByID(Integer position_id);
	public PositionInfo findPositionByName(String position_name);
}
