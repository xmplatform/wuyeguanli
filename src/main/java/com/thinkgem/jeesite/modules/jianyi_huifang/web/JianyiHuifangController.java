/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.jianyi_huifang.web;

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
import com.thinkgem.jeesite.modules.jianyi_huifang.entity.JianyiHuifang;
import com.thinkgem.jeesite.modules.jianyi_huifang.service.JianyiHuifangService;
import com.thinkgem.jeesite.modules.jianyi_xinxi.service.JianyiXinxiService;

/**
 * 建议回访Controller
 * @author ktzhxm
 * @version 2016-01-10
 */
@Controller
@RequestMapping(value = "${adminPath}/jianyi_huifang/jianyiHuifang")
public class JianyiHuifangController extends BaseController {

	@Autowired
	private JianyiHuifangService jianyiHuifangService;
	@Autowired
	private JianyiXinxiService jianyiService;
	
	@ModelAttribute
	public JianyiHuifang get(@RequestParam(required=false) String id) {
		JianyiHuifang entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jianyiHuifangService.get(id);
		}
		if (entity == null){
			entity = new JianyiHuifang();
		}
		return entity;
	}
	
	@RequiresPermissions("jianyi_huifang:jianyiHuifang:view")
	@RequestMapping(value = {"list", ""})
	public String list(JianyiHuifang jianyiHuifang, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JianyiHuifang> page = jianyiHuifangService.findPage(new Page<JianyiHuifang>(request, response), jianyiHuifang); 
		model.addAttribute("jianyiObj", jianyiService.get(jianyiHuifang.getXinxiid()));
		model.addAttribute("page", page);
		return "modules/jianyi_huifang/jianyiHuifangList";
	}

	@RequiresPermissions("jianyi_huifang:jianyiHuifang:view")
	@RequestMapping(value = "form")
	public String form(JianyiHuifang jianyiHuifang, Model model) {
		model.addAttribute("jianyiHuifang", jianyiHuifang);
		return "modules/jianyi_huifang/jianyiHuifangForm";
	}

	@RequiresPermissions("jianyi_huifang:jianyiHuifang:edit")
	@RequestMapping(value = "save")
	public String save(JianyiHuifang jianyiHuifang, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jianyiHuifang)){
			return form(jianyiHuifang, model);
		}
		jianyiHuifangService.save(jianyiHuifang);
		addMessage(redirectAttributes, "保存回访成功");
		return "redirect:"+Global.getAdminPath()+"/jianyi_huifang/jianyiHuifang/?repage&xinxiid="+jianyiHuifang.getXinxiid();
	}
	
	@RequiresPermissions("jianyi_huifang:jianyiHuifang:edit")
	@RequestMapping(value = "delete")
	public String delete(JianyiHuifang jianyiHuifang, RedirectAttributes redirectAttributes) {
		jianyiHuifangService.delete(jianyiHuifang);
		addMessage(redirectAttributes, "删除回访成功");
		return "redirect:"+Global.getAdminPath()+"/jianyi_huifang/jianyiHuifang/?repage";
	}

}