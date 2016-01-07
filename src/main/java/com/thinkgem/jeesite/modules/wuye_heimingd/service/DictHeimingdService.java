/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_heimingd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wuye_heimingd.dao.DictHeimingdDao;
import com.thinkgem.jeesite.modules.wuye_heimingd.entity.DictHeimingd;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;
import com.thinkgem.jeesite.modules.wuyerenyuan.service.DictRenyuanService;

/**
 * 黑名单Service
 * @author ktzhxm
 * @version 2015-12-21
 */
@Service
@Transactional(readOnly = true)
public class DictHeimingdService extends CrudService<DictHeimingdDao, DictHeimingd> {

	@Autowired
	private DictRenyuanService renyuanService; 
	
	public DictHeimingd get(String id) {
		return super.get(id);
	}
	
	public List<DictHeimingd> findList(DictHeimingd dictHeimingd) {
		return super.findList(dictHeimingd);
	}
	
	public Page<DictHeimingd> findPage(Page<DictHeimingd> page, DictHeimingd dictHeimingd) {
		return super.findPage(page, dictHeimingd);
	}
	
	@Transactional(readOnly = false)
	public void save(DictHeimingd dictHeimingd) {
		renyuanService.addHeimingd(dictHeimingd.getRenyuan().getId());
		super.save(dictHeimingd);
	}
	
	@Transactional(readOnly = false)
	public void delete(DictHeimingd dictHeimingd) {
		renyuanService.delHeimingd(dictHeimingd.getRenyuan().getId());
		super.delete(dictHeimingd);
	}
	/**
	 * 用于人员选择下拉框
	 * @return
	 */
	public List<DictRenyuan> findRenyuanList() {
		DictRenyuan ren=new DictRenyuan();
		ren.setDelFlag("0");
		ren.setHeimingd("0");//不是黑名单的
		List<DictRenyuan> list =renyuanService.findList(ren) ;
		for(DictRenyuan r:list){
			r.setXingming(r.getPath()+"-"+r.getXingming());
		}
		return list;
	}
	
}