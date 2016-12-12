package com.vigorx.news;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vigorx.dao.NewsDao;
import com.vigorx.dbentity.NewsDBEntity;

@Service("dynamicService")
@Transactional
public class DynamicService {

	@Resource
	private NewsDao newsDao;
	
	public List<DynamicResult> getDymanicList(int limit, int offset, int type) {
		List<DynamicResult> rs = new ArrayList<DynamicResult>();
		List<NewsDBEntity> news = newsDao.getNewList(limit, offset, type);
		for (NewsDBEntity n : news) {
			DynamicResult r = new DynamicResult();
			r.setId(n.getInfoId());
			r.setOrganid(n.getOrganid());
			r.setTitle(n.getTitle());
			r.setPublishTime(n.getPublishTime());
			rs.add(r);
		}

		return rs;
	}
	
	public DynamicDetailResult getDymanicDetail(String infoId, String organId, int type) {
		NewsDBEntity d = newsDao.getNewDetail(infoId, organId, type);
		DynamicDetailResult detail = new DynamicDetailResult();
		if (null == d) {
			detail = null;
		} else {
			detail.setNewsContent(d.getDetail());
		}
		return detail;
	}
}
