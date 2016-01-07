/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyedanyuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wuyedanyuan.entity.WuyeDanyuan;
import com.thinkgem.jeesite.modules.wuyejiben.dao.WuyeJibenDao;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyedanyuan.dao.WuyeDanyuanDao;

/**
 * 单元管理Service
 * @author ktzhxm
 * @version 2015-12-12
 */
@Service
@Transactional(readOnly = true)
public class WuyeDanyuanService extends CrudService<WuyeDanyuanDao, WuyeDanyuan> {

	@Autowired
	private WuyeJibenDao jibenDao;
	
	public WuyeDanyuan get(String id) {
		return super.get(id);
	}
	
	public List<WuyeDanyuan> findList(WuyeDanyuan wuyeDanyuan) {
		return super.findList(wuyeDanyuan);
	}
	
	public Page<WuyeDanyuan> findPage(Page<WuyeDanyuan> page, WuyeDanyuan wuyeDanyuan) {
		return super.findPage(page, wuyeDanyuan);
	}
	
	@Transactional(readOnly = false)
	public void save(WuyeDanyuan wuyeDanyuan) {
		super.save(wuyeDanyuan);
	}
	
	@Transactional(readOnly = false)
	public void delete(WuyeDanyuan wuyeDanyuan) {
		super.delete(wuyeDanyuan);
	}
	@Transactional(readOnly = false)
	public List<WuyeJiben> loadSubById(String id) {
		return jibenDao.loadSubById(id);
	}
	
}