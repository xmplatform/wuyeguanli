/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_xinxi.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.baoxiu_xinxi.entity.BaoxiuXinxi;

/**
 * 报修信息主表DAO接口
 * @author ktzhxm
 * @version 2016-01-02
 */
@MyBatisDao
public interface BaoxiuXinxiDao extends CrudDao<BaoxiuXinxi> {
}