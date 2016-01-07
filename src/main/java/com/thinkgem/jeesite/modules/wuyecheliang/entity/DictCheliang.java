/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyecheliang.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.wuyechewei.entity.DictChewei;
import com.thinkgem.jeesite.modules.wuyerenyuan.entity.DictRenyuan;

/**
 * 车辆信息Entity
 * @author ktzhxm
 * @version 2015-12-10
 */
public class DictCheliang extends DataEntity<DictCheliang> {
	
	private static final long serialVersionUID = 1L;
	private String chepai;		// 车牌号
	private DictChewei chewei;		// 车位
	private String chekah;		//车卡号
	private DictRenyuan renyuan;
	private String leixing;		// 车辆类型
	private String pinpai;		// 车辆品牌
	private String yanse;		// 车辆颜色
	private String churuzh;		// 出入证号
	private Date kaishisj;		// 开始时间
	private Date jieshusj;		// 结束时间
	
	public DictCheliang() {
		super();
	}

	public DictCheliang(String id){
		super(id);
	}

	@Length(min=1, max=12, message="车牌号长度必须介于 1 和 12 之间")
	public String getChepai() {
		return chepai;
	}

	public void setChepai(String chepai) {
		this.chepai = chepai;
	}
	
	@Length(min=0, max=12, message="车辆类型长度必须介于 0 和 12 之间")
	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	@Length(min=0, max=12, message="车辆品牌长度必须介于 0 和 12 之间")
	public String getPinpai() {
		return pinpai;
	}

	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	
	@Length(min=0, max=12, message="车辆颜色长度必须介于 0 和 12 之间")
	public String getYanse() {
		return yanse;
	}

	public void setYanse(String yanse) {
		this.yanse = yanse;
	}
	
	@Length(min=0, max=20, message="出入证号长度必须介于 0 和 20 之间")
	public String getChuruzh() {
		return churuzh;
	}

	public void setChuruzh(String churuzh) {
		this.churuzh = churuzh;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getKaishisj() {
		return kaishisj;
	}

	public void setKaishisj(Date kaishisj) {
		this.kaishisj = kaishisj;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJieshusj() {
		return jieshusj;
	}

	public void setJieshusj(Date jieshusj) {
		this.jieshusj = jieshusj;
	}

	public String getChekah() {
		return chekah;
	}

	public void setChekah(String chekah) {
		this.chekah = chekah;
	}

	public DictRenyuan getRenyuan() {
		return renyuan;
	}

	public void setRenyuan(DictRenyuan renyuan) {
		this.renyuan = renyuan;
	}

	public DictChewei getChewei() {
		return chewei;
	}

	public void setChewei(DictChewei chewei) {
		this.chewei = chewei;
	}
	
}