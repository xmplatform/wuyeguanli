/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.loudong.web;

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
import com.thinkgem.jeesite.modules.loudong.entity.DictLoudong;
import com.thinkgem.jeesite.modules.loudong.service.DictLoudongService;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyetaohu.service.DictTaohuService;

/**
 * 楼栋信息管理Controller
 * @author ktzhxm
 * @version 2015-12-07
 */
@Controller
@RequestMapping(value = "${adminPath}/loudong/dictLoudong")
public class DictLoudongController extends BaseController {
	@Autowired
	private DictTaohuService dictTaohuService;
	@Autowired
	private DictLoudongService dictLoudongService;
	
	@ModelAttribute
	public DictLoudong get(@RequestParam(required=false) String id) {
		DictLoudong entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dictLoudongService.get(id);
		}
		if (entity == null){
			entity = new DictLoudong();
		}
		return entity;
	}
	/**
	 * 套户信息查看
	 */
	@RequiresPermissions("wuyetaohu:dictTaohu:view")
	@RequestMapping(value = "index")
	public String index() {
		return "modules/loudong/taohuIndex";
	}
	
	@RequiresPermissions("loudong:dictLoudong:view")
	@RequestMapping(value = {"list", ""})
	public String list(DictLoudong dictLoudong, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DictLoudong> page = dictLoudongService.findPage(new Page<DictLoudong>(request, response), dictLoudong); 
		model.addAttribute("pids",dictLoudong.getPids());
		model.addAttribute("page", page);
		return "modules/loudong/dictLoudongList";
	}

	@RequiresPermissions("loudong:dictLoudong:view")
	@RequestMapping(value = "form")
	public String form(DictLoudong dictLoudong, Model model) {
		model.addAttribute("dictLoudong", dictLoudong);
		return "modules/loudong/dictLoudongForm";
	}

	@RequiresPermissions("loudong:dictLoudong:edit")
	@RequestMapping(value = "save")
	public String save(DictLoudong dictLoudong, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictLoudong)){
			return form(dictLoudong, model);
		}
		int num = dictLoudong.getChanshengsl();
		for(int i=1;i<=num;i++){
			DictLoudong lou=(DictLoudong) dictLoudong.clone();
			if(num!=1){
				lou.setMingcheng(i+dictLoudong.getMingcheng());
			}
			lou.setPid(lou.getPids().split(",")[1]);
			dictLoudongService.save(lou);
		}
		addMessage(redirectAttributes, "保存楼栋信息成功");
		return "redirect:"+Global.getAdminPath()+"/loudong/dictLoudong/?repage";
	}
	
	@RequiresPermissions("loudong:dictLoudong:edit")
	@RequestMapping(value = "delete")
	public String delete(DictLoudong dictLoudong, RedirectAttributes redirectAttributes) {
		List<WuyeJiben> list = dictLoudongService.loadSubById(dictLoudong.getId());
		if(list.size()==0){
			dictLoudongService.delete(dictLoudong);
			addMessage(redirectAttributes, "删除楼栋信息成功");
		}else{
			addMessage(redirectAttributes, "请先删除楼栋下的单元！");
		}
		return "redirect:"+Global.getAdminPath()+"/loudong/dictLoudong/?repage";
	}
	/**
	 * 显示物业--套户的树形菜单
	 * 
	 * @param dictHuzhu
	 * @param redirectAttributes
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "taohuTree")
	public List<Map<String, Object>> taohuTree(RedirectAttributes redirectAttributes) {
		List<WuyeJiben> list = dictTaohuService.loadAllData(3);
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