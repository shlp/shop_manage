package com.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Proxy;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
public class Goods {

	// Fields

	private Integer goodId;
	private Goodtype goodtype;
	private Users users;
	private String goodName;
	private String goodDescription;
	private Double goodPrice;
	private String goodPricture;
	private Integer goodNum;
	private String goodstate;
	private Set refurdforms = new HashSet(0);
	private Set orderforms = new HashSet(0);
	private Set goodcollections = new HashSet(0);
	private Set shoppingcarts = new HashSet(0);
	private Set browsinghistories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Users users) {
		this.users = users;
	}

	/** full constructor */
	public Goods(Goodtype goodtype, Users users, String goodName, String goodDescription, Double goodPrice,
			String goodPricture, Integer goodNum, String goodstate, Set refurdforms, Set orderforms,
			Set goodcollections, Set shoppingcarts, Set browsinghistories) {
		this.goodtype = goodtype;
		this.users = users;
		this.goodName = goodName;
		this.goodDescription = goodDescription;
		this.goodPrice = goodPrice;
		this.goodPricture = goodPricture;
		this.goodNum = goodNum;
		this.goodstate = goodstate;
		this.refurdforms = refurdforms;
		this.orderforms = orderforms;
		this.goodcollections = goodcollections;
		this.shoppingcarts = shoppingcarts;
		this.browsinghistories = browsinghistories;
	}

	// Property accessors

	public Integer getGoodId() {
		return this.goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public Goodtype getGoodtype() {
		return this.goodtype;
	}

	public void setGoodtype(Goodtype goodtype) {
		this.goodtype = goodtype;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getGoodName() {
		return this.goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodDescription() {
		return this.goodDescription;
	}

	public void setGoodDescription(String goodDescription) {
		this.goodDescription = goodDescription;
	}

	public Double getGoodPrice() {
		return this.goodPrice;
	}

	public void setGoodPrice(Double goodPrice) {
		this.goodPrice = goodPrice;
	}

	public String getGoodPricture() {
		return this.goodPricture;
	}

	public void setGoodPricture(String goodPricture) {
		this.goodPricture = goodPricture;
	}

	public Integer getGoodNum() {
		return this.goodNum;
	}

	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}

	public String getGoodstate() {
		return this.goodstate;
	}

	public void setGoodstate(String goodstate) {
		this.goodstate = goodstate;
	}

	public Set getRefurdforms() {
		return this.refurdforms;
	}

	public void setRefurdforms(Set refurdforms) {
		this.refurdforms = refurdforms;
	}

	public Set getOrderforms() {
		return this.orderforms;
	}

	public void setOrderforms(Set orderforms) {
		this.orderforms = orderforms;
	}

	public Set getGoodcollections() {
		return this.goodcollections;
	}

	public void setGoodcollections(Set goodcollections) {
		this.goodcollections = goodcollections;
	}

	public Set getShoppingcarts() {
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts) {
		this.shoppingcarts = shoppingcarts;
	}

	public Set getBrowsinghistories() {
		return this.browsinghistories;
	}

	public void setBrowsinghistories(Set browsinghistories) {
		this.browsinghistories = browsinghistories;
	}
	

}