package com.vigorx.support;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vigorx.dao.SupportDao;
import com.vigorx.dbentity.SupportDBEntity;

@Service("supportService")
@Transactional
public class SupportService {

	@Resource
	private SupportDao supportDao;
	
	public List<SupportResult> getPolicyList(int limit, int offset, String type) {
		List<SupportResult> rs = new ArrayList<SupportResult>();
		List<SupportDBEntity> sps = supportDao.getSupportList(limit, offset, type);
		for (SupportDBEntity s : sps) {
			SupportResult r = new SupportResult();
			r.setId(s.getInfoId());
			r.setOrganid(s.getOrganid());
			r.setTitle(s.getTitle());
			r.setPublishTime(s.getPublishTime());
			r.setType(s.getType());
			rs.add(r);
		}

		return rs;
	}
	
	public SupportDetailResult getPolicyDetail(String infoId, String organId, String type) {
		SupportDBEntity d = supportDao.getSupportDetail(infoId, organId, type);
		SupportDetailResult detail = new SupportDetailResult();
		if (null == d) {
			detail = null;
		} else {
			detail.setContent(d.getDetail());
			List<AttachmentsResult> attachments = new ArrayList<AttachmentsResult>();
			for (int i = 0; i < 5; i++) {
				AttachmentsResult attachment = new AttachmentsResult();
				attachment.setAttName(attachment.getAttName() + i);
				attachments.add(attachment);
			}
			detail.setAttachments(attachments);
		}
		return detail;
	}
}
