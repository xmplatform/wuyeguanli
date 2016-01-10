/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.jianyi_huifang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.jianyi_huifang.entity.JianyiHuifang;
import com.thinkgem.jeesite.modules.jianyi_huifang.dao.JianyiHuifangDao;

/**
 * 建议回访Service
 * @author ktzhxm
 * @version 2016-01-10
 */
@Service
@Transactional(readOnly = true)
public class JianyiHuifangService extends CrudService<JianyiHuifangDao, JianyiHuifang> {

	public JianyiHuifang get(String id) {
		return super.get(id);
	}
	
	public List<JianyiHuifang> findList(JianyiHuifang jianyiHuifang) {
		return super.findList(jianyiHuifang);
	}
	
	public Page<JianyiHuifang> findPage(Page<JianyiHuifang> page, JianyiHuifang jianyiHuifang) {
		return super.findPage(page, jianyiHuifang);
	}
	
	@Transactional(readOnly = false)
	public void save(JianyiHuifang jianyiHuifang) {
		super.save(jianyiHuifang);
	}
	
	@Transactional(readOnly = false)
	public void delete(JianyiHuifang jianyiHuifang) {
		super.delete(jianyiHuifang);
	}
	
}