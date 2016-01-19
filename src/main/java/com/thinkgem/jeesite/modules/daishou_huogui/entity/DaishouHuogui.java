/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.daishou_huogui.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 货柜信息Entity
 * @author ktzhxm
 * @version 2016-01-19
 */
public class DaishouHuogui extends DataEntity<DaishouHuogui> {
	
	private static final long serialVersionUID = 1L;
	private String haoma;		// 货柜号码
	private String mingcheng;		// 货柜名称
	private String weizhi;		// 货柜位置
	private Integer zhuangtai;		// 货柜状态
	
	public DaishouHuogui() {
		super();
	}

	public DaishouHuogui(String id){
		super(id);
	}

	@Length(min=0, max=15, message="货柜号码长度必须介于 0 和 15 之间")
	public String getHaoma() {
		return haoma;
	}

	public void setHaoma(String haoma) {
		this.haoma = haoma;
	}
	
	@Length(min=0, max=60, message="货柜名称长度必须介于 0 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	@Length(min=0, max=100, message="货柜位置长度必须介于 0 和 100 之间")
	public String getWeizhi() {
		return weizhi;
	}

	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}
	
	public Integer getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(Integer zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
}