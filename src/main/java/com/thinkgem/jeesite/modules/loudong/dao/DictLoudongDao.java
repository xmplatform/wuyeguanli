/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.loudong.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.loudong.entity.DictLoudong;

/**
 * 楼栋信息管理DAO接口
 * @author ktzhxm
 * @version 2015-12-07
 */
@MyBatisDao
public interface DictLoudongDao extends CrudDao<DictLoudong> {
	
}