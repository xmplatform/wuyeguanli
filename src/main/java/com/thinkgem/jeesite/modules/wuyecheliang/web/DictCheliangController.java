/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyecheliang.web;

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
import com.thinkgem.jeesite.modules.wuyecheliang.entity.DictCheliang;
import com.thinkgem.jeesite.modules.wuyecheliang.service.DictCheliangService;
import com.thinkgem.jeesite.modules.wuyechewei.entity.DictChewei;
import com.thinkgem.jeesite.modules.wuyechewei.service.DictCheweiService;

/**
 * 车辆信息Controller
 * @author ktzhxm
 * @version 2015-12-10
 */
@Controller
@RequestMapping(value = "${adminPath}/wuyecheliang/dictCheliang")
public class DictCheliangController extends BaseController {

	@Autowired
	private DictCheliangService dictCheliangService;
	@Autowired
	private DictCheweiService cheweiService;
	
	@ModelAttribute
	public DictCheliang get(@RequestParam(required=false) String id) {
		DictCheliang entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dictCheliangService.get(id);
		}
		if (entity == null){
			entity = new DictCheliang();
		}
		return entity;
	}
	
	@RequiresPermissions("wuyecheliang:dictCheliang:view")
	@RequestMapping(value = {"list", ""})
	public String list(DictCheliang dictCheliang, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DictCheliang> page = dictCheliangService.findPage(new Page<DictCheliang>(request, response), dictCheliang); 
		model.addAttribute("page", page);
		return "modules/wuyecheliang/dictCheliangList";
	}

	@RequiresPermissions("wuyecheliang:dictCheliang:view")
	@RequestMapping(value = "form")
	public String form(DictCheliang dictCheliang, Model model) {
		DictChewei c = new DictChewei();
		c.setShifousy("0");
		model.addAttribute("cheweiList",cheweiService.findList(c));
		
		model.addAttribute("renyuanList",cheweiService.findRenyuanList());
		model.addAttribute("dictCheliang", dictCheliang);
		return "modules/wuyecheliang/dictCheliangForm";
	}

	@RequiresPermissions("wuyecheliang:dictCheliang:edit")
	@RequestMapping(value = "save")
	public String save(DictCheliang dictCheliang, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictCheliang)){
			return form(dictCheliang, model);
		}
		dictCheliangService.save(dictCheliang);
		addMessage(redirectAttributes, "保存车辆信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuyecheliang/dictCheliang/?repage";
	}
	
	@RequiresPermissions("wuyecheliang:dictCheliang:edit")
	@RequestMapping(value = "delete")
	public String delete(DictCheliang dictCheliang, RedirectAttributes redirectAttributes) {
		dictCheliangService.delete(dictCheliang);
		addMessage(redirectAttributes, "删除车辆信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuyecheliang/dictCheliang/?repage";
	}
}
