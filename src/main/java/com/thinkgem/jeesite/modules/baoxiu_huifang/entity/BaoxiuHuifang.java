/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_huifang.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 客户回访Entity
 * @author ktzhxm
 * @version 2016-01-08
 */
public class BaoxiuHuifang extends DataEntity<BaoxiuHuifang> {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 回访简述
	private String xinxiId;
	
	public BaoxiuHuifang() {
		super();
	}

	public BaoxiuHuifang(String id){
		super(id);
	}

	@Length(min=0, max=255, message="回访简述长度必须介于 0 和 255 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getXinxiId() {
		return xinxiId;
	}

	public void setXinxiId(String xinxiId) {
		this.xinxiId = xinxiId;
	}
	
}