/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyexiaoqu.web;

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
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyexiaoqu.entity.WuyeXiaoqu;
import com.thinkgem.jeesite.modules.wuyexiaoqu.service.WuyeXiaoquService;

/**
 * 小区信息Controller
 * @author ktzhxm
 * @version 2015-12-06
 */
@Controller
@RequestMapping(value = "${adminPath}/wuyexiaoqu/wuyeXiaoqu")
public class WuyeXiaoquController extends BaseController {

	@Autowired
	private WuyeXiaoquService wuyeXiaoquService;
	
	@ModelAttribute
	public WuyeXiaoqu get(@RequestParam(required=false) String id) {
		WuyeXiaoqu entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wuyeXiaoquService.get(id);
		}
		if (entity == null){
			entity = new WuyeXiaoqu();
		}
		return entity;
	}
	
	@RequiresPermissions("wuyexiaoqu:wuyeXiaoqu:view")
	@RequestMapping(value = {"list", ""})
	public String list(WuyeXiaoqu wuyeXiaoqu, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WuyeXiaoqu> page = wuyeXiaoquService.findPage(new Page<WuyeXiaoqu>(request, response), wuyeXiaoqu); 
		model.addAttribute("page", page);
		return "modules/wuyexiaoqu/wuyeXiaoquList";
	}

	@RequiresPermissions("wuyexiaoqu:wuyeXiaoqu:view")
	@RequestMapping(value = "form")
	public String form(WuyeXiaoqu wuyeXiaoqu, Model model) {
		WuyeJiben jiben = new WuyeJiben();
		jiben.setDelFlag("0");
		model.addAttribute("wuyeList",wuyeXiaoquService.findAllWuye(jiben));
		model.addAttribute("wuyeXiaoqu", wuyeXiaoqu);
		return "modules/wuyexiaoqu/wuyeXiaoquForm";
	}

	@RequiresPermissions("wuyexiaoqu:wuyeXiaoqu:edit")
	@RequestMapping(value = "save")
	public String save(WuyeXiaoqu wuyeXiaoqu, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wuyeXiaoqu)){
			return form(wuyeXiaoqu, model);
		}
		wuyeXiaoquService.save(wuyeXiaoqu);
		addMessage(redirectAttributes, "保存小区信息成功");
		return "redirect:"+Global.getAdminPath()+"/wuyexiaoqu/wuyeXiaoqu/?repage";
	}
	
	@RequiresPermissions("wuyexiaoqu:wuyeXiaoqu:edit")
	@RequestMapping(value = "delete")
	public String delete(WuyeXiaoqu wuyeXiaoqu, RedirectAttributes redirectAttributes) {
		List<WuyeJiben> list = wuyeXiaoquService.loadSubById(wuyeXiaoqu.getId());
		if(list.size()==0){
			wuyeXiaoquService.delete(wuyeXiaoqu);
			addMessage(redirectAttributes, "删除小区信息成功");
		}else{
			addMessage(redirectAttributes, "请先删除小区下的楼栋！");
		}
		return "redirect:"+Global.getAdminPath()+"/wuyexiaoqu/wuyeXiaoqu/?repage";
	}

}