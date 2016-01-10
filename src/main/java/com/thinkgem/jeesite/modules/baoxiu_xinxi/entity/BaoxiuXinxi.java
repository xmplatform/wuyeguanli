/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_xinxi.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 报修信息主表Entity
 * @author ktzhxm
 * @version 2016-01-02
 */
public class BaoxiuXinxi extends DataEntity<BaoxiuXinxi> {
	
	private static final long serialVersionUID = 1L;
	private String mingcheng;		// 标题
	private String zhuangtai;		// 状态
	private String taohuid;		// 套户
	private String dianhua;		// 报修电话
	private User weixiuy;		//维修员
	private Date yuyuesj;		// 预约时间
	private Integer weixiuqy;	//维修区域
	
	public BaoxiuXinxi() {
		super();
	}

	public BaoxiuXinxi(String id){
		super(id);
	}

	@Length(min=0, max=60, message="标题长度必须介于 0 和 60 之间")
	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
	@Length(min=0, max=64, message="套户长度必须介于 0 和 64 之间")
	public String getTaohuid() {
		return taohuid;
	}

	public void setTaohuid(String taohuid) {
		this.taohuid = taohuid;
	}
	
	@Length(min=0, max=15, message="报修电话长度必须介于 0 和 15 之间")
	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYuyuesj() {
		return yuyuesj;
	}

	public void setYuyuesj(Date yuyuesj) {
		this.yuyuesj = yuyuesj;
	}

	public User getWeixiuy() {
		return weixiuy;
	}

	public void setWeixiuy(User weixiuy) {
		this.weixiuy = weixiuy;
	}

	public Integer getWeixiuqy() {
		return weixiuqy;
	}

	public void setWeixiuqy(Integer weixiuqy) {
		this.weixiuqy = weixiuqy;
	}
	
}