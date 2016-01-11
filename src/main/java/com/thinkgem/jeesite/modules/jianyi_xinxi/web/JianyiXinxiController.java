/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.jianyi_xinxi.web;

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
import com.thinkgem.jeesite.modules.jianyi_xinxi.entity.JianyiXinxi;
import com.thinkgem.jeesite.modules.jianyi_xinxi.service.JianyiXinxiService;

/**
 * 建议主表Controller
 * @author ktzhxm
 * @version 2016-01-10
 */
@Controller
@RequestMapping(value = "${adminPath}/jianyi_xinxi/jianyiXinxi")
public class JianyiXinxiController extends BaseController {

	@Autowired
	private JianyiXinxiService jianyiXinxiService;
	
	@ModelAttribute
	public JianyiXinxi get(@RequestParam(required=false) String id) {
		JianyiXinxi entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jianyiXinxiService.get(id);
		}
		if (entity == null){
			entity = new JianyiXinxi();
		}
		return entity;
	}
	
	@RequiresPermissions("jianyi_xinxi:jianyiXinxi:view")
	@RequestMapping(value = {"list", ""})
	public String list(JianyiXinxi jianyiXinxi, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JianyiXinxi> page = jianyiXinxiService.findPage(new Page<JianyiXinxi>(request, response), jianyiXinxi); 
		model.addAttribute("page", page);
		return "modules/jianyi_xinxi/jianyiXinxiList";
	}

	@RequiresPermissions("jianyi_xinxi:jianyiXinxi:view")
	@RequestMapping(value = "form")
	public String form(JianyiXinxi jianyiXinxi, Model model) {
		model.addAttribute("jianyiXinxi", jianyiXinxi);
		return "modules/jianyi_xinxi/jianyiXinxiForm";
	}

	@RequiresPermissions("jianyi_xinxi:jianyiXinxi:edit")
	@RequestMapping(value = "save")
	public String save(JianyiXinxi jianyiXinxi, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jianyiXinxi)){
			return form(jianyiXinxi, model);
		}
		//结果填写内容表示已处理，未填写则处理中
		jianyiXinxi.setZhuangtai(jianyiXinxi.getJieguo().length()>0?"2":"1");
		
		jianyiXinxiService.save(jianyiXinxi);
		addMessage(redirectAttributes, "保存建议成功");
		return "redirect:"+Global.getAdminPath()+"/jianyi_xinxi/jianyiXinxi/?repage";
	}
	
	@RequiresPermissions("jianyi_xinxi:jianyiXinxi:edit")
	@RequestMapping(value = "delete")
	public String delete(JianyiXinxi jianyiXinxi, RedirectAttributes redirectAttributes) {
		jianyiXinxiService.delete(jianyiXinxi);
		addMessage(redirectAttributes, "删除建议成功");
		return "redirect:"+Global.getAdminPath()+"/jianyi_xinxi/jianyiXinxi/?repage";
	}

}