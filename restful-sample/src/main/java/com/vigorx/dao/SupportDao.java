package com.vigorx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vigorx.dbentity.SupportDBEntity;

;

/**
 * t_support
 * 
 * @author songlei
 */
public interface SupportDao {
	public List<SupportDBEntity> getSupportList(@Param("limit") int limit,
			@Param("offset") int offset, 
			@Param("type") String type);

	public SupportDBEntity getSupportDetail(String infoId, String organId, String type);
}
