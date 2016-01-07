/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyejiben.web;

import java.util.List;

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
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyejiben.service.WuyeJibenService;

/**
 * 物业基本信息Controller
 * @author lixm
 * @version 2015-12-05
 */
@Controller
@RequestMapping(value = "${adminPath}/wuyejiben/wuyeJiben")
public class WuyeJibenController extends BaseController {

	@Autowired
	private WuyeJibenService wuyeJibenService;
	
	@ModelAttribute
	public WuyeJiben get(@RequestParam(required=false) String id) {
		WuyeJiben entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wuyeJibenService.get(id);
		}
		if (entity == null){
			entity = new WuyeJiben();
		}
		return entity;
	}
	
	@RequiresPermissions("wuyejiben:wuyeJiben:view")
	@RequestMapping(value = {"list", ""})
	public String list(WuyeJiben wuyeJiben, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WuyeJiben> page = wuyeJibenService.findPage(new Page<WuyeJiben>(request, response), wuyeJiben); 
		model.addAttribute("page", page);
		return "modules/wuyejiben/wuyeJibenList";
	}

	@RequiresPermissions("wuyejiben:wuyeJiben:view")
	@RequestMapping(value = "form")
	public String form(WuyeJiben wuyeJiben, Model model) {
		model.addAttribute("wuyeJiben", wuyeJiben);
		return "modules/wuyejiben/wuyeJibenForm";
	}

	@RequiresPermissions("wuyejiben:wuyeJiben:edit")
	@RequestMapping(value = "save")
	public String save(WuyeJiben wuyeJiben, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wuyeJiben)){
			return form(wuyeJiben, model);
		}
		wuyeJibenService.save(wuyeJiben);
		addMessage(redirectAttributes, "保存信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuyejiben/wuyeJiben/?repage";
	}
	
	@RequiresPermissions("wuyejiben:wuyeJiben:edit")
	@RequestMapping(value = "delete")
	public String delete(WuyeJiben wuyeJiben, RedirectAttributes redirectAttributes) {
		List<WuyeJiben> list = wuyeJibenService.loadSubById(wuyeJiben.getId());
		if(list.size()==0){
			wuyeJibenService.delete(wuyeJiben);
			addMessage(redirectAttributes, "删除信息成功");
		}else{
			addMessage(redirectAttributes, "请先删除公司下的小区！");
		}
		return "redirect:"+Global.getAdminPath()+"/wuyejiben/wuyeJiben/?repage";
	}

}