package com.adrbook.model;

import java.util.List;

public interface AdrbookDaoIMP   {
	public void insert(AdrbookVO adrbookVO);
	public void update(AdrbookVO adrbookVO);
	public void delete(String xuid);
	public List<AdrbookVO> getAll();
}
