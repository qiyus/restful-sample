package com.vigorx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vigorx.dbentity.BusinessDBEntity;

@Repository
public interface BusinessDao {
	public List<BusinessDBEntity> getBusinessList(String query, int limit, int offset);
	public BusinessDBEntity getBusinessDetail(String entNo, String regOrg);
}
