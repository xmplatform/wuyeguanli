/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyedanyuan.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wuyedanyuan.entity.WuyeDanyuan;

/**
 * 单元管理DAO接口
 * @author ktzhxm
 * @version 2015-12-12
 */
@MyBatisDao
public interface WuyeDanyuanDao extends CrudDao<WuyeDanyuan> {
	
}