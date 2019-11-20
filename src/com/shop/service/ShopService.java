package com.shop.service;

import java.util.List;
import com.entity.Goods;
import com.entity.Goodtype;
import com.entity.PageBean;
import com.entity.Users;

public interface ShopService {
	
	//发布商品
    void publishGood(Goods good);
    
    //根据商品名、用户id,商品状态查询条件，获取指定页显示的商品列表
    List<Goods> getUpGoodByConditionPage(Goods good,int page);
    
    List<Goods> getUpGoodByConditionPageByType(Goods good,int page);
    
	//统计符合根据商品名、用户id、商品状态查询上架商品条件的商品总数
    PageBean getPagerOfUpGoodByCondition(Goods good); //8个
	
    PageBean getPagerOfUpGoodByConditionByType(Goods good);//4个
    //商品上架，下架，基本信息修改（修改商品状态为上架，下架，修改商品基本信息）
    void updateGood(Goods good);
      
    //根据商品id查询商品
    Goods findGoodByGoodId(int goodId);
    
    //删除商品
    void deleteGood(int goodId);
    
    //获取指定页显示的商品（查询所有商品）
  	List<Goods> getGoodPage(int page);
  	
  	//统计所有商品总数
  	PageBean getCountOfGood();
  	
  	//获取商品类别列表
  	List<Goodtype> findGoodType();
  	
  	//根据用户id查找用户
  	Users findUserById(int userId);
  	
    //根据类型id查找类型名称
  	Goodtype findGoodType(int typeId);
  	
    
}
