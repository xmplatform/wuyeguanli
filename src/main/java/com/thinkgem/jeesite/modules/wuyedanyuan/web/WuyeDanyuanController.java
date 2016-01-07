/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyedanyuan.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.wuyedanyuan.entity.WuyeDanyuan;
import com.thinkgem.jeesite.modules.wuyedanyuan.service.WuyeDanyuanService;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyetaohu.service.DictTaohuService;

/**
 * 单元管理Controller
 * @author ktzhxm
 * @version 2015-12-12
 */
@Controller
@RequestMapping(value = "${adminPath}/wuyedanyuan/wuyeDanyuan")
public class WuyeDanyuanController extends BaseController {

	@Autowired
	private WuyeDanyuanService wuyeDanyuanService;
	@Autowired
	private DictTaohuService dictTaohuService;
	@ModelAttribute
	public WuyeDanyuan get(@RequestParam(required=false) String id) {
		WuyeDanyuan entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wuyeDanyuanService.get(id);
		}
		if (entity == null){
			entity = new WuyeDanyuan();
		}
		return entity;
	}
	
	@RequiresPermissions("wuyetaohu:dictTaohu:view")
	@RequestMapping(value = "index")
	public String index() {
		return "modules/wuyedanyuan/taohuIndex";
	}
	
	@RequiresPermissions("wuyedanyuan:wuyeDanyuan:view")
	@RequestMapping(value = {"list", ""})
	public String list(WuyeDanyuan wuyeDanyuan, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WuyeDanyuan> page = wuyeDanyuanService.findPage(new Page<WuyeDanyuan>(request, response), wuyeDanyuan); 
		model.addAttribute("pids",wuyeDanyuan.getPids());
		model.addAttribute("page", page);
		return "modules/wuyedanyuan/wuyeDanyuanList";
	}

	@RequiresPermissions("wuyedanyuan:wuyeDanyuan:view")
	@RequestMapping(value = "form")
	public String form(WuyeDanyuan wuyeDanyuan, Model model) {
		model.addAttribute("wuyeDanyuan", wuyeDanyuan);
		return "modules/wuyedanyuan/wuyeDanyuanForm";
	}

	@RequiresPermissions("wuyedanyuan:wuyeDanyuan:edit")
	@RequestMapping(value = "save")
	public String save(WuyeDanyuan wuyeDanyuan, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wuyeDanyuan)){
			return form(wuyeDanyuan, model);
		}
		int num=wuyeDanyuan.getChanshengsl();
		for(int i=1;i<=num;i++){
			WuyeDanyuan danyuan=(WuyeDanyuan) wuyeDanyuan.clone();
			if(num!=1)
				danyuan.setMingcheng(i+wuyeDanyuan.getMingcheng());
			danyuan.setPid(danyuan.getPids().split(",")[2]);
			wuyeDanyuanService.save(danyuan);
		}
		addMessage(redirectAttributes, "保存单元信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuyedanyuan/wuyeDanyuan/?repage";
	}
	
	@RequiresPermissions("wuyedanyuan:wuyeDanyuan:edit")
	@RequestMapping(value = "delete")
	public String delete(WuyeDanyuan wuyeDanyuan, RedirectAttributes redirectAttributes) {
		List<WuyeJiben> list = wuyeDanyuanService.loadSubById(wuyeDanyuan.getId());
		if(list.size()==0){
			wuyeDanyuanService.delete(wuyeDanyuan);
			addMessage(redirectAttributes, "删除单元信息成功");
		}else{
			addMessage(redirectAttributes, "请先删除单元下的套户！");
		}
		return "redirect:"+Global.getAdminPath()+"/wuyedanyuan/wuyeDanyuan/?repage";
	}
	
	@ResponseBody
	@RequestMapping(value = "taohuTree")
	public List<Map<String, Object>> taohuTree(RedirectAttributes redirectAttributes) {
		List<WuyeJiben> list = dictTaohuService.loadAllData(4);
		List<Map<String, Object>> mapList = Lists.newArrayList();
		for (WuyeJiben wuye : list) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", wuye.getId());
			map.put("pId", wuye.getDizhi());
			map.put("pIds", wuye.getDianhua());
			map.put("name", wuye.getMingcheng());
			String imgPath = "/jeesite/static/jquery-ztree/3.5.12/css/zTreeStyle/img/diy/";
			switch (Integer.parseInt(wuye.getRenshu())) {
			case 0:
			case 1:
			case 2:
			case 3:
				map.put("isParent", true);
				break;
			case 4:
				map.put("isParent", false);
				map.put("icon", imgPath + "house.png");
			}
			mapList.add(map);
		}
		return mapList;
	}
}