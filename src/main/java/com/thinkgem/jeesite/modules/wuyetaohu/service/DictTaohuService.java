/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyetaohu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;
import com.thinkgem.jeesite.modules.wuyerenyuan.service.DictRenyuanService;
import com.thinkgem.jeesite.modules.wuyetaohu.dao.DictTaohuDao;
import com.thinkgem.jeesite.modules.wuyetaohu.entity.DictTaohu;

/**
 * 套户信息Service
 * @author ktzhxm
 * @version 2015-12-07
 */
@Service
@Transactional(readOnly = true)
public class DictTaohuService extends CrudService<DictTaohuDao, DictTaohu> {

	@Autowired
	private DictTaohuDao taohuDao;
	@Autowired
	private DictRenyuanService renyuanService;
	
	public DictTaohu get(String id) {
		return super.get(id);
	}
	
	public List<DictTaohu> findList(DictTaohu dictTaohu) {
		return super.findList(dictTaohu);
	}
	
	public Page<DictTaohu> findPage(Page<DictTaohu> page, DictTaohu dictTaohu) {
		return super.findPage(page, dictTaohu);
	}
	
	@Transactional(readOnly = false)
	public void save(DictTaohu dictTaohu) {
		super.save(dictTaohu);
	}
	@Transactional(readOnly = false)
	public void sale(String taohuId,DictRenyuan renyuan) {
		taohuDao.sale(taohuId);
		renyuanService.save(renyuan);
	}
	
	@Transactional(readOnly = false)
	public void delete(DictTaohu dictTaohu) {
		super.delete(dictTaohu);
	}
	public List<WuyeJiben> loadAllData(Integer leixingbs) {
		return taohuDao.loadAllData(leixingbs);
	}
	@Transactional(readOnly = false)
	public void moveOut(DictRenyuan renyuan) {
		renyuanService.moveOut(renyuan.getId());
	}

	public DictTaohu findTaohuByDianhua(String dianhua) {
		List<DictTaohu> list=taohuDao.findTaohuByDianhua(dianhua);
		if(list.size()>0)
			return list.get(0);
		return null;
	}

}