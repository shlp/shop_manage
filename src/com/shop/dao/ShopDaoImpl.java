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
	//������Ʒ
	@Override
	public void addGood(Goods good) {
		this.getSession().save(good);		
	}
		
	//��ȡָ��ҳ��ʾ����Ʒ����ѯ������Ʒ��
	@Override
	public List<Goods> getGoodPage(int page) {
		Criteria c=this.getSession().createCriteria(Goods.class);
		c.setFirstResult(4*(page-1));
		c.setMaxResults(4);
		return c.list();
	}
	//ͳ��������Ʒ����
	@Override
	public Integer getCountOfGood() {
		Integer count=null;
		String hql="select count(g) from Goods g";
		Query query=getSession().createQuery(hql);
		count=Integer.parseInt(query.uniqueResult().toString());		
		return count;
	}
	//������Ʒ�����û�id,��Ʒ״̬��ѯ��������ȡָ��ҳ��ʾ����Ʒ�б�  ��ʾ�˸�
	@Override
	public List<Goods> getUpGoodByConditionPage(Goods good, int page) {
		Criteria c=this.getSession().createCriteria(Goods.class);
		if(good!=null){			
			if(good.getUsers().getUserId()!=null&&!good.getUsers().getUserId().equals("")){
				//����ָ���û�����Ʒ
				//System.out.println("shopdaoimp54...���ݵ�userid"+good.getUsers().getUserId());
				c.add(Restrictions.eq("users.userId",good.getUsers().getUserId()));				
			}
			if(good.getGoodtype().getTypeId()!=null&&!good.getGoodtype().getTypeId().equals("")){
				//������Ʒ����ɸѡ
				c.add(Restrictions.eq("goodtype.typeId", good.getGoodtype().getTypeId()));					
			}
			if(good.getGoodName()!=null&&!good.getGoodName().equals("")){
				//������Ʒ��ɸѡ
				c.add(Restrictions.like("goodName", good.getGoodName(),MatchMode.ANYWHERE));				
			}
			if(good.getGoodstate()!=null&&!good.getGoodstate().equals("")){
				//�����ϼ�״̬����
				//System.out.println("shopdaoimp63...���ݵ�goodstate"+ good.getGoodstate());
				c.add(Restrictions.like("goodstate", good.getGoodstate(),MatchMode.ANYWHERE));	
			}			
		}		
		c.setFirstResult(8*(page-1));
		c.setMaxResults(8);
		return c.list();
	}
	
	//ͳ�Ʒ��ϸ�����Ʒ�����û�id����Ʒ״̬��ѯ�ϼ���Ʒ��������Ʒ����
	@Override
	public Integer getCountOfUpGoodByCondition(Goods good) {
		Criteria c=this.getSession().createCriteria(Goods.class);
		if(good!=null){			
			if(good.getUsers().getUserId()!=null&&!good.getUsers().getUserId().equals("")){
				//����ָ���û�����Ʒ
				c.add(Restrictions.eq("users.userId",good.getUsers().getUserId()));		//User.userId������Ӧ���ݿ����ֶ�		
			}
			if(good.getGoodtype().getTypeId()!=null&&!good.getGoodtype().getTypeId().equals("")){
				//������Ʒ����ɸѡ
				c.add(Restrictions.eq("goodtype.typeId", good.getGoodtype().getTypeId()));					
			}
			if(good.getGoodName()!=null&&!good.getGoodName().equals("")){
				//������Ʒ��ɸѡ
				c.add(Restrictions.like("goodName", good.getGoodName(),MatchMode.ANYWHERE));				
			}
			if(good.getGoodstate()!=null&&!good.getGoodstate().equals("")){
				//�����ϼ�״̬����
				c.add(Restrictions.like("goodstate", good.getGoodstate(),MatchMode.ANYWHERE));	
			}			
		}
		return c.list().size();
	}
	
	//������Ʒ�����û�id,��Ʒ״̬��ѯ��������ȡָ��ҳ��ʾ����Ʒ�б� ��ʾ�ĸ�  
		@Override
		public List<Goods> getUpGoodByConditionPageByType(Goods good, int page) {
			Criteria c=this.getSession().createCriteria(Goods.class);
			if(good!=null){			
				if(good.getUsers().getUserId()!=null&&!good.getUsers().getUserId().equals("")){
					//����ָ���û�����Ʒ
					//System.out.println("shopdaoimp54...���ݵ�userid"+good.getUsers().getUserId());
					c.add(Restrictions.eq("users.userId",good.getUsers().getUserId()));				
				}
				if(good.getGoodtype().getTypeId()!=null&&!good.getGoodtype().getTypeId().equals("")){
					//������Ʒ����ɸѡ
					c.add(Restrictions.eq("goodtype.typeId", good.getGoodtype().getTypeId()));					
				}
				if(good.getGoodName()!=null&&!good.getGoodName().equals("")){
					//������Ʒ��ɸѡ
					c.add(Restrictions.like("goodName", good.getGoodName(),MatchMode.ANYWHERE));				
				}
				if(good.getGoodstate()!=null&&!good.getGoodstate().equals("")){
					//�����ϼ�״̬����
					//System.out.println("shopdaoimp63...���ݵ�goodstate"+ good.getGoodstate());
					c.add(Restrictions.like("goodstate", good.getGoodstate(),MatchMode.ANYWHERE));	
				}			
			}		
			c.setFirstResult(4*(page-1));
			c.setMaxResults(4);
			return c.list();
		}		
	
	//��Ʒ�ϼܣ��¼ܣ�������Ϣ�޸ģ��޸���Ʒ״̬Ϊ�ϼܣ��¼ܣ��޸Ļ�����Ϣ��
	@Override
	public void updateGood(Goods good) {
		this.getSession().update(good);
	}
	
	//������Ʒid��ѯ��Ʒ
	@Override
	public Goods getGoodByGoodId(int goodId) {
		Goods good=null;
		good=(Goods)this.getSession().get(Goods.class, goodId);
		return good;
	}
	
	//ɾ����Ʒ
	@Override
	public void deleteGood(Goods good) {
		this.getSession().delete(good);
	}
	
	//��ȡ��Ʒ�����б�
	@Override
	public List<Goodtype> getGoodTypeList() {
		Criteria c=this.getSession().createCriteria(Goodtype.class);
		return c.list();
	}
	
	//�����û�id�����û�
	@Override
	public Users findById(int userId) {
		 Users user= (Users)this.getSession().get(Users.class, userId);
		 return user;
	}
	
	//��������id������������
	@Override
	public Goodtype getGoodType(int typeId) {
		Goodtype goodtype=(Goodtype)this.getSession().get(Goodtype.class,typeId);
		return goodtype;
	}
	
}
