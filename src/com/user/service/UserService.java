package com.user.service;

import java.util.List;
import com.entity.Users;

/**
 * 	�û�ҵ���ӿ�
 * 
 * */
public interface UserService {

	//��¼
	//public List<Users> login(Users u);
	Users login(Users user);
	Users findById(int userId);
	void  updateUser(Users user);
}
