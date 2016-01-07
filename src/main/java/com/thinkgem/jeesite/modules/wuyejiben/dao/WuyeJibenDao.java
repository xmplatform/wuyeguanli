/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyejiben.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;

/**
 * 物业基本信息DAO接口
 * @author lixm
 * @version 2015-12-05
 */
@MyBatisDao
public interface WuyeJibenDao extends CrudDao<WuyeJiben> {
	/**
	 * 公司-小区-楼栋-单元-套户，是否有下一级
	 */
	public List<WuyeJiben> loadSubById(String id); 
}