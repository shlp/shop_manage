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
 * �û�DAO��ʵ����
 * 
 * */
public class UserDaoImpl implements UserDao {

	//��������sessionFactory;
	//���ڽ���LocalSessionFactoryBean��ʵ��sessionFactory��ע��
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
		    Session session=sessionFactory.getCurrentSession();//ͨ��sessionFactory��ȡSession
			Criteria c=session.createCriteria(Users.class);//����Criteria����
			Example example=Example.create(u);//ʹ��Example�����ഴ��ʾ������
			c.add(example);//ΪCriteria����ָ��ʾ������example��Ϊ��ѯ����
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
