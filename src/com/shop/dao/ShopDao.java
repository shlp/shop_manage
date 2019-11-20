package com.shop.dao;

import java.util.List;
import com.entity.Goods;
import com.entity.Goodtype;
import com.entity.Users;

public interface ShopDao {
	
	//������Ʒ
	void addGood(Goods good);	
	
	//������˵���������Ʒ����ѯָ���û�����״̬�ϼܡ��¼ܡ�ʧЧ��Ʒ(������Ʒ�����û�id,��Ʒ״̬��ѯ��������ȡָ��ҳ��ʾ����Ʒ�б�)
	List<Goods> getUpGoodByConditionPage(Goods good,int page);
	
	List<Goods> getUpGoodByConditionPageByType(Goods good, int page);
	
	//ͳ�Ʒ��ϸ�����Ʒ�����û�id����Ʒ״̬��ѯ�ϼ���Ʒ��������Ʒ����
	Integer getCountOfUpGoodByCondition(Goods good);
	
	//��Ʒ�ϼܣ��¼ܣ�������Ϣ�޸ģ��޸���Ʒ״̬Ϊ�ϼܣ��¼ܣ��޸Ļ�����Ϣ��
	void updateGood(Goods good);
	
	//������Ʒid��ѯ��Ʒ
	Goods getGoodByGoodId(int goodId);
	
	//ɾ����Ʒ
	void deleteGood(Goods good);
	
	//��ȡָ��ҳ��ʾ����Ʒ����ѯ������Ʒ��
	List<Goods> getGoodPage(int page);
	
	//ͳ��������Ʒ����
	Integer getCountOfGood();
	
	//��������id������������
	Goodtype getGoodType(int typeId);
	
	//��ȡ��Ʒ�����б�
	List<Goodtype> getGoodTypeList();
	
	//�����û�id�����û�
	Users findById(int userId);
	/*void uppro(Goods product);

	List<Goods> findByNamee(String findbyname);

	List<Goods> findByNamee(Integer finduserid);

	List<Goods> findByPid(Integer pid);

	List<Goods> findByType(String ptype);

	Goods findByDelPid(Integer delpid);

	void deleteProduct(Goods product);

	Goods findBySid(Integer sailproductid);

	void updateProduct(Goods sproduct);*/
}
