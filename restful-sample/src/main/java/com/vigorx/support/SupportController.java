package com.vigorx.support;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigorx.Result;

@RestController
@RequestMapping(value = "/policy")
public class SupportController {

	@Resource
	private SupportService supportService;

	@RequestMapping(value = "/center/infolist", method = RequestMethod.GET)
	public Result getLawList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize, @RequestParam("type") String type) {

		List<SupportResult> srs = supportService.getPolicyList(pageSize, pageSize
				* (pageNum - 1), type);
		Result result = new Result();
		result.setResult(srs);
		return result;
	}

	@RequestMapping(value = "/center/infodetail", method = RequestMethod.GET)
	public Result getLawDetail(@RequestParam("id") String infoId,
			@RequestParam("organid") String organId, @RequestParam("type") String type) {

		SupportDetailResult sdr = supportService.getPolicyDetail(infoId, organId, type);
		Result result = new Result();
		result.setResult(sdr);
		return result;
	}

	@RequestMapping(value = "/local/infolist", method = RequestMethod.GET)
	public Result getLocalList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize,
			@RequestParam(value = "type", required = false) String type) {

		List<SupportResult> srs = supportService.getPolicyList(pageSize, pageSize
				* (pageNum - 1), type);
		Result result = new Result();
		result.setResult(srs);
		return result;
	}

	@RequestMapping(value = "/local/infodetail", method = RequestMethod.GET)
	public Result getLocalDetail(@RequestParam("id") String infoId,
			@RequestParam("organid") String organId, @RequestParam("type") String type) {

		SupportDetailResult sdr = supportService.getPolicyDetail(infoId, organId, type);
		Result result = new Result();
		result.setResult(sdr);
		return result;
	}

	@RequestMapping(value = "/city/infolist", method = RequestMethod.GET)
	public Result getCityList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize,
			@RequestParam(value = "cityid", required = false) String cityid) {

		List<SupportResult> srs = supportService.getPolicyList(pageSize, pageSize
				* (pageNum - 1), cityid);
		Result result = new Result();
		result.setResult(srs);
		return result;
	}

	@RequestMapping(value = "/city/infodetail", method = RequestMethod.GET)
	public Result getCityDetail(@RequestParam("id") String infoId,
			@RequestParam("organid") String organId,
			@RequestParam(value = "cityid", required = true) String cityid) {

		SupportDetailResult sdr = supportService.getPolicyDetail(infoId, organId, cityid);
		Result result = new Result();
		result.setResult(sdr);
		return result;
	}

	@RequestMapping(value = "/city/info", method = RequestMethod.GET)
	public Result getCity() {
		
		Result result = new Result();
		List<CityResult> cites = new ArrayList<CityResult>();
		for (int i = 1; i <= 5; i++) {
			String name = "惠州";
			CityResult city = new CityResult();
			city.setCityId("L");
			city.setCityName(name + i);
			cites.add(city);
		}
		
		for (int i = 1; i <= 5; i++) {
			String name = "汕头";
			CityResult city = new CityResult();
			city.setCityId("P");
			city.setCityName(name + i);
			cites.add(city);
		}
		
		for (int i = 1; i <= 5; i++) {
			String name = "东莞";
			CityResult city = new CityResult();
			city.setCityId("D");
			city.setCityName(name + i);
			cites.add(city);
		}
		
		result.setResult(cites);
		return result;
	}
}
