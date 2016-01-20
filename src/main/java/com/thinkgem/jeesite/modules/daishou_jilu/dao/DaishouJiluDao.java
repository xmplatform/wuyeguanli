/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.daishou_jilu.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.daishou_jilu.entity.DaishouJilu;

/**
 * 代收付业务表DAO接口
 * @author ktzhxm
 * @version 2016-01-20
 */
@MyBatisDao
public interface DaishouJiluDao extends CrudDao<DaishouJilu> {
	
}