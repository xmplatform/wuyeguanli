/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_paiban.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.baoxiu_paiban.entity.BaoxiuPaiban;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 维修员排班DAO接口
 * @author ktzhxm
 * @version 2016-01-05
 */
@MyBatisDao
public interface BaoxiuPaibanDao extends CrudDao<BaoxiuPaiban> {
	/**
	 * 加载所有维修人员
	 * @return
	 */
	public List<User> loadWeixiuList();
	/**
	 * 查找某维修员某月的记录
	 * @param u
	 * @return
	 */
	public BaoxiuPaiban getByNianYue(BaoxiuPaiban u);
}