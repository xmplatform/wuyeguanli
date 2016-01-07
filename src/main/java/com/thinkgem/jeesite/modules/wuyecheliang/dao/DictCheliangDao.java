/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyecheliang.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wuyecheliang.entity.DictCheliang;

/**
 * 车辆信息DAO接口
 * @author ktzhxm
 * @version 2015-12-10
 */
@MyBatisDao
public interface DictCheliangDao extends CrudDao<DictCheliang> {
	
}