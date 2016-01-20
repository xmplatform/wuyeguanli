/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.daishou_jilu.web;

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
import com.thinkgem.jeesite.modules.daishou_jilu.entity.DaishouJilu;
import com.thinkgem.jeesite.modules.daishou_jilu.service.DaishouJiluService;
import com.thinkgem.jeesite.modules.daishou_wuliu.entity.DaishouWuliugs;
import com.thinkgem.jeesite.modules.daishou_wuliu.service.DaishouWuliugsService;

/**
 * 代收付业务表Controller
 * @author ktzhxm
 * @version 2016-01-20
 */
@Controller
@RequestMapping(value = "${adminPath}/daishou_jilu/daishouJilu")
public class DaishouJiluController extends BaseController {

	@Autowired
	private DaishouJiluService daishouJiluService;
	@Autowired
	private DaishouWuliugsService wuliuService;
	@Autowired
	private DaishouHuoguiService huoguiService;
	
	@ModelAttribute
	public DaishouJilu get(@RequestParam(required=false) String id) {
		DaishouJilu entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = daishouJiluService.get(id);
		}
		if (entity == null){
			entity = new DaishouJilu();
		}
		return entity;
	}
	
	@RequiresPermissions("daishou_jilu:daishouJilu:view")
	@RequestMapping(value = {"list", ""})
	public String list(DaishouJilu daishouJilu, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DaishouJilu> page = daishouJiluService.findPage(new Page<DaishouJilu>(request, response), daishouJilu); 
		model.addAttribute("page", page);
		DaishouWuliugs wuliu = new DaishouWuliugs();
		wuliu.setDelFlag("0");
		model.addAttribute("wuliuList",wuliuService.findList(wuliu));
		return "modules/daishou_jilu/daishouJiluList";
	}

	@RequiresPermissions("daishou_jilu:daishouJilu:view")
	@RequestMapping(value = "form")
	public String form(DaishouJilu daishouJilu, Model model) {
		model.addAttribute("daishouJilu", daishouJilu);
		DaishouWuliugs wuliu = new DaishouWuliugs();
		wuliu.setDelFlag("0");
		model.addAttribute("wuliuList",wuliuService.findList(wuliu));
		DaishouHuogui huogui = new DaishouHuogui();
		huogui.setDelFlag("0");
		model.addAttribute("huoguiList",huoguiService.findList(huogui));
		return "modules/daishou_jilu/daishouJiluForm";
	}

	@RequiresPermissions("daishou_jilu:daishouJilu:edit")
	@RequestMapping(value = "save")
	public String save(DaishouJilu daishouJilu, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, daishouJilu)){
			return form(daishouJilu, model);
		}
		daishouJiluService.save(daishouJilu);
		addMessage(redirectAttributes, "保存信息成功");
		return "redirect:"+Global.getAdminPath()+"/daishou_jilu/daishouJilu/?repage";
	}
	
	@RequiresPermissions("daishou_jilu:daishouJilu:edit")
	@RequestMapping(value = "delete")
	public String delete(DaishouJilu daishouJilu, RedirectAttributes redirectAttributes) {
		daishouJiluService.delete(daishouJilu);
		addMessage(redirectAttributes, "删除信息成功");
		return "redirect:"+Global.getAdminPath()+"/daishou_jilu/daishouJilu/?repage";
	}

}