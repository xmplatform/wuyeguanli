/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_templ.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.renwu_templ.entity.RenwuTempl;
import com.thinkgem.jeesite.modules.renwu_templ.service.RenwuTemplService;

/**
 * 任务计划模板Controller
 * @author ktzxm
 * @version 2016-01-15
 */
@Controller
@RequestMapping(value = "${adminPath}/renwu_templ/renwuTempl")
public class RenwuTemplController extends BaseController {

	@Autowired
	private RenwuTemplService renwuTemplService;
	
	@ModelAttribute
	public RenwuTempl get(@RequestParam(required=false) String id) {
		RenwuTempl entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = renwuTemplService.get(id);
		}
		if (entity == null){
			entity = new RenwuTempl();
		}
		return entity;
	}
	
	@RequiresPermissions("renwu_templ:renwuTempl:view")
	@RequestMapping(value = {"list", ""})
	public String list(RenwuTempl renwuTempl, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<RenwuTempl> list = renwuTemplService.findList(renwuTempl); 
		model.addAttribute("list", list);
		return "modules/renwu_templ/renwuTemplList";
	}

	@RequiresPermissions("renwu_templ:renwuTempl:view")
	@RequestMapping(value = "form")
	public String form(RenwuTempl renwuTempl, Model model) {
		if (renwuTempl.getParent()!=null && StringUtils.isNotBlank(renwuTempl.getParent().getId())){
			renwuTempl.setParent(renwuTemplService.get(renwuTempl.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(renwuTempl.getId())){
				RenwuTempl renwuTemplChild = new RenwuTempl();
				renwuTemplChild.setParent(new RenwuTempl(renwuTempl.getParent().getId()));
				List<RenwuTempl> list = renwuTemplService.findList(renwuTempl); 
				if (list.size() > 0){
					renwuTempl.setSort(list.get(list.size()-1).getSort());
					if (renwuTempl.getSort() != null){
						renwuTempl.setSort(renwuTempl.getSort() + 30);
					}
				}
			}
		}
		if (renwuTempl.getSort() == null){
			renwuTempl.setSort(30);
		}
		model.addAttribute("renwuTempl", renwuTempl);
		return "modules/renwu_templ/renwuTemplForm";
	}

	@RequiresPermissions("renwu_templ:renwuTempl:edit")
	@RequestMapping(value = "save")
	public String save(RenwuTempl renwuTempl, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, renwuTempl)){
			return form(renwuTempl, model);
		}
		renwuTemplService.save(renwuTempl);
		addMessage(redirectAttributes, "保存计划成功");
		return "redirect:"+Global.getAdminPath()+"/renwu_templ/renwuTempl/?repage";
	}
	
	@RequiresPermissions("renwu_templ:renwuTempl:edit")
	@RequestMapping(value = "delete")
	public String delete(RenwuTempl renwuTempl, RedirectAttributes redirectAttributes) {
		renwuTemplService.delete(renwuTempl);
		addMessage(redirectAttributes, "删除计划成功");
		return "redirect:"+Global.getAdminPath()+"/renwu_templ/renwuTempl/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<RenwuTempl> list = renwuTemplService.findList(new RenwuTempl());
		for (int i=0; i<list.size(); i++){
			RenwuTempl e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
}