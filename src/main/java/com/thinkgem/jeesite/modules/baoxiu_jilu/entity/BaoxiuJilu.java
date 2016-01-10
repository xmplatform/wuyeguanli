/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_jilu.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.baoxiu_xinxi.entity.BaoxiuXinxi;

/**
 * 维修记录Entity
 * @author ktzhxm
 * @version 2016-01-08
 */
public class BaoxiuJilu extends DataEntity<BaoxiuJilu> {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 报修情况
	private BaoxiuXinxi xinxi;		// xinxiid
	
	public BaoxiuJilu() {
		super();
	}

	public BaoxiuJilu(String id){
		super(id);
	}

	@Length(min=0, max=60, message="报修情况长度必须介于 0 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public BaoxiuXinxi getXinxi() {
		return xinxi;
	}

	public void setXinxi(BaoxiuXinxi xinxi) {
		this.xinxi = xinxi;
	}
}