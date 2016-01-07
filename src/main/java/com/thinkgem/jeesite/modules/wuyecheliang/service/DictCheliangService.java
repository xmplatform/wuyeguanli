/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyecheliang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wuyecheliang.entity.DictCheliang;
import com.thinkgem.jeesite.modules.wuyechewei.service.DictCheweiService;
import com.thinkgem.jeesite.modules.wuyecheliang.dao.DictCheliangDao;

/**
 * 车辆信息Service
 * @author ktzhxm
 * @version 2015-12-10
 */
@Service
@Transactional(readOnly = true)
public class DictCheliangService extends CrudService<DictCheliangDao, DictCheliang> {

	@Autowired
	private DictCheweiService cheweiService;
	public DictCheliang get(String id) {
		return super.get(id);
	}
	
	public List<DictCheliang> findList(DictCheliang dictCheliang) {
		return super.findList(dictCheliang);
	}
	
	public Page<DictCheliang> findPage(Page<DictCheliang> page, DictCheliang dictCheliang) {
		return super.findPage(page, dictCheliang);
	}
	
	@Transactional(readOnly = false)
	public void save(DictCheliang dictCheliang) {
		super.save(dictCheliang);
	}
	
	@Transactional(readOnly = false)
	public void delete(DictCheliang dictCheliang) {
		super.delete(dictCheliang);
		//释放车位
		cheweiService.shifang(dictCheliang.getChewei().getId());
	}
	
}