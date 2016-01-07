/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyejiben.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wuyejiben.dao.WuyeJibenDao;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;

/**
 * 物业基本信息Service
 * @author lixm
 * @version 2015-12-05
 */
@Service
@Transactional(readOnly = true)
public class WuyeJibenService extends CrudService<WuyeJibenDao, WuyeJiben> {

	@Autowired
	private WuyeJibenDao jibenDao;
	
	public WuyeJiben get(String id) {
		return super.get(id);
	}
	
	public List<WuyeJiben> findList(WuyeJiben wuyeJiben) {
		return super.findList(wuyeJiben);
	}
	
	public Page<WuyeJiben> findPage(Page<WuyeJiben> page, WuyeJiben wuyeJiben) {
		return super.findPage(page, wuyeJiben);
	}
	
	@Transactional(readOnly = false)
	public void save(WuyeJiben wuyeJiben) {
		super.save(wuyeJiben);
	}
	
	@Transactional(readOnly = false)
	public void delete(WuyeJiben wuyeJiben) {
		super.delete(wuyeJiben);
	}

	@Transactional(readOnly = false)
	public List<WuyeJiben> loadSubById(String id) {
		return jibenDao.loadSubById(id);
	}
	
}