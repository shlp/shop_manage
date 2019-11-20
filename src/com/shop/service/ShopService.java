package com.shop.service;

import java.util.List;
import com.entity.Goods;
import com.entity.Goodtype;
import com.entity.PageBean;
import com.entity.Users;

public interface ShopService {
	
	//������Ʒ
    void publishGood(Goods good);
    
    //������Ʒ�����û�id,��Ʒ״̬��ѯ��������ȡָ��ҳ��ʾ����Ʒ�б�
    List<Goods> getUpGoodByConditionPage(Goods good,int page);
    
    List<Goods> getUpGoodByConditionPageByType(Goods good,int page);
    
	//ͳ�Ʒ��ϸ�����Ʒ�����û�id����Ʒ״̬��ѯ�ϼ���Ʒ��������Ʒ����
    PageBean getPagerOfUpGoodByCondition(Goods good); //8��
	
    PageBean getPagerOfUpGoodByConditionByType(Goods good);//4��
    //��Ʒ�ϼܣ��¼ܣ�������Ϣ�޸ģ��޸���Ʒ״̬Ϊ�ϼܣ��¼ܣ��޸���Ʒ������Ϣ��
    void updateGood(Goods good);
      
    //������Ʒid��ѯ��Ʒ
    Goods findGoodByGoodId(int goodId);
    
    //ɾ����Ʒ
    void deleteGood(int goodId);
    
    //��ȡָ��ҳ��ʾ����Ʒ����ѯ������Ʒ��
  	List<Goods> getGoodPage(int page);
  	
  	//ͳ��������Ʒ����
  	PageBean getCountOfGood();
  	
  	//��ȡ��Ʒ����б�
  	List<Goodtype> findGoodType();
  	
  	//�����û�id�����û�
  	Users findUserById(int userId);
  	
    //��������id������������
  	Goodtype findGoodType(int typeId);
  	
    
}
