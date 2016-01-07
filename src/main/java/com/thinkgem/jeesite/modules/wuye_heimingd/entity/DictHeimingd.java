/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_heimingd.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;

/**
 * 黑名单Entity
 * @author ktzhxm
 * @version 2015-12-21
 */
public class DictHeimingd extends DataEntity<DictHeimingd> {
	
	private static final long serialVersionUID = 1L;
	private DictRenyuan renyuan;		// 姓名
	
	public DictHeimingd() {
		super();
	}

	public DictHeimingd(String id){
		super(id);
	}

	public DictRenyuan getRenyuan() {
		return renyuan;
	}

	public void setRenyuan(DictRenyuan renyuan) {
		this.renyuan = renyuan;
	}
	
}