/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_huifang.web;

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
import com.thinkgem.jeesite.modules.baoxiu_huifang.entity.BaoxiuHuifang;
import com.thinkgem.jeesite.modules.baoxiu_huifang.service.BaoxiuHuifangService;
import com.thinkgem.jeesite.modules.baoxiu_xinxi.service.BaoxiuXinxiService;

/**
 * 客户回访Controller
 * @author ktzhxm
 * @version 2016-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/baoxiu_huifang/baoxiuHuifang")
public class BaoxiuHuifangController extends BaseController {

	@Autowired
	private BaoxiuHuifangService baoxiuHuifangService;
	@Autowired
	private BaoxiuXinxiService xinxiService;
	
	@ModelAttribute
	public BaoxiuHuifang get(@RequestParam(required=false) String id) {
		BaoxiuHuifang entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = baoxiuHuifangService.get(id);
		}
		if (entity == null){
			entity = new BaoxiuHuifang();
		}
		return entity;
	}
	
	@RequiresPermissions("baoxiu_huifang:baoxiuHuifang:view")
	@RequestMapping(value = {"list", ""})
	public String list(BaoxiuHuifang baoxiuHuifang, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BaoxiuHuifang> page = baoxiuHuifangService.findPage(new Page<BaoxiuHuifang>(request, response), baoxiuHuifang); 
		model.addAttribute("xinxiObj", xinxiService.get(baoxiuHuifang.getXinxiId()));
		model.addAttribute("page", page);
		return "modules/baoxiu_huifang/baoxiuHuifangList";
	}

	@RequiresPermissions("baoxiu_huifang:baoxiuHuifang:view")
	@RequestMapping(value = "form")
	public String form(BaoxiuHuifang baoxiuHuifang, Model model,HttpServletRequest request) {
		model.addAttribute("xinxiId", request.getParameter("xinxiId"));
		model.addAttribute("baoxiuHuifang", baoxiuHuifang);
		return "modules/baoxiu_huifang/baoxiuHuifangForm";
	}

	@RequiresPermissions("baoxiu_huifang:baoxiuHuifang:edit")
	@RequestMapping(value = "save")
	public String save(BaoxiuHuifang baoxiuHuifang, Model model, RedirectAttributes redirectAttributes,HttpServletRequest request) {
		if (!beanValidator(model, baoxiuHuifang)){
			return form(baoxiuHuifang, model,request);
		}
		baoxiuHuifangService.save(baoxiuHuifang);
		addMessage(redirectAttributes, "保存回访信息成功");
		return "redirect:"+Global.getAdminPath()+"/baoxiu_huifang/baoxiuHuifang/?repage";
	}
	
	@RequiresPermissions("baoxiu_huifang:baoxiuHuifang:edit")
	@RequestMapping(value = "delete")
	public String delete(BaoxiuHuifang baoxiuHuifang, RedirectAttributes redirectAttributes) {
		baoxiuHuifangService.delete(baoxiuHuifang);
		addMessage(redirectAttributes, "删除回访信息成功");
		return "redirect:"+Global.getAdminPath()+"/baoxiu_huifang/baoxiuHuifang/?repage";
	}

}