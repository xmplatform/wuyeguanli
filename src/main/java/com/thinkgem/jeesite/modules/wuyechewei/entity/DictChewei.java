/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyechewei.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;

/**
 * 车位信息Entity
 * @author ktzhxm
 * @version 2015-12-10
 */
public class DictChewei extends DataEntity<DictChewei> {
	
	private static final long serialVersionUID = 1L;
	private String cheweikh;		// 车位卡号
	private String mingcheng;		// 车位名称
	private String weizhi;		// 车位位置
	private String jiazhi="0.0";		// 车位价值
	private Double chuzujg=0.0;		// 出租价格
	private String suoshuquyu;		// 所属区域
	private String zhuangtai;		// 车位状态：0空闲；1出售；2出租
	private String shifousy;	//是否使用中，1使用中或出租出售
	private DictRenyuan renyuan;	//人员
	private String renyuanLeixing="1";	//业主还是陌生人
	private Date kaishisj;
	private Date jieshusj;
	private Double xiaoshoujg=0.0;
	private Date xiaoshousj;
	
	public DictChewei() {
		super();
	}

	public DictChewei(String id){
		super(id);
	}

	@Length(min=0, max=64, message="车位卡号长度必须介于 0 和 64 之间")
	public String getCheweikh() {
		return cheweikh;
	}

	public void setCheweikh(String cheweikh) {
		this.cheweikh = cheweikh;
	}
	
	@Length(min=1, max=60, message="车位名称长度必须介于 1 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	@Length(min=0, max=60, message="车位位置长度必须介于 0 和 60 之间")
	public String getWeizhi() {
		return weizhi;
	}

	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}
	
	public String getJiazhi() {
		return jiazhi;
	}

	public void setJiazhi(String jiazhi) {
		this.jiazhi = jiazhi;
	}
	
	public Double getChuzujg() {
		return chuzujg;
	}

	public void setChuzujg(Double chuzujg) {
		this.chuzujg = chuzujg;
	}
	
	@Length(min=0, max=64, message="所属区域长度必须介于 0 和 64 之间")
	public String getSuoshuquyu() {
		return suoshuquyu;
	}

	public void setSuoshuquyu(String suoshuquyu) {
		this.suoshuquyu = suoshuquyu;
	}
	
	@Length(min=0, max=10, message="车位状态长度必须介于 0 和 10 之间")
	public String getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

	public DictRenyuan getRenyuan() {
		return renyuan;
	}

	public void setRenyuan(DictRenyuan renyuan) {
		this.renyuan = renyuan;
	}

	public String getRenyuanLeixing() {
		return renyuanLeixing;
	}

	public void setRenyuanLeixing(String renyuanLeixing) {
		this.renyuanLeixing = renyuanLeixing;
	}

	public Date getKaishisj() {
		return kaishisj;
	}

	public void setKaishisj(Date kaishisj) {
		this.kaishisj = kaishisj;
	}

	public Date getJieshusj() {
		return jieshusj;
	}

	public void setJieshusj(Date jieshusj) {
		this.jieshusj = jieshusj;
	}

	public Double getXiaoshoujg() {
		return xiaoshoujg;
	}

	public void setXiaoshoujg(Double xiaoshoujg) {
		this.xiaoshoujg = xiaoshoujg;
	}

	public Date getXiaoshousj() {
		return xiaoshousj;
	}

	public void setXiaoshousj(Date xiaoshousj) {
		this.xiaoshousj = xiaoshousj;
	}

	public String getShifousy() {
		return shifousy;
	}

	public void setShifousy(String shifousy) {
		this.shifousy = shifousy;
	}
	
}