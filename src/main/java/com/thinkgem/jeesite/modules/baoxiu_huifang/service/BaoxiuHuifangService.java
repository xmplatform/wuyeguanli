/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_huifang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.baoxiu_huifang.entity.BaoxiuHuifang;
import com.thinkgem.jeesite.modules.baoxiu_huifang.dao.BaoxiuHuifangDao;

/**
 * 客户回访Service
 * @author ktzhxm
 * @version 2016-01-08
 */
@Service
@Transactional(readOnly = true)
public class BaoxiuHuifangService extends CrudService<BaoxiuHuifangDao, BaoxiuHuifang> {

	public BaoxiuHuifang get(String id) {
		return super.get(id);
	}
	
	public List<BaoxiuHuifang> findList(BaoxiuHuifang baoxiuHuifang) {
		return super.findList(baoxiuHuifang);
	}
	
	public Page<BaoxiuHuifang> findPage(Page<BaoxiuHuifang> page, BaoxiuHuifang baoxiuHuifang) {
		return super.findPage(page, baoxiuHuifang);
	}
	
	@Transactional(readOnly = false)
	public void save(BaoxiuHuifang baoxiuHuifang) {
		super.save(baoxiuHuifang);
	}
	
	@Transactional(readOnly = false)
	public void delete(BaoxiuHuifang baoxiuHuifang) {
		super.delete(baoxiuHuifang);
	}
	
}