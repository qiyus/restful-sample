package com.vigorx.news;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigorx.Result;

@RestController
@RequestMapping(value = "/newsdynamic")
public class DynamicController {

	@Resource
	private DynamicService dynamicService;

	@RequestMapping(value = "news/newslist", method = RequestMethod.GET)
	public Result getNewsList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize) {

		List<DynamicResult> drs = dynamicService.getDymanicList(pageSize, pageSize
				* (pageNum - 1), 1);
		Result result = new Result();
		result.setResult(drs);
		return result;
	}

	@RequestMapping(value = "news/infodetail", method = RequestMethod.GET)
	public Result getNewsDetail(@RequestParam("id") String infoId,
			@RequestParam("organid") String organId) {

		DynamicDetailResult ddr = dynamicService.getDymanicDetail(infoId, organId, 1);
		Result result = new Result();
		result.setResult(ddr);
		return result;
	}

	@RequestMapping(value = "/regiondynamic/infolist", method = RequestMethod.GET)
	public Result getDynamicList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize) {

		List<DynamicResult> drs = dynamicService.getDymanicList(pageSize, pageSize
				* (pageNum - 1), 2);
		Result result = new Result();
		result.setResult(drs);
		return result;
	}

	@RequestMapping(value = "/regiondynamic/infodetail", method = RequestMethod.GET)
	public Result getDynamicDetail(@RequestParam("id") String infoId,
			@RequestParam("organid") String organId) {

		DynamicDetailResult ddr = dynamicService.getDymanicDetail(infoId, organId, 2);
		Result result = new Result();
		result.setResult(ddr);
		return result;
	}

}
