/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.jianyi_xinxi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.jianyi_xinxi.entity.JianyiXinxi;
import com.thinkgem.jeesite.modules.jianyi_xinxi.dao.JianyiXinxiDao;

/**
 * 建议主表Service
 * @author ktzhxm
 * @version 2016-01-10
 */
@Service
@Transactional(readOnly = true)
public class JianyiXinxiService extends CrudService<JianyiXinxiDao, JianyiXinxi> {

	public JianyiXinxi get(String id) {
		return super.get(id);
	}
	
	public List<JianyiXinxi> findList(JianyiXinxi jianyiXinxi) {
		return super.findList(jianyiXinxi);
	}
	
	public Page<JianyiXinxi> findPage(Page<JianyiXinxi> page, JianyiXinxi jianyiXinxi) {
		return super.findPage(page, jianyiXinxi);
	}
	
	@Transactional(readOnly = false)
	public void save(JianyiXinxi jianyiXinxi) {
		super.save(jianyiXinxi);
	}
	
	@Transactional(readOnly = false)
	public void delete(JianyiXinxi jianyiXinxi) {
		super.delete(jianyiXinxi);
	}
	
}