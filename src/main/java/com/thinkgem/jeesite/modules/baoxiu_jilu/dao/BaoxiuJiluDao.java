/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_jilu.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.baoxiu_jilu.entity.BaoxiuJilu;

/**
 * 维修记录DAO接口
 * @author ktzhxm
 * @version 2016-01-08
 */
@MyBatisDao
public interface BaoxiuJiluDao extends CrudDao<BaoxiuJilu> {
	
}