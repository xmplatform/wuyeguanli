/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyetuzhi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wuyetuzhi.entity.DictLoucengtuzhi;
import com.thinkgem.jeesite.modules.wuyetuzhi.dao.DictLoucengtuzhiDao;

/**
 * 楼层图纸资料Service
 * @author ktzhxm
 * @version 2015-12-09
 */
@Service
@Transactional(readOnly = true)
public class DictLoucengtuzhiService extends CrudService<DictLoucengtuzhiDao, DictLoucengtuzhi> {

	public DictLoucengtuzhi get(String id) {
		return super.get(id);
	}
	
	public List<DictLoucengtuzhi> findList(DictLoucengtuzhi dictLoucengtuzhi) {
		return super.findList(dictLoucengtuzhi);
	}
	
	public Page<DictLoucengtuzhi> findPage(Page<DictLoucengtuzhi> page, DictLoucengtuzhi dictLoucengtuzhi) {
		return super.findPage(page, dictLoucengtuzhi);
	}
	
	@Transactional(readOnly = false)
	public void save(DictLoucengtuzhi dictLoucengtuzhi) {
		super.save(dictLoucengtuzhi);
	}
	
	@Transactional(readOnly = false)
	public void delete(DictLoucengtuzhi dictLoucengtuzhi) {
		super.delete(dictLoucengtuzhi);
	}
	
}