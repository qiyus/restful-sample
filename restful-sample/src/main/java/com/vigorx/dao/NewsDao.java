package com.vigorx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vigorx.dbentity.NewsDBEntity;

/**
 * DynamicDao
 * @author songlei
 */
@Repository
public interface NewsDao {
	public List<NewsDBEntity> getNewList(int limit, int offset, int type);
	public NewsDBEntity getNewDetail(String infoId, String organId, int type);
}
