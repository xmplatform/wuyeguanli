/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.daishou_wuliu.web;

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
import com.thinkgem.jeesite.modules.daishou_wuliu.entity.DaishouWuliugs;
import com.thinkgem.jeesite.modules.daishou_wuliu.service.DaishouWuliugsService;

/**
 * 物流公司Controller
 * @author ktzhxm
 * @version 2016-01-19
 */
@Controller
@RequestMapping(value = "${adminPath}/daishou_wuliu/daishouWuliugs")
public class DaishouWuliugsController extends BaseController {

	@Autowired
	private DaishouWuliugsService daishouWuliugsService;
	
	@ModelAttribute
	public DaishouWuliugs get(@RequestParam(required=false) String id) {
		DaishouWuliugs entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = daishouWuliugsService.get(id);
		}
		if (entity == null){
			entity = new DaishouWuliugs();
		}
		return entity;
	}
	
	@RequiresPermissions("daishou_wuliu:daishouWuliugs:view")
	@RequestMapping(value = {"list", ""})
	public String list(DaishouWuliugs daishouWuliugs, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DaishouWuliugs> page = daishouWuliugsService.findPage(new Page<DaishouWuliugs>(request, response), daishouWuliugs); 
		model.addAttribute("page", page);
		return "modules/daishou_wuliu/daishouWuliugsList";
	}

	@RequiresPermissions("daishou_wuliu:daishouWuliugs:view")
	@RequestMapping(value = "form")
	public String form(DaishouWuliugs daishouWuliugs, Model model) {
		model.addAttribute("daishouWuliugs", daishouWuliugs);
		return "modules/daishou_wuliu/daishouWuliugsForm";
	}

	@RequiresPermissions("daishou_wuliu:daishouWuliugs:edit")
	@RequestMapping(value = "save")
	public String save(DaishouWuliugs daishouWuliugs, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, daishouWuliugs)){
			return form(daishouWuliugs, model);
		}
		daishouWuliugsService.save(daishouWuliugs);
		addMessage(redirectAttributes, "保存信息成功");
		return "redirect:"+Global.getAdminPath()+"/daishou_wuliu/daishouWuliugs/?repage";
	}
	
	@RequiresPermissions("daishou_wuliu:daishouWuliugs:edit")
	@RequestMapping(value = "delete")
	public String delete(DaishouWuliugs daishouWuliugs, RedirectAttributes redirectAttributes) {
		daishouWuliugsService.delete(daishouWuliugs);
		addMessage(redirectAttributes, "删除信息成功");
		return "redirect:"+Global.getAdminPath()+"/daishou_wuliu/daishouWuliugs/?repage";
	}

}