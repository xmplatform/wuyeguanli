/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.baoxiu_xinxi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.baoxiu_paiban.dao.BaoxiuPaibanDao;
import com.thinkgem.jeesite.modules.baoxiu_paiban.entity.BaoxiuPaiban;
import com.thinkgem.jeesite.modules.baoxiu_xinxi.dao.BaoxiuXinxiDao;
import com.thinkgem.jeesite.modules.baoxiu_xinxi.entity.BaoxiuXinxi;

/**
 * 报修信息主表Service
 * 
 * @author ktzhxm
 * @version 2016-01-02
 */
@Service
@Transactional(readOnly = true)
public class BaoxiuXinxiService extends CrudService<BaoxiuXinxiDao, BaoxiuXinxi> {

	@Autowired
	BaoxiuPaibanDao paibanDao;

	public BaoxiuXinxi get(String id) {
		return super.get(id);
	}

	public List<BaoxiuXinxi> findList(BaoxiuXinxi baoxiuXinxi) {
		return super.findList(baoxiuXinxi);
	}

	public Page<BaoxiuXinxi> findPage(Page<BaoxiuXinxi> page, BaoxiuXinxi baoxiuXinxi) {
		return super.findPage(page, baoxiuXinxi);
	}

	@Transactional(readOnly = false)
	public void save(BaoxiuXinxi baoxiuXinxi) {
		super.save(baoxiuXinxi);
	}

	@Transactional(readOnly = false)
	public void delete(BaoxiuXinxi baoxiuXinxi) {
		super.delete(baoxiuXinxi);
	}

	public List<BaoxiuPaiban> loadWeixiu(String yuyuesj) {
		String[] shijianArr = yuyuesj.split("-");

		BaoxiuPaiban paiban = new BaoxiuPaiban();
		paiban.setZhibansj(yuyuesj.substring(0, 7));
		paiban.setDelFlag("0");
		List<BaoxiuPaiban> paibanList = paibanDao.findList(paiban);

		List<BaoxiuPaiban> resultList = new ArrayList<BaoxiuPaiban>();
		for (BaoxiuPaiban p : paibanList) {
			String[] riArr = p.getRiStr().split(",");//排班日
			//遍历排班日
			for (String ri : riArr) {
				if (Integer.parseInt(ri)==Integer.parseInt(shijianArr[2])) {
					resultList.add(p);
					break;
				}
			}
		}
		return resultList;
	}

}