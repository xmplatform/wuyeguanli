/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyetaohu.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;
import com.thinkgem.jeesite.modules.wuyetaohu.entity.DictTaohu;

/**
 * 套户信息DAO接口
 * @author ktzhxm
 * @version 2015-12-07
 */
@MyBatisDao
public interface DictTaohuDao extends CrudDao<DictTaohu> {
	/**
	 * 加载树形菜单
	 * @param leixingbs 显示层次
	 * @return
	 */
	public List<WuyeJiben> loadAllData(Integer leixingbs);
	/**
	 * 房屋销售
	 * @param taohuId
	 */
	public void sale(String taohuId);
	/**
	 * 根据电话号查找套户信息
	 * @param dianhua
	 * @return
	 */
	public List<DictTaohu> findTaohuByDianhua(String dianhua);
}