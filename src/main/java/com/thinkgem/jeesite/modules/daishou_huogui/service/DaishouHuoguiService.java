/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.daishou_huogui.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.daishou_huogui.entity.DaishouHuogui;
import com.thinkgem.jeesite.modules.daishou_huogui.dao.DaishouHuoguiDao;

/**
 * 货柜信息Service
 * @author ktzhxm
 * @version 2016-01-19
 */
@Service
@Transactional(readOnly = true)
public class DaishouHuoguiService extends CrudService<DaishouHuoguiDao, DaishouHuogui> {

	public DaishouHuogui get(String id) {
		return super.get(id);
	}
	
	public List<DaishouHuogui> findList(DaishouHuogui daishouHuogui) {
		return super.findList(daishouHuogui);
	}
	
	public Page<DaishouHuogui> findPage(Page<DaishouHuogui> page, DaishouHuogui daishouHuogui) {
		return super.findPage(page, daishouHuogui);
	}
	
	@Transactional(readOnly = false)
	public void save(DaishouHuogui daishouHuogui) {
		super.save(daishouHuogui);
	}
	
	@Transactional(readOnly = false)
	public void delete(DaishouHuogui daishouHuogui) {
		super.delete(daishouHuogui);
	}
	
}