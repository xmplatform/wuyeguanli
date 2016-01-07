/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyechewei.web;

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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.wuyechewei.entity.DictChewei;
import com.thinkgem.jeesite.modules.wuyechewei.service.DictCheweiService;

/**
 * 车位信息Controller
 * @author ktzhxm
 * @version 2015-12-10
 */
@Controller
@RequestMapping(value = "${adminPath}/wuyechewei/dictChewei")
public class DictCheweiController extends BaseController {

	@Autowired
	private DictCheweiService dictCheweiService;
	
	@ModelAttribute
	public DictChewei get(@RequestParam(required=false) String id) {
		DictChewei entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dictCheweiService.get(id);
		}
		if (entity == null){
			entity = new DictChewei();
		}
		return entity;
	}
	
	@RequiresPermissions("wuyechewei:dictChewei:view")
	@RequestMapping(value = {"list", ""})
	public String list(DictChewei dictChewei, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DictChewei> page = dictCheweiService.findPage(new Page<DictChewei>(request, response), dictChewei); 
		model.addAttribute("page", page);
		return "modules/wuyechewei/dictCheweiList";
	}

	@RequiresPermissions("wuyechewei:dictChewei:view")
	@RequestMapping(value = "form")
	public String form(DictChewei dictChewei, Model model) {
		model.addAttribute("dictChewei", dictChewei);
		return "modules/wuyechewei/dictCheweiForm";
	}
	
	@RequiresPermissions("wuyechewei:dictChewei:sale")
	@RequestMapping(value = "chuzu")
	public String chuzu(DictChewei dictChewei, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictChewei)){
			return form(dictChewei, model);
		}
		dictCheweiService.chuzu(dictChewei);
		addMessage(redirectAttributes, "车位出租成功");
		return "redirect:"+Global.getAdminPath()+"/wuyechewei/dictChewei/?repage";
	}
	
	@RequiresPermissions("wuyechewei:dictChewei:sale")
	@RequestMapping(value = "chushou")
	public String chushou(DictChewei dictChewei, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictChewei)){
			return form(dictChewei, model);
		}
		dictCheweiService.chushou(dictChewei);
		addMessage(redirectAttributes, "车位出售成功");
		return "redirect:"+Global.getAdminPath()+"/wuyechewei/dictChewei/?repage";
	}
	
	@RequiresPermissions("wuyechewei:dictChewei:edit")
	@RequestMapping(value = "save")
	public String save(DictChewei dictChewei, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictChewei)){
			return form(dictChewei, model);
		}
		dictCheweiService.save(dictChewei);
		addMessage(redirectAttributes, "保存车位成功");
		return "redirect:"+Global.getAdminPath()+"/wuyechewei/dictChewei/?repage";
	}
	
	@RequiresPermissions("wuyechewei:dictChewei:edit")
	@RequestMapping(value = "delete")
	public String delete(DictChewei dictChewei, RedirectAttributes redirectAttributes) {
		dictCheweiService.delete(dictChewei);
		addMessage(redirectAttributes, "删除车位成功");
		return "redirect:"+Global.getAdminPath()+"/wuyechewei/dictChewei/?repage";
	}
	/*
	 * 页面跳转方法
	 */
	@RequiresPermissions("wuyechewei:dictChewei:view")
	@RequestMapping(value = "turn2Chuzu")
	public String turn2Chuzu(DictChewei dictChewei, Model model) {
		model.addAttribute("dictChewei", dictChewei);
		model.addAttribute("renyuanList",dictCheweiService.findRenyuanList());
		return "modules/wuyechewei/dictCheweiChuzu";
	}
	@RequiresPermissions("wuyechewei:dictChewei:view")
	@RequestMapping(value = "turn2Chushou")
	public String turn2Chushou(DictChewei dictChewei, Model model) {
		model.addAttribute("dictChewei", dictChewei);
		model.addAttribute("renyuanList",dictCheweiService.findRenyuanList());
		return "modules/wuyechewei/dictCheweiChushou";
	}
	@RequiresPermissions("wuyechewei:dictChewei:view")
	@RequestMapping(value = "turn2Chakan")
	public String turn2Chakan(DictChewei dictChewei, Model model) {
		model.addAttribute("dictChewei", dictChewei);
		return "modules/wuyechewei/dictCheweiChakan";
	}
}