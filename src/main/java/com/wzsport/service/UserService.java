package com.wzsport.service;

import java.util.List;

import com.wzsport.model.User;
import com.wzsport.model.WechatUser;
import com.wzsport.util.ResponseBody;

/**
* user service interface.
* 
* @author x1ny
* @date 2017年5月22日
*/
public interface UserService {

	List<User> search(User user);

	@SuppressWarnings("rawtypes")
	int update(User user, ResponseBody resBody);
	
	User read(Long id);
	
//    int update(User user);

    String getAvatarUrl(String fileName);
    
    int create(WechatUser user);
    
    int update(WechatUser user);

    List<WechatUser> search(WechatUser user);

}
