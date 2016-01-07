/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_paiban.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 维修员排班Entity
 * @author ktzhxm
 * @version 2016-01-05
 */
public class BaoxiuPaiban extends DataEntity<BaoxiuPaiban> {
	
	private static final long serialVersionUID = 1L;
	private User renyuanid;		// 名称
	private String zhibansj;		// 值班年月
	private String riStr;	//值班具体日期
	
	public BaoxiuPaiban() {
		super();
	}

	public BaoxiuPaiban(String id){
		super(id);
	}

	public User getRenyuanid() {
		return renyuanid;
	}

	public void setRenyuanid(User renyuanid) {
		this.renyuanid = renyuanid;
	}
	
	public String getZhibansj() {
		return zhibansj;
	}

	public void setZhibansj(String zhibansj) {
		this.zhibansj = zhibansj;
	}

	public String getRiStr() {
		return riStr;
	}

	public void setRiStr(String riStr) {
		this.riStr = riStr;
	}
}