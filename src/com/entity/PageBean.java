package com.entity;

import java.util.List;

public class PageBean<T> {
	private int currpage;//����ʾҳ��
	private int pagesize;//ÿҳ��ʾ�ļ�¼��
	private int totalcount;//��¼����
	private int totalpage;//��ҳ��
	private List<T> list;
	@Override
	public String toString() {
		return "PageBean [currpage=" + currpage + ", pagesize=" + pagesize + ", totalcount=" + totalcount
				+ ", totalpage=" + totalpage + ", list=" + list + "]";
	}
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getTotalpage() {
		return (totalcount+pagesize-1)/pagesize;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
