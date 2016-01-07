/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyechewei.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wuyechewei.entity.DictChewei;

/**
 * 车位信息DAO接口
 * @author ktzhxm
 * @version 2015-12-10
 */
@MyBatisDao
public interface DictCheweiDao extends CrudDao<DictChewei> {
	void chuzu(DictChewei dictChewei);

	void chushou(DictChewei dictChewei);

	void shifang(String cheweiId);
	
}