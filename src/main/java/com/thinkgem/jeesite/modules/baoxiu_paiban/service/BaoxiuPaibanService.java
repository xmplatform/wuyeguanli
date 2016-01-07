/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_paiban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.baoxiu_paiban.entity.BaoxiuPaiban;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.baoxiu_paiban.dao.BaoxiuPaibanDao;

/**
 * 维修员排班Service
 * @author ktzhxm
 * @version 2016-01-05
 */
@Service
@Transactional(readOnly = true)
public class BaoxiuPaibanService extends CrudService<BaoxiuPaibanDao, BaoxiuPaiban> {

	@Autowired
	private BaoxiuPaibanDao paibanDao;
	public BaoxiuPaiban get(String id) {
		return super.get(id);
	}
	
	public List<BaoxiuPaiban> findList(BaoxiuPaiban baoxiuPaiban) {
		return super.findList(baoxiuPaiban);
	}
	
	public Page<BaoxiuPaiban> findPage(Page<BaoxiuPaiban> page, BaoxiuPaiban baoxiuPaiban) {
		return super.findPage(page, baoxiuPaiban);
	}
	
	@Transactional(readOnly = false)
	public void save(BaoxiuPaiban baoxiuPaiban) {
		super.save(baoxiuPaiban);
	}
	
	@Transactional(readOnly = false)
	public void delete(BaoxiuPaiban baoxiuPaiban) {
		super.delete(baoxiuPaiban);
	}
	public List<User> loadWeixiuyuan() {
		return paibanDao.loadWeixiuList();
	}

	public BaoxiuPaiban getByNianYue(BaoxiuPaiban baoxiuPaiban) {
		return paibanDao.getByNianYue(baoxiuPaiban);
	}
}