/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_heimingd.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.wuye_heimingd.entity.DictHeimingd;
import com.thinkgem.jeesite.modules.wuye_heimingd.service.DictHeimingdService;

/**
 * 黑名单Controller
 * @author ktzhxm
 * @version 2015-12-21
 */
@Controller
@RequestMapping(value = "${adminPath}/wuye_heimingd/dictHeimingd")
public class DictHeimingdController extends BaseController {

	@Autowired
	private DictHeimingdService dictHeimingdService;
	
	@ModelAttribute
	public DictHeimingd get(@RequestParam(required=false) String id) {
		DictHeimingd entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dictHeimingdService.get(id);
		}
		if (entity == null){
			entity = new DictHeimingd();
		}
		return entity;
	}
	
	@RequiresPermissions("wuye_heimingd:dictHeimingd:view")
	@RequestMapping(value = {"list", ""})
	public String list(DictHeimingd dictHeimingd, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DictHeimingd> page = dictHeimingdService.findPage(new Page<DictHeimingd>(request, response), dictHeimingd); 
		model.addAttribute("page", page);
		return "modules/wuye_heimingd/dictHeimingdList";
	}

	@RequiresPermissions("wuye_heimingd:dictHeimingd:view")
	@RequestMapping(value = "form")
	public String form(DictHeimingd dictHeimingd, Model model) {
		model.addAttribute("dictHeimingd", dictHeimingd);
		model.addAttribute("renyuanList",dictHeimingdService.findRenyuanList());
		return "modules/wuye_heimingd/dictHeimingdForm";
	}

	@RequiresPermissions("wuye_heimingd:dictHeimingd:edit")
	@RequestMapping(value = "save")
	public String save(DictHeimingd dictHeimingd, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictHeimingd)){
			return form(dictHeimingd, model);
		}
		dictHeimingdService.save(dictHeimingd);
		addMessage(redirectAttributes, "保存黑名单信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuye_heimingd/dictHeimingd/?repage";
	}
	
	@RequiresPermissions("wuye_heimingd:dictHeimingd:edit")
	@RequestMapping(value = "delete")
	public String delete(DictHeimingd dictHeimingd, RedirectAttributes redirectAttributes) {
		dictHeimingdService.delete(dictHeimingd);
		addMessage(redirectAttributes, "删除黑名单信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuye_heimingd/dictHeimingd/?repage";
	}

}