package com.wzsport.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.wzsport.service.CloudStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.UserMapper;
import com.wzsport.mapper.WechatUserMapper;
import com.wzsport.model.User;
import com.wzsport.model.UserExample;
import com.wzsport.model.UserExample.Criteria;
import com.wzsport.model.WechatUser;
import com.wzsport.model.WechatUserExample;
import com.wzsport.service.UserService;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

/**
* TokenService 实现类.
* 
* @author x1ny
* @date 2017年5月22日
*/
@Service
public class UserServiceImpl implements UserService {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WechatUserMapper wechatUserMapper;

    @Autowired
    private CloudStorageService cloudStorageService;

    /** The log msg. */
	private String logMsg = "";

	@Override
	public List<User> search(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		
		if (user.getUniversityId() != null) {
			criteria.andUniversityIdEqualTo(user.getUniversityId());
		}
		
		if (user.getUsername() != null) {
			criteria.andUsernameEqualTo(user.getUsername());
		}
		
		if (user.getOpenId() != null) {
			criteria.andOpenIdEqualTo(user.getOpenId());
		}
		
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int update(User user, ResponseBody resBody) {
		int result = userMapper.updateByPrimaryKeySelective(user);
		if (result == 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FOUND;
			logger.info(logMsg);
			return HttpServletResponse.SC_NOT_FOUND;
		} else {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.obj = user;
			resBody.statusMsg = logMsg; 
			
			return HttpServletResponse.SC_OK;
		}
	}
	
//    public User getUserById(long id) {
//        UserExample userExample = new UserExample();
//        userExample.createCriteria().andIdEqualTo(id);
//
//        List<User> userList = userMapper.selectByExample(userExample);
//
//        if (userList.size() == 0) {
//            throw new ObjectNotFoundException("找不到该学生信息哦！");
//        }
//
//		userList.set(0, this.getAvatarUrl(userList.get(0)));
//
//        return userList.get(0);
//    }
//
//    @Override
//    public int update(User user) {
//        return userMapper.updateByPrimaryKey(user);
//    }

    @Override
    public String getAvatarUrl(String fileName) {
		return this.cloudStorageService.generateUrl(fileName);
    }

	@Override
	public int create(WechatUser user) {
		int result = wechatUserMapper.insert(user);
		return result;
	}

	@Override
	public List<WechatUser> search(WechatUser user) {
		WechatUserExample example = new WechatUserExample();
		WechatUserExample.Criteria criteria = example.createCriteria();
		
		if (user.getId() != null) {
			criteria.andIdEqualTo(user.getId());
		}
		
		if (user.getOpenId() != null) {
			criteria.andOpenIdEqualTo(user.getOpenId());
		}
		
		if (user.getCity() != null) {
			criteria.andCityEqualTo(user.getCity());
		}
		
		if (user.getHeadimgurl() != null) {
			criteria.andHeadimgurlEqualTo(user.getHeadimgurl());
		}
		
		if (user.getNickname() != null) {
			criteria.andNicknameEqualTo(user.getNickname());
		}
		
		if (user.getProvince() != null) {
			criteria.andProvinceEqualTo(user.getProvince());
		}
		
		if (user.getSex() != null) {
			criteria.andSexEqualTo(user.getSex());
		}
		
		if (user.getUnionid() != null) {
			criteria.andUnionidEqualTo(user.getUnionid());
		}
		
		if (user.getUserId() != null) {
			criteria.andUserIdEqualTo(user.getUserId());
		}
		
		List<WechatUser> list = wechatUserMapper.selectByExample(example);
		return list;
	}

	@Override
	public int update(WechatUser user) {
		int result = wechatUserMapper.updateByPrimaryKeySelective(user);
		
		return result;
	}

	@Override
	public User read(Long id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
}
