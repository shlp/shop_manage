package com.shop.dao;

import java.util.List;
import com.entity.Goods;
import com.entity.Goodtype;
import com.entity.Users;

public interface ShopDao {
	
	//发布商品
	void addGood(Goods good);	
	
	//浏览个人店铺输入商品名查询指定用户各种状态上架、下架、失效商品(根据商品名、用户id,商品状态查询条件，获取指定页显示的商品列表)
	List<Goods> getUpGoodByConditionPage(Goods good,int page);
	
	List<Goods> getUpGoodByConditionPageByType(Goods good, int page);
	
	//统计符合根据商品名、用户id、商品状态查询上架商品条件的商品总数
	Integer getCountOfUpGoodByCondition(Goods good);
	
	//商品上架，下架，基本信息修改（修改商品状态为上架，下架，修改基本信息）
	void updateGood(Goods good);
	
	//根据商品id查询商品
	Goods getGoodByGoodId(int goodId);
	
	//删除商品
	void deleteGood(Goods good);
	
	//获取指定页显示的商品（查询所有商品）
	List<Goods> getGoodPage(int page);
	
	//统计所有商品总数
	Integer getCountOfGood();
	
	//根据类型id查找类型名称
	Goodtype getGoodType(int typeId);
	
	//获取商品类型列表
	List<Goodtype> getGoodTypeList();
	
	//根据用户id查找用户
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
