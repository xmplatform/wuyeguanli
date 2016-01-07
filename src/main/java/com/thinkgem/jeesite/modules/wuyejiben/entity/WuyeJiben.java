/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyejiben.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 物业基本信息Entity
 * @author lixm
 * @version 2015-12-05
 */
public class WuyeJiben extends DataEntity<WuyeJiben> {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 名称
	private String renshu="0";		// 人员数
	private String dizhi;		// 地址
	private String dianhua;		// 电话
	private String fuzeren;		// 负责人
	private String youbian;		// 邮编
	
	public WuyeJiben() {
		super();
	}

	public WuyeJiben(String id){
		super(id);
	}

	@Length(min=1, max=60, message="名称长度必须介于 1 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	@Length(min=0, max=11, message="人员数长度必须介于 0 和 11 之间")
	public String getRenshu() {
		return renshu;
	}

	public void setRenshu(String renshu) {
		this.renshu = renshu;
	}
	
	@Length(min=0, max=120, message="地址长度必须介于 0 和 120 之间")
	public String getDizhi() {
		return dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
	@Length(min=1, max=30, message="电话长度必须介于 1 和 30 之间")
	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	
	@Length(min=0, max=12, message="负责人长度必须介于 0 和 12 之间")
	public String getFuzeren() {
		return fuzeren;
	}

	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	
	@Length(min=0, max=6, message="邮编长度必须介于 0 和 6 之间")
	public String getYoubian() {
		return youbian;
	}

	public void setYoubian(String youbian) {
		this.youbian = youbian;
	}
	
}