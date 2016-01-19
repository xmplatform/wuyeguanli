/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.daishou_wuliu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.daishou_wuliu.entity.DaishouWuliugs;
import com.thinkgem.jeesite.modules.daishou_wuliu.dao.DaishouWuliugsDao;

/**
 * 物流公司Service
 * @author ktzhxm
 * @version 2016-01-19
 */
@Service
@Transactional(readOnly = true)
public class DaishouWuliugsService extends CrudService<DaishouWuliugsDao, DaishouWuliugs> {

	public DaishouWuliugs get(String id) {
		return super.get(id);
	}
	
	public List<DaishouWuliugs> findList(DaishouWuliugs daishouWuliugs) {
		return super.findList(daishouWuliugs);
	}
	
	public Page<DaishouWuliugs> findPage(Page<DaishouWuliugs> page, DaishouWuliugs daishouWuliugs) {
		return super.findPage(page, daishouWuliugs);
	}
	
	@Transactional(readOnly = false)
	public void save(DaishouWuliugs daishouWuliugs) {
		super.save(daishouWuliugs);
	}
	
	@Transactional(readOnly = false)
	public void delete(DaishouWuliugs daishouWuliugs) {
		super.delete(daishouWuliugs);
	}
	
}