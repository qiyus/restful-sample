package com.vigorx.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vigorx.dao.BusinessDao;
import com.vigorx.dbentity.BusinessDBEntity;

@Service("businessService")
@Transactional
public class BusinessService {
	@Resource
	private BusinessDao businessDao;

	public List<BusinessResult> getBusinessList(String query, int limit, int offset) {
		List<BusinessResult> bsrs = new ArrayList<BusinessResult>();
		List<BusinessDBEntity> dbs = businessDao.getBusinessList(query, limit, offset);
		for (BusinessDBEntity db : dbs) {
			BusinessResult bsr = new BusinessResult();
			bsr.setEntNo(db.getEntNo());
			bsr.setEntName(db.getEntName());
			bsr.setCode(db.getCode());
			bsr.setEntTypeStr(db.getEntTypeStr());
			bsr.setRegisteredCapital(db.getRegisteredCapital());
			bsr.setRegorg(db.getRegorg());
			bsr.setRegorgStr(db.getRegorgStr());
			bsrs.add(bsr);
		}

		return bsrs;
	}

	public BusinessDetailResult getBusinessDetail(String entNo, String regOrg) {
		BusinessDBEntity db = businessDao.getBusinessDetail(entNo, regOrg);
		BusinessDetailResult bsr = new BusinessDetailResult();
		bsr.setEntName(db.getEntName());
		bsr.setCode(db.getCode());
		bsr.setEntTypeStr(db.getEntTypeStr());
		bsr.setRegisteredCapital(db.getRegisteredCapital());
		bsr.setRegorgStr(db.getRegorgStr());
		bsr.setDepartment(db.getDepartment());
		bsr.setEstablishDate(db.getEstablishDate());
		bsr.setTradeCode(db.getTradeCode());
		
		BusinessDetailInfoResult info = new BusinessDetailInfoResult();
		info.setCode(db.getCode());
		info.setEntName(db.getEntName());
		info.setBasis(db.getsBasis());
		info.setAmount(db.getsAmount());
		info.setContent(db.getsContent());
		info.setDate(db.getsDate());
		info.setDepartment(db.getDepartment());
		
		bsr.setInfo(info);
		return bsr;
	}
}
