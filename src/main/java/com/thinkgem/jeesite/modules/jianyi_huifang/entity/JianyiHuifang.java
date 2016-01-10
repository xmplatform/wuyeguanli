/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.jianyi_huifang.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 建议回访Entity
 * @author ktzhxm
 * @version 2016-01-10
 */
public class JianyiHuifang extends DataEntity<JianyiHuifang> {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 回访简述
	private String xinxiid;		// 信息id
	
	public JianyiHuifang() {
		super();
	}

	public JianyiHuifang(String id){
		super(id);
	}

	@Length(min=0, max=255, message="回访简述长度必须介于 0 和 255 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	@Length(min=0, max=64, message="信息id长度必须介于 0 和 64 之间")
	public String getXinxiid() {
		return xinxiid;
	}

	public void setXinxiid(String xinxiid) {
		this.xinxiid = xinxiid;
	}
	
}