package com.shop.service;

import java.util.List;
import com.entity.Goods;
import com.entity.Goodtype;
import com.entity.PageBean;
import com.entity.Users;
import com.shop.dao.ShopDao;

public class ShopServiceImpl implements ShopService {

	private ShopDao shopDao;
	public ShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	//发布商品
	@Override
	public void publishGood(Goods good) {
		this.shopDao.addGood(good);
	}
	
	//根据商品名、用户id,商品状态查询条件，获取指定页显示的商品列表 显示8条
	@Override
	public List<Goods> getUpGoodByConditionPage(Goods good, int page) {
		//System.out.println("shopserviceimp26..."+good);
		return shopDao.getUpGoodByConditionPage(good, page);
	}
	
	//根据商品名、用户id,商品状态查询条件，获取指定页显示的商品列表 显示4条
		@Override
		public List<Goods> getUpGoodByConditionPageByType(Goods good, int page) {
			return shopDao.getUpGoodByConditionPageByType(good, page);
		}

	//统计符合根据商品名、用户id、商品状态查询上架商品条件的商品总数 8条
	@Override
	public PageBean getPagerOfUpGoodByCondition(Goods good) {
		int count=shopDao.getCountOfUpGoodByCondition(good);
		//使用PageBean分页类定义对象
		PageBean pageBean=new PageBean();
		//设置PageBean对象中的pagesize，表示每页显示的记录数
		pageBean.setPagesize(8);
		//设置PageBean对象中的totalcount，表示记录总数
		pageBean.setTotalcount(count);
		//返回PageBean对象
		return pageBean;		
	}
	
	//统计符合根据商品名、用户id、商品状态查询上架商品条件的商品总数  4条
		@Override
		public PageBean getPagerOfUpGoodByConditionByType(Goods good) {
			int count=shopDao.getCountOfUpGoodByCondition(good);
			//使用PageBean分页类定义对象
			PageBean pageBean=new PageBean();
			//设置PageBean对象中的pagesize，表示每页显示的记录数
			pageBean.setPagesize(4);
			//设置PageBean对象中的totalcount，表示记录总数
			pageBean.setTotalcount(count);
			//返回PageBean对象
			return pageBean;		
		}
	
    //获取指定页显示的商品（查询所有商品）
	@Override
	public List<Goods> getGoodPage(int page) {
		return shopDao.getGoodPage(page);
	}
	
	//统计所有商品总数
	@Override
	public PageBean getCountOfGood() {
		int count=shopDao.getCountOfGood();
		//使用PageBean分页类定义对象
		PageBean pageBean=new PageBean();
		//设置PageBean对象中的pagesize，表示每页显示的记录数
		pageBean.setPagesize(4);
		//设置PageBean对象中的totalcount，表示记录总数
		pageBean.setTotalcount(count);
		//返回PageBean对象
		return pageBean;
	}
	
	//商品上架，下架，基本信息（修改商品状态为上架，下架，修改商品基本信息）
	@Override
	public void updateGood(Goods good) {
		shopDao.updateGood(good);
	}
	
	//根据商品id查询商品
	@Override
	public Goods findGoodByGoodId(int goodId) {
		return shopDao.getGoodByGoodId(goodId);
	}
	
	//删除商品
	@Override
	public void deleteGood(int goodId) {
		Goods g=shopDao.getGoodByGoodId(goodId);
		shopDao.deleteGood(g);
	}
	
	//获取商品类型列表
	@Override
	public List<Goodtype> findGoodType() {		
		return shopDao.getGoodTypeList();
	}
		
	//根据用户id查找用户
	@Override
	public Users findUserById(int userId) {
		return shopDao.findById(userId);
	}
	
	//根据类型id查找类型名称
	@Override
	public Goodtype findGoodType(int typeId) {
		return shopDao.getGoodType(typeId);
	}
	
}
