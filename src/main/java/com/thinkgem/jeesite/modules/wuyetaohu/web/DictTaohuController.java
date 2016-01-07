/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyetaohu.web;

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
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;
import com.thinkgem.jeesite.modules.wuyetaohu.entity.DictTaohu;
import com.thinkgem.jeesite.modules.wuyetaohu.service.DictTaohuService;

/**
 * 套户信息Controller
 * 
 * @author ktzhxm
 * @version 2015-12-07
 */
@Controller
@RequestMapping(value = "${adminPath}/wuyetaohu/dictTaohu/")
public class DictTaohuController extends BaseController {

	@Autowired
	private DictTaohuService dictTaohuService;

	@ModelAttribute
	public DictTaohu get(@RequestParam(required = false) String id) {
		DictTaohu entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = dictTaohuService.get(id);
		}
		if (entity == null) {
			entity = new DictTaohu();
		}
		return entity;
	}
	/**
	 * 套户信息查看
	 */
	@RequiresPermissions("wuyetaohu:dictTaohu:view")
	@RequestMapping(value = "index")
	public String index() {
		return "modules/wuyetaohu/taohuIndex";
	}
	
	@RequiresPermissions("wuyetaohu:dictTaohu:view")
	@RequestMapping(value = { "list", "" })
	public String list(DictTaohu dictTaohu, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DictTaohu> page = dictTaohuService.findPage(new Page<DictTaohu>(request, response), dictTaohu);
		model.addAttribute("pids",request.getParameter("pids"));
		model.addAttribute("page", page);
		return "modules/wuyetaohu/dictTaohuList";
	}

	@RequiresPermissions("wuyetaohu:dictTaohu:view")
	@RequestMapping(value = "form")
	public String form(DictTaohu dictTaohu, Model model, HttpServletRequest request) {
		model.addAttribute("dictTaohu", dictTaohu);
		return "modules/wuyetaohu/dictTaohuForm";
	}

	@RequiresPermissions("wuyetaohu:dictTaohu:edit")
	@RequestMapping(value = "save")
	public String save(DictTaohu dictTaohu, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictTaohu)) {
			return form(dictTaohu, model,null);
		}
		int chanshengsl = dictTaohu.getChanshengsl();
		int qishibh = Integer.parseInt(dictTaohu.getMenpai());
		int buchang = dictTaohu.getBuchang();
		for (int i = qishibh; i < qishibh + buchang * chanshengsl; i += buchang) {
			DictTaohu taohu = (DictTaohu) dictTaohu.clone();
			if(chanshengsl!=1)
				taohu.setMenpai(i + "");
			taohu.setPid(taohu.getPids().split(",")[3]);
			dictTaohuService.save(taohu);
		}
		addMessage(redirectAttributes, "保存套户成功");
		return "redirect:" + Global.getAdminPath() + "/wuyetaohu/dictTaohu/?repage";
	}

	@RequiresPermissions("wuyetaohu:dictTaohu:edit")
	@RequestMapping(value = "delete")
	public String delete(DictTaohu dictTaohu, RedirectAttributes redirectAttributes) {
		String[] idArr=dictTaohu.getId().split(",");
		for(int i=0;i<idArr.length;i++){
			DictTaohu t=(DictTaohu) dictTaohu.clone();
			t.setId(idArr[i]);
			dictTaohuService.delete(t);
		}
		addMessage(redirectAttributes, "删除套户成功");
		return "redirect:" + Global.getAdminPath() + "/wuyetaohu/dictTaohu/?repage";
	}
	/**
	 * 转到房屋销售页面
	 */
	@RequiresPermissions("wuyetaohu:dictTaohu:sale")
	@RequestMapping(value = "turnToSale")
	public String turnToSale(DictRenyuan dictRenyuan,DictTaohu taohu, Model model) {
		model.addAttribute("dictTaohu", taohu);
		dictRenyuan.setPid(taohu.getId());
		dictRenyuan.setPids(taohu.getPids()+","+taohu.getId());
		model.addAttribute("dictRenyuan", dictRenyuan);
		return "modules/wuyetaohu/saleIndex";
	}
/**
 *房屋销售
 */
	@RequiresPermissions("wuyetaohu:dictTaohu:sale")
	@RequestMapping(value = "sale")
	public String sale(DictRenyuan renyuan, Model model, RedirectAttributes redirectAttributes) {
		renyuan.setRenyuanlx("1");//默认户主
		dictTaohuService.sale(renyuan.getPid(), renyuan);
		
		addMessage(redirectAttributes, "套户销售成功");
		return "redirect:" + Global.getAdminPath() + "/wuyetaohu/dictTaohu/?repage";
	}
	/**
	 *人员迁出
	 */
		@RequiresPermissions("wuyetaohu:dictTaohu:move")
		@RequestMapping(value = "moveOut")
		public String moveOut(DictRenyuan renyuan, Model model, RedirectAttributes redirectAttributes) {
			String pid=renyuan.getPid();
			dictTaohuService.moveOut(renyuan);
			
			addMessage(redirectAttributes, "人员迁出成功");
			return "redirect:" + Global.getAdminPath() + "/wuyerenyuan/dictRenyuan/searchByTaohuId?pid="+pid;
		}
	/**
	 * 显示物业--套户的树形菜单
	 */
	@ResponseBody
	@RequestMapping(value = "taohuTree")
	public List<Map<String, Object>> taohuTree(RedirectAttributes redirectAttributes,HttpServletRequest request) {
		List<WuyeJiben> list = dictTaohuService.loadAllData(5);
		List<Map<String, Object>> mapList = Lists.newArrayList();
		for (WuyeJiben wuye : list) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", wuye.getId());
			map.put("pId", wuye.getDizhi());
			map.put("pIds", wuye.getDianhua());
			map.put("name", wuye.getMingcheng());
			String imgPath = request.getContextPath()+"/static/jquery-ztree/3.5.12/css/zTreeStyle/img/diy/";
			switch (Integer.parseInt(wuye.getRenshu())) {
			case 0:
				map.put("col", "wuye");
				map.put("isParent", true);
				break;
			case 1:
				map.put("col", "xiaoqu");
				map.put("isParent", true);
				break;
			case 2:
				map.put("col", "loudong");
				map.put("isParent", true);
				break;
			case 3:
				map.put("col", "danyuan");
				map.put("isParent", true);
				break;
			case 4:
				map.put("isParent", false);
				map.put("icon", imgPath + "house.png");
			}
			mapList.add(map);
		}
		return mapList;
	}
	//根据手机号查找套户姓名
	@ResponseBody
	@RequestMapping(value = "findTaohuByShouji")
	public List<Map<String, Object>> findTaohuByShouji(HttpServletRequest req,HttpServletResponse res) {
		res.setContentType("text/html;charset=GB2312");
		String dianhua=req.getParameter("dianhua");
		DictTaohu taohu=dictTaohuService.findTaohuByDianhua(dianhua);
		
		List<Map<String, Object>> mapList = Lists.newArrayList();
		if(taohu!=null){
			Map<String, Object> map = Maps.newHashMap();
			map.put("weizhi", taohu.getWeizhi()+taohu.getMenpai()+taohu.getHuzhu().getXingming());
			mapList.add(map);
		}
		return mapList;
	}
}
