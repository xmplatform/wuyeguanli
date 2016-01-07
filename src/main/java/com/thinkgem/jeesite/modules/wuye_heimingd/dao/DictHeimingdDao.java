/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_heimingd.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wuye_heimingd.entity.DictHeimingd;

/**
 * 黑名单DAO接口
 * @author ktzhxm
 * @version 2015-12-21
 */
@MyBatisDao
public interface DictHeimingdDao extends CrudDao<DictHeimingd> {
	
}