/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyetuzhi.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 楼层图纸资料Entity
 * @author ktzhxm
 * @version 2015-12-09
 */
public class DictLoucengtuzhi extends DataEntity<DictLoucengtuzhi> {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 名称
	private String leixing;		// 类型
	private String tuzhi;		// 图纸
	
	public DictLoucengtuzhi() {
		super();
	}

	public DictLoucengtuzhi(String id){
		super(id);
	}

	@Length(min=0, max=60, message="名称长度必须介于 0 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	@Length(min=0, max=3, message="类型长度必须介于 0 和 3 之间")
	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	@Length(min=0, max=255, message="图纸长度必须介于 0 和 255 之间")
	public String getTuzhi() {
		return tuzhi;
	}

	public void setTuzhi(String tuzhi) {
		this.tuzhi = tuzhi;
	}
	
}