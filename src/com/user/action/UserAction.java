package com.user.action;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.Admin;
import com.entity.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.user.service.UserService;

public class UserAction extends ActionSupport{
	private String userName;
	private String userPassword;
	//ע��Service����
	private UserService userService;
	private Integer finduserid;
	private String uploadContentType;
	private String uploadFileName;
	private File upload;
	
	
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

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserService getUserService() {
		return userService;
	}

	public Integer getFinduserid() {
		return finduserid;
	}

	public void setFinduserid(Integer finduserid) {
		this.finduserid = finduserid;
	}
//  <Context crossContext="true" debug="0" docBase="E:\Workspaces\MyEclipse 2017 CI\SSH\.metadata\.me_tcat85\webapps\shop_manage\images" path="" reloadable="true"/> 
	//	//Action�еĹ���
	//�û��ĵ�¼
	public String login(){
		Users user=new Users();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		System.out.println("login...userName:"+userName);
		Users existuser=userService.login(user);
		if(existuser==null){
			System.out.println("��¼ʧ��");
			this.addActionError("�û������ڣ�");
			return INPUT;
		}else{
			System.out.println("��¼�ɹ�");
			ActionContext.getContext().getSession().put("loginuser", existuser);
			//ActionContext.getContext().put("loginuser", existuser);
			return SUCCESS;
		}
	}
	//��ǰ�˵õ�finduserid֮���ѯ���û���Ϣ
	public String findUser(){
		System.out.println("ua.finduser..60:finduserid"+finduserid);
		//int userid = Integer.parseInt(finduserid);//stringת��Ϊint
		Users finduser=userService.findById(finduserid);
		ActionContext.getContext().getSession().put("loginuser", finduser);
		return "findusersuccess";
	}
    public String update() throws IOException{   	
    	System.out.println("userName..update84:"+userName);
		System.out.println("uploadFileName:"+uploadFileName);
		System.out.println("upload:"+upload);
		String path=ServletActionContext.getServletContext().getRealPath("/images");
		File filepath=new File(path);
		String filename=System.currentTimeMillis()+uploadFileName;
		System.out.println("filename:"+filename);
		FileUtils.copyFile(upload, new File(filepath,filename));
		Users u=new Users();
		u.setUserId(finduserid);
		u.setUserName(userName);
		u.setUserPassword(userPassword);
	    u.setUserImage("\\"+filename);
		System.out.println(path+"\\"+filename);	
		System.out.println("ua:line124..finduserid:"+finduserid);
		userService.updateUser(u);
		u=userService.findById(finduserid);
		ActionContext.getContext().getSession().put("loginuser", u);
    	return "updatesuccess";
    }
	

}
