/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_templ.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.TreeService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.renwu_templ.entity.RenwuTempl;
import com.thinkgem.jeesite.modules.renwu_templ.dao.RenwuTemplDao;

/**
 * 任务计划模板Service
 * @author ktzxm
 * @version 2016-01-15
 */
@Service
@Transactional(readOnly = true)
public class RenwuTemplService extends TreeService<RenwuTemplDao, RenwuTempl> {

	public RenwuTempl get(String id) {
		return super.get(id);
	}
	
	public List<RenwuTempl> findList(RenwuTempl renwuTempl) {
		if (StringUtils.isNotBlank(renwuTempl.getParentIds())){
			renwuTempl.setParentIds(","+renwuTempl.getParentIds()+",");
		}
		dataScopeFilter(renwuTempl, "dsf", "id=o.id", "id=a.create_by");
		return super.findList(renwuTempl);
	}
	
	@Transactional(readOnly = false)
	public void save(RenwuTempl renwuTempl) {
		super.save(renwuTempl);
	}
	
	@Transactional(readOnly = false)
	public void delete(RenwuTempl renwuTempl) {
		super.delete(renwuTempl);
	}
	
}