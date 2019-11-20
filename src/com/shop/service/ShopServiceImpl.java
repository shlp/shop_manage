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
	//������Ʒ
	@Override
	public void publishGood(Goods good) {
		this.shopDao.addGood(good);
	}
	
	//������Ʒ�����û�id,��Ʒ״̬��ѯ��������ȡָ��ҳ��ʾ����Ʒ�б� ��ʾ8��
	@Override
	public List<Goods> getUpGoodByConditionPage(Goods good, int page) {
		//System.out.println("shopserviceimp26..."+good);
		return shopDao.getUpGoodByConditionPage(good, page);
	}
	
	//������Ʒ�����û�id,��Ʒ״̬��ѯ��������ȡָ��ҳ��ʾ����Ʒ�б� ��ʾ4��
		@Override
		public List<Goods> getUpGoodByConditionPageByType(Goods good, int page) {
			return shopDao.getUpGoodByConditionPageByType(good, page);
		}

	//ͳ�Ʒ��ϸ�����Ʒ�����û�id����Ʒ״̬��ѯ�ϼ���Ʒ��������Ʒ���� 8��
	@Override
	public PageBean getPagerOfUpGoodByCondition(Goods good) {
		int count=shopDao.getCountOfUpGoodByCondition(good);
		//ʹ��PageBean��ҳ�ඨ�����
		PageBean pageBean=new PageBean();
		//����PageBean�����е�pagesize����ʾÿҳ��ʾ�ļ�¼��
		pageBean.setPagesize(8);
		//����PageBean�����е�totalcount����ʾ��¼����
		pageBean.setTotalcount(count);
		//����PageBean����
		return pageBean;		
	}
	
	//ͳ�Ʒ��ϸ�����Ʒ�����û�id����Ʒ״̬��ѯ�ϼ���Ʒ��������Ʒ����  4��
		@Override
		public PageBean getPagerOfUpGoodByConditionByType(Goods good) {
			int count=shopDao.getCountOfUpGoodByCondition(good);
			//ʹ��PageBean��ҳ�ඨ�����
			PageBean pageBean=new PageBean();
			//����PageBean�����е�pagesize����ʾÿҳ��ʾ�ļ�¼��
			pageBean.setPagesize(4);
			//����PageBean�����е�totalcount����ʾ��¼����
			pageBean.setTotalcount(count);
			//����PageBean����
			return pageBean;		
		}
	
    //��ȡָ��ҳ��ʾ����Ʒ����ѯ������Ʒ��
	@Override
	public List<Goods> getGoodPage(int page) {
		return shopDao.getGoodPage(page);
	}
	
	//ͳ��������Ʒ����
	@Override
	public PageBean getCountOfGood() {
		int count=shopDao.getCountOfGood();
		//ʹ��PageBean��ҳ�ඨ�����
		PageBean pageBean=new PageBean();
		//����PageBean�����е�pagesize����ʾÿҳ��ʾ�ļ�¼��
		pageBean.setPagesize(4);
		//����PageBean�����е�totalcount����ʾ��¼����
		pageBean.setTotalcount(count);
		//����PageBean����
		return pageBean;
	}
	
	//��Ʒ�ϼܣ��¼ܣ�������Ϣ���޸���Ʒ״̬Ϊ�ϼܣ��¼ܣ��޸���Ʒ������Ϣ��
	@Override
	public void updateGood(Goods good) {
		shopDao.updateGood(good);
	}
	
	//������Ʒid��ѯ��Ʒ
	@Override
	public Goods findGoodByGoodId(int goodId) {
		return shopDao.getGoodByGoodId(goodId);
	}
	
	//ɾ����Ʒ
	@Override
	public void deleteGood(int goodId) {
		Goods g=shopDao.getGoodByGoodId(goodId);
		shopDao.deleteGood(g);
	}
	
	//��ȡ��Ʒ�����б�
	@Override
	public List<Goodtype> findGoodType() {		
		return shopDao.getGoodTypeList();
	}
		
	//�����û�id�����û�
	@Override
	public Users findUserById(int userId) {
		return shopDao.findById(userId);
	}
	
	//��������id������������
	@Override
	public Goodtype findGoodType(int typeId) {
		return shopDao.getGoodType(typeId);
	}
	
}
