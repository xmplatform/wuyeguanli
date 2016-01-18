/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.renwu_templ.dao;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.renwu_templ.entity.RenwuTempl;

/**
 * 任务计划模板DAO接口
 * @author ktzxm
 * @version 2016-01-15
 */
@MyBatisDao
public interface RenwuTemplDao extends TreeDao<RenwuTempl> {
	
}