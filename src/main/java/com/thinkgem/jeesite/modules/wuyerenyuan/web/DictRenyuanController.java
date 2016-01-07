/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyerenyuan.web;

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
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;
import com.thinkgem.jeesite.modules.wuyerenyuan.service.DictRenyuanService;
import com.thinkgem.jeesite.modules.wuyetaohu.service.DictTaohuService;

/**
 * 住户人员信息Controller
 * 
 * @author ktzhxm
 * @version 2015-12-14
 */
@Controller
@RequestMapping(value = "${adminPath}/wuyerenyuan/dictRenyuan")
public class DictRenyuanController extends BaseController {

	@Autowired
	private DictRenyuanService dictRenyuanService;
	@Autowired
	private DictTaohuService dictTaohuService;

	@ModelAttribute
	public DictRenyuan get(@RequestParam(required = false) String id) {
		DictRenyuan entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = dictRenyuanService.get(id);
		}
		if (entity == null) {
			entity = new DictRenyuan();
		}
		return entity;
	}

	/**
	 * 套户信息查看
	 * 
	 * @return
	 */
	@RequiresPermissions("wuyerenyuan:dictRenyuan:view")
	@RequestMapping(value = "index")
	public String index() {
		return "modules/wuyerenyuan/taohuIndex";
	}

	@RequiresPermissions("wuyerenyuan:dictRenyuan:view")
	@RequestMapping(value = { "list", "" })
	public String list(DictRenyuan dictRenyuan, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DictRenyuan> page = dictRenyuanService.findPage(new Page<DictRenyuan>(request, response), dictRenyuan);
		model.addAttribute("pids", dictRenyuan.getPids());
		model.addAttribute("page", page);
		return "modules/wuyerenyuan/dictRenyuanList";
	}

	/**
	 * 通过套户号查看人员列表
	 */
	@RequiresPermissions("wuyerenyuan:dictRenyuan:view")
	@RequestMapping(value = "searchByTaohuId")
	public String searchByTaohuId(DictRenyuan dictRenyuan, HttpServletRequest request, Model model) {
		model.addAttribute("userList", dictRenyuanService.findList(dictRenyuan));
		return "modules/wuyerenyuan/dictRenyuanListByTaohuId";
	}

	@RequiresPermissions("wuyerenyuan:dictRenyuan:view")
	@RequestMapping(value = "form")
	public String form(DictRenyuan dictRenyuan, Model model) {
		model.addAttribute("dictRenyuan", dictRenyuan);
		return "modules/wuyerenyuan/dictRenyuanForm";
	}

	@RequiresPermissions("wuyerenyuan:dictRenyuan:edit")
	@RequestMapping(value = "save")
	public String save(DictRenyuan dictRenyuan, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictRenyuan)) {
			return form(dictRenyuan, model);
		}
		dictRenyuan.setPid(dictRenyuan.getPids().split(",")[4]);

		dictRenyuanService.save(dictRenyuan);
		addMessage(redirectAttributes, "保存住户信息成功");
		return "redirect:" + Global.getAdminPath() + "/wuyerenyuan/dictRenyuan/?repage";
	}

	@RequiresPermissions("wuyerenyuan:dictRenyuan:edit")
	@RequestMapping(value = "delete")
	public String delete(DictRenyuan dictRenyuan, RedirectAttributes redirectAttributes) {
		String path = dictRenyuan.getPath();
		dictRenyuanService.delete(dictRenyuan);
		addMessage(redirectAttributes, "删除住户信息成功");
		return "redirect:" + Global.getAdminPath() + "/wuyerenyuan/dictRenyuan/?repage&pids="
				+ path.substring(path.lastIndexOf(',') + 1) + "&path=" + path;
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
	public List<Map<String, Object>> taohuTree(RedirectAttributes redirectAttributes,HttpServletRequest request) {
		List<WuyeJiben> list = dictTaohuService.loadAllData(5);
		List<Map<String, Object>> mapList = Lists.newArrayList();
		for (WuyeJiben wuye : list) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", wuye.getId());
			map.put("pId", wuye.getDizhi());
			map.put("pIds", wuye.getDianhua());
			map.put("name", wuye.getMingcheng());
			String imgPath = request.getContextPath()+"/static/jquery-ztree/3.5.12/css/zTreeStyle/img/diy/";
			switch (Integer.parseInt(wuye.getRenshu())) {
			case 0:
				map.put("col", "wuye");
				map.put("isParent", true);
				break;
			case 1:
				map.put("col", "xiaoqu");
				map.put("isParent", true);
				break;
			case 2:
				map.put("col", "loudong");
				map.put("isParent", true);
				break;
			case 3:
				map.put("col", "danyuan");
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