package com.thinkgem.jeesite.modules.mobile;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;
import com.thinkgem.jeesite.modules.wuyerenyuan.service.DictRenyuanService;

@Controller
@RequestMapping(value = "${adminPath}/mobile")
public class MobileController extends BaseController{
	@Autowired
	private DictRenyuanService renyuanService;
	
	@ResponseBody
	@RequestMapping(value = "getRenyuanByNum")
	public Map<String, Object> getRenyuanByNum(HttpServletRequest request,String num) {
		DictRenyuan ren =renyuanService.getRenyuanByNum(num);
		Map<String, Object> map = Maps.newHashMap();
		if(ren!=null){
			map.put("id", ren.getId());
			map.put("name",ren.getXingming());
		}
		return map;
	}
}
