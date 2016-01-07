/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_paiban.web;

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
import com.thinkgem.jeesite.modules.baoxiu_paiban.entity.BaoxiuPaiban;
import com.thinkgem.jeesite.modules.baoxiu_paiban.service.BaoxiuPaibanService;

/**
 * 维修员排班Controller
 * 
 * @author ktzhxm
 * @version 2016-01-05
 */
@Controller
@RequestMapping(value = "${adminPath}/baoxiu_paiban/baoxiuPaiban")
public class BaoxiuPaibanController extends BaseController {

	@Autowired
	private BaoxiuPaibanService baoxiuPaibanService;

	@ModelAttribute
	public BaoxiuPaiban get(@RequestParam(required = false) String id) {
		BaoxiuPaiban entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = baoxiuPaibanService.get(id);
		}
		if (entity == null) {
			entity = new BaoxiuPaiban();
		}
		return entity;
	}

	@RequiresPermissions("baoxiu_paiban:baoxiuPaiban:view")
	@RequestMapping(value = { "list", "" })
	public String list(BaoxiuPaiban baoxiuPaiban, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<BaoxiuPaiban> page = baoxiuPaibanService
				.findPage(new Page<BaoxiuPaiban>(request, response), baoxiuPaiban);
		model.addAttribute("page", page);
		return "modules/baoxiu_paiban/baoxiuPaibanList";
	}

	@RequiresPermissions("baoxiu_paiban:baoxiuPaiban:view")
	@RequestMapping(value = "form")
	public String form(BaoxiuPaiban baoxiuPaiban, Model model) {
		model.addAttribute("weixiuList", baoxiuPaibanService.loadWeixiuyuan());
		model.addAttribute("baoxiuPaiban", baoxiuPaiban);
		return "modules/baoxiu_paiban/baoxiuPaibanForm";
	}

	@RequiresPermissions("baoxiu_paiban:baoxiuPaiban:edit")
	@RequestMapping(value = "save")
	public String save(BaoxiuPaiban baoxiuPaiban, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, baoxiuPaiban)) {
			return form(baoxiuPaiban, model);
		}
		if (baoxiuPaiban.getId().length() == 0) {
			BaoxiuPaiban b = baoxiuPaibanService.getByNianYue(baoxiuPaiban);
			if (b != null) {
				b.setRiStr(baoxiuPaiban.getRiStr());
				baoxiuPaibanService.save(b);
			} else
				baoxiuPaibanService.save(baoxiuPaiban);
		} else
			baoxiuPaibanService.save(baoxiuPaiban);

		addMessage(redirectAttributes, "保存排班成功");
		return "redirect:" + Global.getAdminPath() + "/baoxiu_paiban/baoxiuPaiban/?repage";
	}

	@RequiresPermissions("baoxiu_paiban:baoxiuPaiban:edit")
	@RequestMapping(value = "delete")
	public String delete(BaoxiuPaiban baoxiuPaiban, RedirectAttributes redirectAttributes) {
		baoxiuPaibanService.delete(baoxiuPaiban);
		addMessage(redirectAttributes, "删除排班成功");
		return "redirect:" + Global.getAdminPath() + "/baoxiu_paiban/baoxiuPaiban/?repage";
	}

}