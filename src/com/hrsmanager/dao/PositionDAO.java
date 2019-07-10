package com.hrsmanager.dao;

import java.util.List;

import com.hrsmanager.model.PositionInfo;

public interface PositionDAO {
	public PositionInfo findPositionInfo(Integer position_id);
	public List<PositionInfo> listPositions();
}
