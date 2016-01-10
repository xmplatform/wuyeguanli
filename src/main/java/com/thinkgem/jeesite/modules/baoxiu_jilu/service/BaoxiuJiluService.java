/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_jilu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.baoxiu_jilu.entity.BaoxiuJilu;
import com.thinkgem.jeesite.modules.baoxiu_jilu.dao.BaoxiuJiluDao;

/**
 * 维修记录Service
 * @author ktzhxm
 * @version 2016-01-08
 */
@Service
@Transactional(readOnly = true)
public class BaoxiuJiluService extends CrudService<BaoxiuJiluDao, BaoxiuJilu> {

	public BaoxiuJilu get(String id) {
		return super.get(id);
	}
	
	public List<BaoxiuJilu> findList(BaoxiuJilu baoxiuJilu) {
		return super.findList(baoxiuJilu);
	}
	
	public Page<BaoxiuJilu> findPage(Page<BaoxiuJilu> page, BaoxiuJilu baoxiuJilu) {
		return super.findPage(page, baoxiuJilu);
	}
	
	@Transactional(readOnly = false)
	public void save(BaoxiuJilu baoxiuJilu) {
		super.save(baoxiuJilu);
	}
	
	@Transactional(readOnly = false)
	public void delete(BaoxiuJilu baoxiuJilu) {
		super.delete(baoxiuJilu);
	}
	
}