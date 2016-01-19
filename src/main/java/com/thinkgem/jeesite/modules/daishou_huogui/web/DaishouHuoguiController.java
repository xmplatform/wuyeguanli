/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.daishou_huogui.web;

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
import com.thinkgem.jeesite.modules.daishou_huogui.entity.DaishouHuogui;
import com.thinkgem.jeesite.modules.daishou_huogui.service.DaishouHuoguiService;

/**
 * 货柜信息Controller
 * @author ktzhxm
 * @version 2016-01-19
 */
@Controller
@RequestMapping(value = "${adminPath}/daishou_huogui/daishouHuogui")
public class DaishouHuoguiController extends BaseController {

	@Autowired
	private DaishouHuoguiService daishouHuoguiService;
	
	@ModelAttribute
	public DaishouHuogui get(@RequestParam(required=false) String id) {
		DaishouHuogui entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = daishouHuoguiService.get(id);
		}
		if (entity == null){
			entity = new DaishouHuogui();
		}
		return entity;
	}
	
	@RequiresPermissions("daishou_huogui:daishouHuogui:view")
	@RequestMapping(value = {"list", ""})
	public String list(DaishouHuogui daishouHuogui, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DaishouHuogui> page = daishouHuoguiService.findPage(new Page<DaishouHuogui>(request, response), daishouHuogui); 
		model.addAttribute("page", page);
		return "modules/daishou_huogui/daishouHuoguiList";
	}

	@RequiresPermissions("daishou_huogui:daishouHuogui:view")
	@RequestMapping(value = "form")
	public String form(DaishouHuogui daishouHuogui, Model model) {
		model.addAttribute("daishouHuogui", daishouHuogui);
		return "modules/daishou_huogui/daishouHuoguiForm";
	}

	@RequiresPermissions("daishou_huogui:daishouHuogui:edit")
	@RequestMapping(value = "save")
	public String save(DaishouHuogui daishouHuogui, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, daishouHuogui)){
			return form(daishouHuogui, model);
		}
		daishouHuoguiService.save(daishouHuogui);
		addMessage(redirectAttributes, "保存货柜信息成功");
		return "redirect:"+Global.getAdminPath()+"/daishou_huogui/daishouHuogui/?repage";
	}
	
	@RequiresPermissions("daishou_huogui:daishouHuogui:edit")
	@RequestMapping(value = "delete")
	public String delete(DaishouHuogui daishouHuogui, RedirectAttributes redirectAttributes) {
		daishouHuoguiService.delete(daishouHuogui);
		addMessage(redirectAttributes, "删除货柜信息成功");
		return "redirect:"+Global.getAdminPath()+"/daishou_huogui/daishouHuogui/?repage";
	}

}