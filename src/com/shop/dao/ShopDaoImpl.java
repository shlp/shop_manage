package com.shop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.entity.Goods;
import com.entity.Goodtype;
import com.entity.PageBean;
import com.entity.Users;

public class ShopDaoImpl implements ShopDao {
	SessionFactory sessionFactory;		
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//发布商品
	@Override
	public void addGood(Goods good) {
		this.getSession().save(good);		
	}
		
	//获取指定页显示的商品（查询所有商品）
	@Override
	public List<Goods> getGoodPage(int page) {
		Criteria c=this.getSession().createCriteria(Goods.class);
		c.setFirstResult(4*(page-1));
		c.setMaxResults(4);
		return c.list();
	}
	//统计所有商品总数
	@Override
	public Integer getCountOfGood() {
		Integer count=null;
		String hql="select count(g) from Goods g";
		Query query=getSession().createQuery(hql);
		count=Integer.parseInt(query.uniqueResult().toString());		
		return count;
	}
	//根据商品名、用户id,商品状态查询条件，获取指定页显示的商品列表  显示八个
	@Override
	public List<Goods> getUpGoodByConditionPage(Goods good, int page) {
		Criteria c=this.getSession().createCriteria(Goods.class);
		if(good!=null){			
			if(good.getUsers().getUserId()!=null&&!good.getUsers().getUserId().equals("")){
				//查找指定用户的商品
				//System.out.println("shopdaoimp54...根据的userid"+good.getUsers().getUserId());
				c.add(Restrictions.eq("users.userId",good.getUsers().getUserId()));				
			}
			if(good.getGoodtype().getTypeId()!=null&&!good.getGoodtype().getTypeId().equals("")){
				//按照商品类型筛选
				c.add(Restrictions.eq("goodtype.typeId", good.getGoodtype().getTypeId()));					
			}
			if(good.getGoodName()!=null&&!good.getGoodName().equals("")){
				//按照商品名筛选
				c.add(Restrictions.like("goodName", good.getGoodName(),MatchMode.ANYWHERE));				
			}
			if(good.getGoodstate()!=null&&!good.getGoodstate().equals("")){
				//按照上架状态查找
				//System.out.println("shopdaoimp63...根据的goodstate"+ good.getGoodstate());
				c.add(Restrictions.like("goodstate", good.getGoodstate(),MatchMode.ANYWHERE));	
			}			
		}		
		c.setFirstResult(8*(page-1));
		c.setMaxResults(8);
		return c.list();
	}
	
	//统计符合根据商品名、用户id、商品状态查询上架商品条件的商品总数
	@Override
	public Integer getCountOfUpGoodByCondition(Goods good) {
		Criteria c=this.getSession().createCriteria(Goods.class);
		if(good!=null){			
			if(good.getUsers().getUserId()!=null&&!good.getUsers().getUserId().equals("")){
				//查找指定用户的商品
				c.add(Restrictions.eq("users.userId",good.getUsers().getUserId()));		//User.userId报错，对应数据库表的字段		
			}
			if(good.getGoodtype().getTypeId()!=null&&!good.getGoodtype().getTypeId().equals("")){
				//按照商品类型筛选
				c.add(Restrictions.eq("goodtype.typeId", good.getGoodtype().getTypeId()));					
			}
			if(good.getGoodName()!=null&&!good.getGoodName().equals("")){
				//按照商品名筛选
				c.add(Restrictions.like("goodName", good.getGoodName(),MatchMode.ANYWHERE));				
			}
			if(good.getGoodstate()!=null&&!good.getGoodstate().equals("")){
				//按照上架状态查找
				c.add(Restrictions.like("goodstate", good.getGoodstate(),MatchMode.ANYWHERE));	
			}			
		}
		return c.list().size();
	}
	
	//根据商品名、用户id,商品状态查询条件，获取指定页显示的商品列表 显示四个  
		@Override
		public List<Goods> getUpGoodByConditionPageByType(Goods good, int page) {
			Criteria c=this.getSession().createCriteria(Goods.class);
			if(good!=null){			
				if(good.getUsers().getUserId()!=null&&!good.getUsers().getUserId().equals("")){
					//查找指定用户的商品
					//System.out.println("shopdaoimp54...根据的userid"+good.getUsers().getUserId());
					c.add(Restrictions.eq("users.userId",good.getUsers().getUserId()));				
				}
				if(good.getGoodtype().getTypeId()!=null&&!good.getGoodtype().getTypeId().equals("")){
					//按照商品类型筛选
					c.add(Restrictions.eq("goodtype.typeId", good.getGoodtype().getTypeId()));					
				}
				if(good.getGoodName()!=null&&!good.getGoodName().equals("")){
					//按照商品名筛选
					c.add(Restrictions.like("goodName", good.getGoodName(),MatchMode.ANYWHERE));				
				}
				if(good.getGoodstate()!=null&&!good.getGoodstate().equals("")){
					//按照上架状态查找
					//System.out.println("shopdaoimp63...根据的goodstate"+ good.getGoodstate());
					c.add(Restrictions.like("goodstate", good.getGoodstate(),MatchMode.ANYWHERE));	
				}			
			}		
			c.setFirstResult(4*(page-1));
			c.setMaxResults(4);
			return c.list();
		}		
	
	//商品上架，下架，基本信息修改（修改商品状态为上架，下架，修改基本信息）
	@Override
	public void updateGood(Goods good) {
		this.getSession().update(good);
	}
	
	//根据商品id查询商品
	@Override
	public Goods getGoodByGoodId(int goodId) {
		Goods good=null;
		good=(Goods)this.getSession().get(Goods.class, goodId);
		return good;
	}
	
	//删除商品
	@Override
	public void deleteGood(Goods good) {
		this.getSession().delete(good);
	}
	
	//获取商品类型列表
	@Override
	public List<Goodtype> getGoodTypeList() {
		Criteria c=this.getSession().createCriteria(Goodtype.class);
		return c.list();
	}
	
	//根据用户id查找用户
	@Override
	public Users findById(int userId) {
		 Users user= (Users)this.getSession().get(Users.class, userId);
		 return user;
	}
	
	//根据类型id查找类型名称
	@Override
	public Goodtype getGoodType(int typeId) {
		Goodtype goodtype=(Goodtype)this.getSession().get(Goodtype.class,typeId);
		return goodtype;
	}
	
}
