package com.shop.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.entity.Goods;
import com.entity.Goodtype;
import com.entity.PageBean;
import com.entity.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.service.ShopService;


public class ShopAction extends ActionSupport /*implements RequestAwareSessionAware*/{
	private ShopService shopService;
	private String goodName;
	private String goodDescription;
	private String goodPrice;
	private Integer typeId;
	private String goodState;
	private File upload; //ͼƬ
	private String goodNum;
	private String uploadContentType;
	private String uploadFileName;
	private Integer findByuserid;
	private PageBean pageBean;
	private Integer findBygoodid;
	private String findgoodid;
	
	
	public String getFindgoodid() {
		return findgoodid;
	}

	public void setFindgoodid(String findgoodid) {
		this.findgoodid = findgoodid;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getFindBygoodid() {
		return findBygoodid;
	}

	public void setFindBygoodid(Integer findBygoodid) {
		this.findBygoodid = findBygoodid;
	}

	public String getGoodState() {
		return goodState;
	}

	public void setGoodState(String goodState) {
		this.goodState = goodState;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public Integer getFindByuserid() {
		return findByuserid;
	}

	public void setFindByuserid(Integer findByuserid) {
		this.findByuserid = findByuserid;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodDescription() {
		return goodDescription;
	}

	public void setGoodDescription(String goodDescription) {
		this.goodDescription = goodDescription;
	}

	public String getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(String goodPrice) {
		this.goodPrice = goodPrice;
	}
	
	public Integer getTypeId() {
		return typeId;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(String goodNum) {
		this.goodNum = goodNum;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	//��½֮��λ����ҳ����ʾ��Ʒ�ͷ�����Ϣ
	public String toShowHome(){
		List goodTypeList=shopService.findGoodType();
		int currpage=1;
		//System.out.println("shopaction160...pageBean:"+pageBean);
		if(pageBean!=null)
			currpage=pageBean.getCurrpage();
		List<Goods> goodToSellList=null;		
		goodState="yishangjia";
		goodToSellList=shopService.getGoodPage(currpage);
		pageBean=shopService.getCountOfGood();
		pageBean.setCurrpage(currpage);
		
		ActionContext.getContext().put("goodState", goodState);
		ActionContext.getContext().put("goodToSellList", goodToSellList);
		ActionContext.getContext().put("TypeList", goodTypeList);
		return "toshowgoodtypesuccess";
	}
	
	//������Ʒ���ͷ�����Ϣ��ѯ
	public String findGoodBytypeId(){
		int currpage=1;
		//System.out.println("shopaction160...pageBean:"+pageBean);
		if(pageBean!=null)
			currpage=pageBean.getCurrpage();
		List<Goods> goodList=null;		
		Goods g=new Goods();
		Users u=new Users();
		Goodtype goodtype=new Goodtype();
		goodState="yishangjia";
		//System.out.println("shopaction181...findByuserid:"+findByuserid);
		//u.setUserId(findByuserid);
		g.setGoodstate(goodState);		
		g.setUsers(u);
		
		//������Ʒ������������Ʒ
		if(goodName!=null&&!goodName.equals(""))
			g.setGoodName(goodName);
		if(typeId!=null&&!typeId.equals("")){
			System.out.println("shopaction189...typeId:"+typeId);
			goodtype=shopService.findGoodType(typeId);			
		}
		else{
			goodtype.setTypeId(typeId);	
		}
		g.setGoodtype(goodtype);
		List goodTypeList=shopService.findGoodType();
		
		goodList=shopService.getUpGoodByConditionPage(g, currpage);
		pageBean=shopService.getPagerOfUpGoodByCondition(g);
		pageBean.setCurrpage(currpage);
		System.out.println(goodList);
		if(goodList!=null&&!goodList.isEmpty()){
			//System.out.println("shopaction:typeId"+typeId+g.getGoodtype().getTypeId()+pageBean.getPagesize()+goodTypeList);
			//ActionContext.getContext().put("findByuserid", g.getUsers().getUserId());
			System.out.println("shopaction205...findByuserid:"+g.getUsers().getUserId());
			ActionContext.getContext().put("goodState", goodState);
			ActionContext.getContext().put("goodtype", goodtype);
			ActionContext.getContext().put("goodToSellList", goodList);
			ActionContext.getContext().put("TypeList", goodTypeList);
		
		}else{
			System.out.println("goodMessage");
			ActionContext.getContext().put("goodState", goodState);
			ActionContext.getContext().put("goodtype", goodtype);
			ActionContext.getContext().put("goodToSellList", goodList);
			ActionContext.getContext().put("TypeList", goodTypeList);
			ActionContext.getContext().put("goodMessage", "δ���ҵ�������Ҫ����Ʒ����������������Ϣ����");
		}
		return "findgoodbytypeidsuccess";
	}
	
	//��������Ʒ����ҳ
	public String toAddGood(){
		List goodTypeList=shopService.findGoodType();
		System.out.println("shopaction..152line:goodTypeList..."+goodTypeList);
		ActionContext.getContext().put("goodTypeList", goodTypeList);
		return "toaddgoodsuccess";
	}
	//������Ʒ
	public String publish() throws IOException{
		String path=ServletActionContext.getServletContext().getRealPath("/images");
		File filepath=new File(path);
		String filename=System.currentTimeMillis()+uploadFileName;
		FileUtils.copyFile(upload, new File(filepath,filename));
		Goods good=new Goods();
		//һ�Զ�Ĵ���
		Users u=new Users();
		u.setUserId(findByuserid);
		good.setUsers(u);
		System.out.println("shopaction..120line:findByuserid"+findByuserid);
		Goodtype goodtype=new Goodtype();
//		goodtype.setTypeId(Integer.parseInt(typeId));
		goodtype.setTypeId(typeId);
		good.setGoodtype(goodtype);
		good.setGoodNum(Integer.valueOf(goodNum));
		good.setGoodPrice(Double.parseDouble(goodPrice));
		good.setGoodName(goodName);
		good.setGoodDescription(goodDescription);
		good.setGoodstate("yishangjia");
		//good.setGoodType(goodType);                         //������޸�
		good.setGoodPricture("\\"+filename);
		System.out.println("shopaction..130line:"+path+"\\"+filename);
		shopService.publishGood(good);
		return "publishsuccess";
	}

	//������˵�����Ʒ(�����û�id����Ʒ���ơ���Ʒ�ϼ�״̬��ѯ����ѯ�¼���Ʒ��ʧЧ��Ʒ��
	public String findUpAllGood(){
		int currpage=1;
		//System.out.println("shopaction160...pageBean:"+pageBean);
		if(pageBean!=null)
			currpage=pageBean.getCurrpage();
		List<Goods> goodList=null;		
		Goods g=new Goods();
		Users u=new Users();
		Goodtype goodtype=new Goodtype();
		goodtype.setTypeId(typeId);	
		g.setGoodtype(goodtype);
		System.out.println("shopaction175...findByuserid:"+findByuserid);
		u.setUserId(findByuserid);
		g.setGoodstate(goodState);
		g.setUsers(u);
		//������Ʒ������������Ʒ
		if(goodName!=null&&!goodName.equals(""))
			g.setGoodName(goodName);
		
		goodList=shopService.getUpGoodByConditionPage(g,currpage);
		pageBean=shopService.getPagerOfUpGoodByCondition(g);
		pageBean.setCurrpage(currpage);
		if(goodList==null||goodList.isEmpty()){
			ActionContext.getContext().put("goodMessage", "�����ڲ���������������Ʒ���������¼��ˣ�Ҳ�������ڱ���ˣ�");
		}
		ActionContext.getContext().put("findByuserid", g.getUsers().getUserId());
		ActionContext.getContext().put("goodState", goodState);
		ActionContext.getContext().put("goodList", goodList);
		
		if(goodState.equals("yixiajia"))
			return "finddowngoodsuccess";//��ת�¼�
		else if(goodState.equals("yishixiao"))
			return "findinvaildgoodsuccess";//��תʧЧ	
		else if(goodState.equals("daixiugai"))
			return "findtoupdategoodsuccess";
		else if(goodState.equals("daishenhe"))
			return "findtochecksuccess";
		else
			return "findupallgoodsuccess";//��ѯ�ϼ�
	}
	//��ѯ�ϼ���Ʒ�������������е��÷��ص�������ʾ
	public void findUpGood(Goods good){
		int currpage=1;		
		if(pageBean!=null)
			currpage=pageBean.getCurrpage();
		Goods g=new Goods();
		Users u=new Users();
		Goodtype goodtype=new Goodtype();
		goodtype.setTypeId(typeId);	
		g.setGoodtype(goodtype);
		u.setUserId(good.getUsers().getUserId());
		g.setUsers(u);
		if(goodState==null){
			g.setGoodstate(good.getGoodstate());
			goodState=good.getGoodstate();
		}
		else
			g.setGoodstate(goodState);
		
		System.out.println("shopaction218...goodState:"+g.getGoodstate());
		List<Goods> goodList=null;		
		goodList=shopService.getUpGoodByConditionPage(g,currpage);
		pageBean=shopService.getPagerOfUpGoodByCondition(g);
		pageBean.setCurrpage(currpage);
		
		System.out.println("shopaction219..."+g);
		System.out.println("shopaction220..."+g.getUsers().getUserId());
		
		ActionContext.getContext().put("findByuserid", g.getUsers().getUserId());
		ActionContext.getContext().put("goodState", goodState);
		ActionContext.getContext().put("goodList", goodList);
		
	}
	
	//��Ʒ�¼ܣ�ֱ���ϼ�(������Ʒ״̬)
	public String updateGoodState(){
		Goods g=shopService.findGoodByGoodId(findBygoodid);	
		g.setGoodstate(goodState);
		shopService.updateGood(g);
		System.out.println("��Ʒ״̬����1..."+findBygoodid+goodState);
		findUpGood(g);
		System.out.println("��Ʒ״̬����2..."+findBygoodid+goodState);
		if(goodState.equals("yixiajia"))
			return "updategoodtodownsuccess";
		else 
			return "updategoodtoupsuccess";
	}
		
	//��Ʒɾ��
	public String deleteGood(){
		Goods good=(Goods)shopService.findGoodByGoodId(findBygoodid);	
		shopService.deleteGood(good.getGoodId());	
		good.setGoodstate("yishangjia");
		findUpGood(good);
		return "deletegoodsuccess";
	}
	//���·�������Ʒ�༭
	public String updateGood() throws IOException{
		String path=ServletActionContext.getServletContext().getRealPath("/images");
		File filepath=new File(path);
		String filename=System.currentTimeMillis()+uploadFileName;
		FileUtils.copyFile(upload, new File(filepath,filename));
		Goods good=(Goods)shopService.findGoodByGoodId(Integer.parseInt(findgoodid));				
		good.setGoodPrice(Double.parseDouble(goodPrice));
		good.setGoodName(goodName);
		good.setGoodDescription(goodDescription);
		good.setGoodstate("daishenhe");	
		Goodtype goodtype=new Goodtype();
		goodtype.setTypeId(typeId);
		good.setGoodtype(goodtype);
		good.setGoodPricture("\\"+filename);
		System.out.println("shopaction..275line:typeId"+typeId+path+"\\"+filename);
		shopService.updateGood(good);
		findUpGood(good);
		return "updategoodsuccess";
	}
	
	
	//�༭֮ǰ��λ���༭ҳ����ʾ���޸���Ϣ
	public String toUpdateGood(){
		Goods g=(Goods)shopService.findGoodByGoodId(findBygoodid);
		List goodTypeList=shopService.findGoodType();
		System.out.println("shopaction..285line:goodTypeList..."+goodTypeList);
		ActionContext.getContext().put("good", g);
		ActionContext.getContext().put("goodTypeList", goodTypeList);
		return "toupdategoodsuccess";
	}

	//������˵���
	public String findUserGood(){
		int currpage=1;
		//System.out.println("shopaction160...pageBean:"+pageBean);
		if(pageBean!=null)
			currpage=pageBean.getCurrpage();
		List<Goods> goodList=null;		
		Goods g=new Goods();
		Users u=shopService.findUserById(findByuserid);
		Goodtype goodtype=new Goodtype();
		goodtype.setTypeId(typeId);	
		g.setGoodtype(goodtype);
		System.out.println("shopaction319...findByuserid:"+findByuserid);		
		g.setGoodstate(goodState);
		g.setUsers(u);
		//������Ʒ������������Ʒ
		if(goodName!=null&&!goodName.equals(""))
			g.setGoodName(goodName);
		goodList=shopService.getUpGoodByConditionPage(g,currpage);
		pageBean=shopService.getPagerOfUpGoodByCondition(g);
		pageBean.setCurrpage(currpage);
		
		System.out.println("users---"+ g.getUsers().getUserId()+g.getUsers().getUserName()+g.getUsers().getUserSchool()+g.getUsers().getUserImage());
		ActionContext.getContext().put("user", g.getUsers());
		ActionContext.getContext().put("goodState", goodState);
		ActionContext.getContext().put("goodList", goodList);
		
		return"findusergoodsuccess";
	}
	
	//������Ʒid������Ʒ����ת����Ʒ����ҳ
	public String tofindGoodByGoodId(){
		Goods g=(Goods)shopService.findGoodByGoodId(findBygoodid);
		System.out.println(g);
		Users u=g.getUsers();
		System.out.println("users---"+u.getUserId()+u.getUserName()+u.getUserSchool()+u.getUserImage());
		ActionContext.getContext().put("users", g.getUsers());
		ActionContext.getContext().put("good", g);
		return "tofindgoodbygoodidsuccess";
	}
	
	
	
}
