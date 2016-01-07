/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyexiaoqu.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wuyexiaoqu.entity.WuyeXiaoqu;

/**
 * 小区信息DAO接口
 * @author ktzhxm
 * @version 2015-12-06
 */
@MyBatisDao
public interface WuyeXiaoquDao extends CrudDao<WuyeXiaoqu> {
	public List<WuyeXiaoqu> findListByPid(String pid);
}