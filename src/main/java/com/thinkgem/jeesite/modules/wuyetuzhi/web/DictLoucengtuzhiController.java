/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyetuzhi.web;

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
import com.thinkgem.jeesite.modules.wuyetuzhi.entity.DictLoucengtuzhi;
import com.thinkgem.jeesite.modules.wuyetuzhi.service.DictLoucengtuzhiService;

/**
 * 楼层图纸资料Controller
 * @author ktzhxm
 * @version 2015-12-09
 */
@Controller
@RequestMapping(value = "${adminPath}/wuyetuzhi/dictLoucengtuzhi")
public class DictLoucengtuzhiController extends BaseController {

	@Autowired
	private DictLoucengtuzhiService dictLoucengtuzhiService;
	
	@ModelAttribute
	public DictLoucengtuzhi get(@RequestParam(required=false) String id) {
		DictLoucengtuzhi entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dictLoucengtuzhiService.get(id);
		}
		if (entity == null){
			entity = new DictLoucengtuzhi();
		}
		return entity;
	}
	
	@RequiresPermissions("wuyetuzhi:dictLoucengtuzhi:view")
	@RequestMapping(value = {"list", ""})
	public String list(DictLoucengtuzhi dictLoucengtuzhi, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DictLoucengtuzhi> page = dictLoucengtuzhiService.findPage(new Page<DictLoucengtuzhi>(request, response), dictLoucengtuzhi); 
		model.addAttribute("page", page);
		return "modules/wuyetuzhi/dictLoucengtuzhiList";
	}

	@RequiresPermissions("wuyetuzhi:dictLoucengtuzhi:view")
	@RequestMapping(value = "form")
	public String form(DictLoucengtuzhi dictLoucengtuzhi, Model model) {
		model.addAttribute("dictLoucengtuzhi", dictLoucengtuzhi);
		return "modules/wuyetuzhi/dictLoucengtuzhiForm";
	}

	@RequiresPermissions("wuyetuzhi:dictLoucengtuzhi:edit")
	@RequestMapping(value = "save")
	public String save(DictLoucengtuzhi dictLoucengtuzhi, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictLoucengtuzhi)){
			return form(dictLoucengtuzhi, model);
		}
		dictLoucengtuzhiService.save(dictLoucengtuzhi);
		addMessage(redirectAttributes, "保存资料信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuyetuzhi/dictLoucengtuzhi/?repage";
	}
	
	@RequiresPermissions("wuyetuzhi:dictLoucengtuzhi:edit")
	@RequestMapping(value = "delete")
	public String delete(DictLoucengtuzhi dictLoucengtuzhi, RedirectAttributes redirectAttributes) {
		dictLoucengtuzhiService.delete(dictLoucengtuzhi);
		addMessage(redirectAttributes, "删除资料信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuyetuzhi/dictLoucengtuzhi/?repage";
	}

}