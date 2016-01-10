/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_jilu.web;

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
import com.thinkgem.jeesite.modules.baoxiu_jilu.entity.BaoxiuJilu;
import com.thinkgem.jeesite.modules.baoxiu_jilu.service.BaoxiuJiluService;
import com.thinkgem.jeesite.modules.baoxiu_xinxi.service.BaoxiuXinxiService;

/**
 * 维修记录Controller
 * @author ktzhxm
 * @version 2016-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/baoxiu_jilu/baoxiuJilu")
public class BaoxiuJiluController extends BaseController {

	@Autowired
	private BaoxiuJiluService baoxiuJiluService;
	@Autowired
	private BaoxiuXinxiService xinxiService;
	
	@ModelAttribute
	public BaoxiuJilu get(@RequestParam(required=false) String id) {
		BaoxiuJilu entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = baoxiuJiluService.get(id);
		}
		if (entity == null){
			entity = new BaoxiuJilu();
		}
		return entity;
	}
	
	@RequiresPermissions("baoxiu_jilu:baoxiuJilu:view")
	@RequestMapping(value = {"list", ""})
	public String list(BaoxiuJilu baoxiuJilu, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		Page<BaoxiuJilu> page = baoxiuJiluService.findPage(new Page<BaoxiuJilu>(request, response), baoxiuJilu); 
		model.addAttribute("xinxiObj", xinxiService.get(baoxiuJilu.getXinxi().getId()));
		model.addAttribute("page", page);
		return "modules/baoxiu_jilu/baoxiuJiluList";
	}

	@RequiresPermissions("baoxiu_jilu:baoxiuJilu:view")
	@RequestMapping(value = "form")
	public String form(BaoxiuJilu baoxiuJilu, Model model) {
		model.addAttribute("baoxiuJilu", baoxiuJilu);
		return "modules/baoxiu_jilu/baoxiuJiluForm";
	}

	@RequiresPermissions("baoxiu_jilu:baoxiuJilu:edit")
	@RequestMapping(value = "save")
	public String save(BaoxiuJilu baoxiuJilu, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, baoxiuJilu)){
			return form(baoxiuJilu, model);
		}
		baoxiuJiluService.save(baoxiuJilu);
		addMessage(redirectAttributes, "保存维修记录成功");
		return "redirect:"+Global.getAdminPath()+"/baoxiu_jilu/baoxiuJilu/?repage";
	}
	
	@RequiresPermissions("baoxiu_jilu:baoxiuJilu:edit")
	@RequestMapping(value = "delete")
	public String delete(BaoxiuJilu baoxiuJilu, RedirectAttributes redirectAttributes) {
		baoxiuJiluService.delete(baoxiuJilu);
		addMessage(redirectAttributes, "删除维修记录成功");
		return "redirect:"+Global.getAdminPath()+"/baoxiu_jilu/baoxiuJilu/?repage";
	}

}