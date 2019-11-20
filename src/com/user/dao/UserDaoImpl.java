package com.user.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.junit.Test;

import com.entity.Goods;
import com.entity.Users;
/**
 * 用户DAO层实现类
 * 
 * */
public class UserDaoImpl implements UserDao {

	//声明属性sessionFactory;
	//用于接受LocalSessionFactoryBean类实例sessionFactory的注入
	SessionFactory sessionFactory;	
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Users findUser(Users u) {
		    List<Users> list=null;
		   // System.out.println("UserDaoImpl");
		    Session session=sessionFactory.getCurrentSession();//通过sessionFactory获取Session
			Criteria c=session.createCriteria(Users.class);//创建Criteria对象
			Example example=Example.create(u);//使用Example工具类创建示例对象
			c.add(example);//为Criteria对象指定示例对象example作为查询条件
			list=c.list();
			if(list.size()>0){
				return list.get(0);
			}else{
				return null;
			}	
	}
	
	@Override
	public Users findById(int userId) {
		 Users user= (Users)this.getSession().get(Users.class, userId);
		 return user;
	}
	@Override
	public void updateUser(Users user) {
		getSession().update(user);
	}	
	

}
