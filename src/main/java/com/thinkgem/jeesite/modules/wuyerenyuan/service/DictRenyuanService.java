/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyerenyuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wuyerenyuan.dao.DictRenyuanDao;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;

/**
 * 住户人员信息Service
 * @author ktzhxm
 * @version 2015-12-14
 */
@Service
@Transactional(readOnly = true)
public class DictRenyuanService extends CrudService<DictRenyuanDao, DictRenyuan> {
	@Autowired
	private DictRenyuanDao renyuanDao;
	
	public DictRenyuan get(String id) {
		return super.get(id);
	}
	
	public List<DictRenyuan> findList(DictRenyuan dictRenyuan) {
		return super.findList(dictRenyuan);
	}
	
	public Page<DictRenyuan> findPage(Page<DictRenyuan> page, DictRenyuan dictRenyuan) {
		return super.findPage(page, dictRenyuan);
	}
	
	@Transactional(readOnly = false)
	public void save(DictRenyuan dictRenyuan) {
		super.save(dictRenyuan);
	}
	
	@Transactional(readOnly = false)
	public void delete(DictRenyuan dictRenyuan) {
		super.delete(dictRenyuan);
	}
	@Transactional(readOnly = false)
	public void moveOut(String renyuanId) {
		renyuanDao.moveOut(renyuanId);
	}
	@Transactional(readOnly = false)
	public void addHeimingd(String renyuanId) {
		renyuanDao.addHeimingd(renyuanId);
	}
	@Transactional(readOnly = false)
	public void delHeimingd(String renyuanId) {
		renyuanDao.delHeimingd(renyuanId);
	}

	public DictRenyuan getRenyuanByNum(String num) {
		return renyuanDao.getRenyuanByNum(num);
	}
	
}