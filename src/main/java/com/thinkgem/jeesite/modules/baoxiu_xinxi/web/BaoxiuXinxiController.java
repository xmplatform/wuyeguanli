/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_xinxi.web;

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
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.baoxiu_paiban.entity.BaoxiuPaiban;
import com.thinkgem.jeesite.modules.baoxiu_xinxi.entity.BaoxiuXinxi;
import com.thinkgem.jeesite.modules.baoxiu_xinxi.service.BaoxiuXinxiService;

/**
 * 报修信息主表Controller
 * 
 * @author ktzhxm
 * @version 2016-01-02
 */
@Controller
@RequestMapping(value = "${adminPath}/baoxiu_xinxi/baoxiuXinxi")
public class BaoxiuXinxiController extends BaseController {

	@Autowired
	private BaoxiuXinxiService baoxiuXinxiService;

	@ModelAttribute
	public BaoxiuXinxi get(@RequestParam(required = false) String id) {
		BaoxiuXinxi entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = baoxiuXinxiService.get(id);
		}
		if (entity == null) {
			entity = new BaoxiuXinxi();
		}
		return entity;
	}

	@RequiresPermissions("baoxiu_xinxi:baoxiuXinxi:view")
	@RequestMapping(value = { "list", "" })
	public String list(BaoxiuXinxi baoxiuXinxi, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<BaoxiuXinxi> page = baoxiuXinxiService
				.findPage(new Page<BaoxiuXinxi>(request, response), baoxiuXinxi);
		model.addAttribute("page", page);
		return "modules/baoxiu_xinxi/baoxiuXinxiList";
	}

	@RequiresPermissions("baoxiu_xinxi:baoxiuXinxi:view")
	@RequestMapping(value = "form")
	public String form(BaoxiuXinxi baoxiuXinxi, Model model) {
		model.addAttribute("baoxiuXinxi", baoxiuXinxi);
		return "modules/baoxiu_xinxi/baoxiuXinxiForm";
	}

	@RequiresPermissions("baoxiu_xinxi:baoxiuXinxi:edit")
	@RequestMapping(value = "save")
	public String save(BaoxiuXinxi baoxiuXinxi, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, baoxiuXinxi)) {
			return form(baoxiuXinxi, model);
		}
		baoxiuXinxiService.save(baoxiuXinxi);
		addMessage(redirectAttributes, "保存报修信息成功");
		return "redirect:" + Global.getAdminPath() + "/baoxiu_xinxi/baoxiuXinxi/?repage";
	}

	// 删除
	@RequiresPermissions("baoxiu_xinxi:baoxiuXinxi:edit")
	@RequestMapping(value = "delete")
	public String delete(BaoxiuXinxi baoxiuXinxi, RedirectAttributes redirectAttributes) {
		baoxiuXinxiService.delete(baoxiuXinxi);
		addMessage(redirectAttributes, "删除报修信息成功");
		return "redirect:" + Global.getAdminPath() + "/baoxiu_xinxi/baoxiuXinxi/?repage";
	}

	// 报修打印
	@RequiresPermissions("baoxiu_xinxi:baoxiuXinxi:view")
	@RequestMapping(value = "printWeixiu")
	public String printWeixiu(BaoxiuXinxi baoxiuXinxi, Model model) {
		model.addAttribute("baoxiuXinxi", baoxiuXinxi);
		return "modules/baoxiu_xinxi/printWeixiu";
	}

	// 找到可用维修工
	@ResponseBody
	@RequestMapping(value = "loadWeixiu")
	public List<Map<String, Object>> loadWeixiu(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/html;charset=GB2312");
		String riqi = req.getParameter("yuyuesj");
		List<BaoxiuPaiban> list = baoxiuXinxiService.loadWeixiu(riqi);
		
		List<Map<String, Object>> mapList = Lists.newArrayList();
		for (BaoxiuPaiban paiban : list) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", paiban.getRenyuanid().getId());
			map.put("name", paiban.getRenyuanid().getName());
			mapList.add(map);
		}

		return mapList;
	}
}