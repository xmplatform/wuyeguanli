/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.loudong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.loudong.dao.DictLoudongDao;
import com.thinkgem.jeesite.modules.loudong.entity.DictLoudong;
import com.thinkgem.jeesite.modules.wuyejiben.dao.WuyeJibenDao;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;

/**
 * 楼栋信息管理Service
 * @author ktzhxm
 * @version 2015-12-07
 */
@Service
@Transactional(readOnly = true)
public class DictLoudongService extends CrudService<DictLoudongDao, DictLoudong> {

	@Autowired
	private WuyeJibenDao dao;
	public DictLoudong get(String id) {
		return super.get(id);
	}
	public List<WuyeJiben> findAllXiaoqu(WuyeJiben wuye){
		return dao.findAllList(wuye);
	}
	public List<DictLoudong> findList(DictLoudong dictLoudong) {
		return super.findList(dictLoudong);
	}
	
	public Page<DictLoudong> findPage(Page<DictLoudong> page, DictLoudong dictLoudong) {
		return super.findPage(page, dictLoudong);
	}
	
	@Transactional(readOnly = false)
	public void save(DictLoudong dictLoudong) {
		super.save(dictLoudong);
	}
	
	@Transactional(readOnly = false)
	public void delete(DictLoudong dictLoudong) {
		super.delete(dictLoudong);
	}
	@Transactional(readOnly = false)
	public List<WuyeJiben> loadSubById(String id) {
		return dao.loadSubById(id);
	}
	
}