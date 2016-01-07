/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuyexiaoqu.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.wuyejiben.entity.WuyeJiben;

/**
 * 小区信息Entity
 * @author ktzhxm
 * @version 2015-12-06
 */
public class WuyeXiaoqu extends DataEntity<WuyeXiaoqu> {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 名称
	private String dizhi;		// 地址
	private String fuzeren;		// 负责人
	private String lianxiren;		// 联系人
	private String xiaoqudh;		// 小区电话
	private String zhibandh;		// 值班电话
	private Date jiansherq;		// 建设日期
	private String loudongshu="0";		// 楼栋数
	private String jianzhupm="0.0";		// 建筑平米
	private String gonggongpm="0.0";		// 公共平米
	private String lvhuapm="0.0";		// 绿化面积
	private String daolupm="0.0";		// 道路面积
	private String chekupm="0.0";		// 车库面积
	private String chewei="0";		// 车位数
	private String hushu="0";		// 户数
	private WuyeJiben wuye;		// 物业公司
	private String tupian;		// 图片
	
	public WuyeXiaoqu() {
		super();
	}

	public WuyeXiaoqu(String id){
		super(id);
	}

	@Length(min=0, max=60, message="名称长度必须介于 0 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	@Length(min=0, max=120, message="地址长度必须介于 0 和 120 之间")
	public String getDizhi() {
		return dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
	@Length(min=0, max=10, message="负责人长度必须介于 0 和 10 之间")
	public String getFuzeren() {
		return fuzeren;
	}

	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	
	@Length(min=0, max=10, message="联系人长度必须介于 0 和 10 之间")
	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	
	@Length(min=0, max=18, message="小区电话长度必须介于 0 和 18 之间")
	public String getXiaoqudh() {
		return xiaoqudh;
	}

	public void setXiaoqudh(String xiaoqudh) {
		this.xiaoqudh = xiaoqudh;
	}
	
	@Length(min=0, max=18, message="值班电话长度必须介于 0 和 18 之间")
	public String getZhibandh() {
		return zhibandh;
	}

	public void setZhibandh(String zhibandh) {
		this.zhibandh = zhibandh;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJiansherq() {
		return jiansherq;
	}

	public void setJiansherq(Date jiansherq) {
		this.jiansherq = jiansherq;
	}
	
	@Length(min=0, max=10, message="楼栋数长度必须介于 0 和 10 之间")
	public String getLoudongshu() {
		return loudongshu;
	}

	public void setLoudongshu(String loudongshu) {
		this.loudongshu = loudongshu;
	}
	
	public String getJianzhupm() {
		return jianzhupm;
	}

	public void setJianzhupm(String jianzhupm) {
		this.jianzhupm = jianzhupm;
	}
	
	public String getGonggongpm() {
		return gonggongpm;
	}

	public void setGonggongpm(String gonggongpm) {
		this.gonggongpm = gonggongpm;
	}
	
	public String getLvhuapm() {
		return lvhuapm;
	}

	public void setLvhuapm(String lvhuapm) {
		this.lvhuapm = lvhuapm;
	}
	
	public String getDaolupm() {
		return daolupm;
	}

	public void setDaolupm(String daolupm) {
		this.daolupm = daolupm;
	}
	
	public String getChekupm() {
		return chekupm;
	}

	public void setChekupm(String chekupm) {
		this.chekupm = chekupm;
	}
	
	@Length(min=0, max=10, message="车位数长度必须介于 0 和 10 之间")
	public String getChewei() {
		return chewei;
	}

	public void setChewei(String chewei) {
		this.chewei = chewei;
	}
	
	@Length(min=0, max=10, message="户数长度必须介于 0 和 10 之间")
	public String getHushu() {
		return hushu;
	}

	public void setHushu(String hushu) {
		this.hushu = hushu;
	}
	
	public WuyeJiben getWuye() {
		return wuye;
	}

	public void setWuye(WuyeJiben wuye) {
		this.wuye = wuye;
	}
	
	@Length(min=0, max=120, message="图片长度必须介于 0 和 120 之间")
	public String getTupian() {
		return tupian;
	}

	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
}