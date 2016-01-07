/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyexiaoqu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wuyexiaoqu.entity.WuyeXiaoqu;
import com.thinkgem.jeesite.modules.wuyejiben.dao.WuyeJibenDao;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyexiaoqu.dao.WuyeXiaoquDao;

/**
 * 小区信息Service
 * @author ktzhxm
 * @version 2015-12-06
 */
@Service
@Transactional(readOnly = true)
public class WuyeXiaoquService extends CrudService<WuyeXiaoquDao, WuyeXiaoqu> {

	@Autowired
	private WuyeJibenDao jibenDao;
	@Autowired
	private WuyeXiaoquDao xiaoquDao;
	public WuyeXiaoqu get(String id) {
		return super.get(id);
	}
	public List<WuyeJiben> findAllWuye(WuyeJiben jiben){
		return jibenDao.findAllList(jiben);
	}
	//找到一个物业下的所有小区
	public List<WuyeXiaoqu> findListByPid(String pid){
		return xiaoquDao.findListByPid(pid);
	}
	public List<WuyeXiaoqu> findList(WuyeXiaoqu wuyeXiaoqu) {
		return super.findList(wuyeXiaoqu);
	}
	
	public Page<WuyeXiaoqu> findPage(Page<WuyeXiaoqu> page, WuyeXiaoqu wuyeXiaoqu) {
		return super.findPage(page, wuyeXiaoqu);
	}
	
	@Transactional(readOnly = false)
	public void save(WuyeXiaoqu wuyeXiaoqu) {
		super.save(wuyeXiaoqu);
	}
	
	@Transactional(readOnly = false)
	public void delete(WuyeXiaoqu wuyeXiaoqu) {
		super.delete(wuyeXiaoqu);
	}
	@Transactional(readOnly = false)
	public List<WuyeJiben> loadSubById(String id) {
		return jibenDao.loadSubById(id);
	}
	
}