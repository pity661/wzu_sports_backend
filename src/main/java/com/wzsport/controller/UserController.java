package com.wzsport.controller;

import com.wzsport.service.CloudStorageService;
import com.wzsport.util.HttpRequestUtil;
import com.wzsport.util.PathUtil;
import com.wzsport.util.PropertyUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.model.User;
import com.wzsport.model.WechatUser;
import com.wzsport.service.UserService;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User Controller.
 * 
 * @author x1ny
 * @date 2017年5月26日
 */
@Api(tags = "User相关接口")
@RestController()
@RequestMapping(value = "/users", produces = "application/json;charset=UTF-8")
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/** The res body. */
//	@SuppressWarnings("rawtypes")
//	private ResponseBody resBody;
//	private int status;

	@Autowired
	private CloudStorageService qiniuService;

//	static final private String APP_SECRET = "56c7ff2a20c91dacc6a714ed5e4eb4fe";//欧旭
//	static final private String APP_SECRET = "6e37d78de49f1b7c625f132b1fe5059c";//微信测试号
	static final private String APP_SECRET = "f550760f9ca91f471dc33814c031ab50";//光氧运动

//	static final private String APP_ID = "wx2c8f990778df47a3";//欧旭
//	static final private String APP_ID = "wx7d248efdb1dc6821";//微信测试号
	static final private String APP_ID = "wx8e8661fdfc08da2d";//光氧运动

	/**
	* 
	*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "搜索用户信息", notes = "搜索用户信息，根据universityId、studentId和openid来进行搜索，")
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ResponseEntity<?> show(@ApiParam("学校Id，必选") @RequestParam Long universityId,
			@ApiParam("学号，可选，但是不能和openid同时为空") @RequestParam(required = false) String studentId,
			@ApiParam("openid，可选，但是不能和studentId同时为空") @RequestParam(required = false) String openid) {
		//不能两个同时为空
		if (studentId == null && openid == null) {
			return null;
		}
		
		User user = new User();
		user.setUniversityId(universityId);
		
		if (studentId != null) {
			user.setUsername(studentId);
		}
		
		if (openid != null) {
			user.setOpenId(openid);
		}
		
		ResponseBody resBody = new ResponseBody<User>();
		
		List<User>list = userService.search(user);
		if (list.size() > 0) {
			resBody.statusMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			resBody.obj = list;
			return ResponseEntity.status(HttpServletResponse.SC_OK).body(resBody); 
		} else {
			resBody.statusMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FOUND;
			return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(resBody); 
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "更新用户信息", notes = "更新用户信息")
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> update(@ApiParam("用户Id") @PathVariable Long id,
			@ApiParam("密码") @RequestParam(required = false) String password,
			@ApiParam("头像") @RequestParam(required = false) MultipartFile mFile,
			@ApiParam("openid") @RequestParam(required = false) String openid) throws IOException {
		// TODO 这个地方要判断open id，去数据库检查，匹配用户，才可以修改
		int result = -1;
		
		ResponseBody resBody = new ResponseBody<User>();
		
		WechatUser wUser = new WechatUser();
		
		User user = userService.read(id);
		if (user == null) {
			resBody.statusMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FOUND;
			resBody.obj = null;
			return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(resBody);
		}		
		
		//openid如果是空的话，不允许修改
		if (user.getOpenId().equals("")) {
			if (openid == null) {
				return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
			} else {//未绑定状态
				User tempUser = new User();
				tempUser.setOpenId(openid);
				List<User> list = userService.search(tempUser);
				if (list.size() > 0) {
					return ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).build();
				}
				
				wUser.setOpenId(openid);
				wUser = userService.search(wUser).get(0);
				
				user.setOpenId(openid);
				user.setAvatarUrl(wUser.getHeadimgurl());
				
				wUser.setUserId(user.getId());
				result = userService.update(wUser);
				if (result == 0) {
					logger.error("没有成功更新用户微信信息， wUser: " + wUser);
					return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
				}
			}
		} else {
			if (!user.getOpenId().equals(openid)) {
				return ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).build();
			}
		}
		
		if (password != null) {
			if (user.getOpenId().equals("")) {
	//			resBody.statusMsg = HttpStatus.UNAUTHORIZED.getReasonPhrase();
				resBody.statusMsg = "您的学号尚未绑定公众号，无法修改密码";
				resBody.obj = null;
				return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(resBody);
			} else {
				user.setPassword(password);
			}
		}
		
		if (mFile != null) {
			String avatar = null;		
			avatar = uploadFile(mFile);
			user.setAvatarUrl(avatar);
		}
		
		result = userService.update(user, resBody);
		
//		user.setAvatarUrl(userService.getAvatarUrl(user.getAvatarUrl()));

		return ResponseEntity.status(result).body(resBody);
	}
	
	public String uploadFile(MultipartFile mFile) throws IOException {

		String fileName = UUID.randomUUID().toString();
		String filePath = PathUtil.getImagePath() + fileName;
		File file = new File(filePath);

		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdir();
		}

		if (!file.exists()) {
			file.createNewFile();
		}

		mFile.transferTo(file);

		this.qiniuService.setBucket(PropertyUtil.getProperty("qiniu.wzsport_avatar_bucket"));
		this.qiniuService.uploadImage(filePath, fileName);
		file.delete();
		
		return fileName;

//		user.setAvatarUrl(fileName);
//		this.userService.update(user);
//
//		user = this.userService.generateAvatarUrl(user);
//
//		this.resBody = new ResponseBody<User>();
//		this.resBody.statusMsg = "头像上传成功了！";
//		this.resBody.obj = user;
//		this.status = 200;
//		return ResponseEntity.status(status).body(resBody);

	}

	// @ApiOperation(value = "修改个人密码", notes = "修改个人密码")
	// @RequestMapping(value = "/password", method = RequestMethod.POST)
	// public ResponseEntity<?> updatePwd(
	// @ApiParam("用户ID")
	// @RequestParam("userId") long userId,
	// @ApiParam("密码")
	// @RequestParam("password") String password
	// ) {
	// User user;
	// try {
	// user = this.userService.getUserById(userId);
	// } catch (ObjectNotFoundException e) {
	// this.resBody = new ResponseBody<Integer>();
	// this.resBody.statusMsg = e.getMessage();
	// this.resBody.obj = 1000;
	// this.status = 404;
	// return ResponseEntity.status(status).body(resBody);
	// }
	//
	// user.setPassword(password);
	// this.userService.update(user);
	//
	// this.resBody = new ResponseBody<Integer>();
	// this.resBody.statusMsg = "修改密码成功！";
	// this.resBody.obj = 0;
	// this.status = 200;
	// return ResponseEntity.status(status).body(resBody);
	//
	// }

	// 将路径解析成键值对数组
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map<String, String> parseQueryString(String str) {
		String[] paramArr = str.split("&");
		Map map = new HashMap();
		for (String param : paramArr) {
			String[] arr = param.split("=");
			if (arr.length > 1) {
				map.put(arr[0], arr[1]);
			}
		}
		return map;
	}

	// 参考：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842。
	@ApiOperation(value = "微信回调接口", notes = "微信回调接口")
	@RequestMapping(value = "/wechatAuth", method = RequestMethod.GET)
	// redirect_uri/?code=CODE&state=STATE
	public void wechatAuth(@ApiParam("微信code") @RequestParam(required=false) String code, HttpServletRequest request,
			HttpServletResponse response) {
		String page = "";

		String url = "https://api.weixin.qq.com/sns/oauth2/access_token";

		String params = "appid=";
		params += APP_ID + "&secret=";
		params += APP_SECRET + "&code=";
		params += code + "&grant_type=authorization_code";

		String result = HttpRequestUtil.sendGet(url, params);
		logger.error("获取openid result: " + result);
		if (result == null) {
			logger.error("获取openid失败");
			return;
		} else {
//			logger.error("获取openid result: " + result);
//			result = result.substring(4);//TODO test 代码
			logger.error("获取openid result: " + result);
			JSONObject obj = new JSONObject(result);
			String openid = null;
			String accessToken = null;
			try {
				//null{"access_token":"KymDdolRKjHhmfDzKD28ciXPFH0Z1ajTxHVIMKcaaUewLUl-pmFBEV5mvgGgJVCsZheFIvwi1LEB2N-FDW2Alg","expires_in":7200,"refresh_token":"OubNchftrS23cZEaAjOT2WhKN2qGAu9E3w1iGB-2GNPe7sgD3T4sNpjQ7EapmbjvZR10mYVKbfmPtlslY6yBlw","openid":"oKsKOvwMBayOSUZJuOiav1H-nt7o","scope":"snsapi_userinfo"}
				openid = obj.getString("openid");
				logger.debug("openid: " + openid);
				
				accessToken = obj.getString("access_token");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("获取openid和accessToken失败，e: " + e.getMessage() + ", result: " + result);
				return;
			}
			
			url = "https://api.weixin.qq.com/sns/userinfo";
			params = "access_token=";
			params += accessToken + "&openid=";
			params += openid + "&lang=zh_CN";
			
			result = HttpRequestUtil.sendGet(url, params);
			if (result == null) {
				logger.error("微信请求获取用户信息失败");
				return;
			} 
			
			logger.error("获取用户信息 result: " + result);
//			result = result.substring(4);//TODO test 代码
			obj = new JSONObject(result);
			
			WechatUser user = new WechatUser();
			try {
				user.setOpenId(obj.getString("openid"));
				
				List<WechatUser> list = userService.search(user);
				if (list.size() == 0) {
					logger.error("list == null");
					user.setCity(obj.getString("city"));
					user.setHeadimgurl(obj.getString("headimgurl"));
					user.setNickname(obj.getString("nickname"));
					user.setProvince(obj.getString("province"));
					user.setSex((byte) obj.getInt("sex"));
					user.setUserId((long) 0);
					user.setUnionid("");//TODO 
	//				user.setUnionid(obj.getString("unionid"));//TODO test时候不给
					
					//存入数据库
					logger.error("creat user: " + user.toString());
					userService.create(user);
				} else {
					logger.error("list != null, list.size: " + list.size());
					user.setId(list.get(0).getId());
					user.setCity(obj.getString("city"));
					user.setHeadimgurl(obj.getString("headimgurl"));
					user.setNickname(obj.getString("nickname"));
					user.setProvince(obj.getString("province"));
					user.setSex((byte) obj.getInt("sex"));
					user.setUserId((long) 0);
					user.setUnionid("");//TODO 
	//				user.setUnionid(obj.getString("unionid"));//TODO test时候不给
					
					//存入数据库
					logger.info("update user: " + user.toString());
					userService.update(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("获取微信数据失败，e: " + e.getMessage());
				return;
			}
			
			page = request.getParameter("page");
			String openidQuery = "openid=" + openid;
			try {
				URI inUri = new URI(page);
				String query = inUri.getQuery();
				if (query == null) {
					query = openidQuery;
				} else {
					query += "&" + openidQuery;
				}
				
				URI outUri = new URI(inUri.getScheme(), inUri.getAuthority(),
		                inUri.getPath(), query, inUri.getFragment());
				page = outUri.toString();
				logger.error("拼接跳转url，page: " + page);
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
				logger.error("拼接跳转url失败，e: " + e1.getMessage());
				return;
			}
//			page += "?openid=" + openid;
//			Map map = parseQueryString(request.getQueryString());
//			String[] arr = java.net.URLDecoder.decode(map.get("page").toString()).split("[?]");
//			System.out.println("getWechatToken arr:" + arr);
//			
//			if (arr.length > 1) {
//				page += arr[0];
//				page += "?openid=" + openid;
//				if (arr[1].split("#")[0] != "") {
//					page += "&";
//				}
//				page += arr[1];
//			} else {
//				if (arr[0].split("#").length > 1) {
//					page += arr[0].split("#")[0];
//					page += "?openid=" + openid;
//					page += "#";
//					page += arr[0].split("#")[1];
//				} else {
//					page += arr[0];
//					page += "?openid=" + openid;
//				}
//			}

//			page = page.replace("&#", "#");
//			System.out.println("getWechatToken page: " + page);

//			page = "www.sina.com.cn";// TODO test
			try {
				response.sendRedirect(page);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("发送跳转url失败，e: " + e.getMessage());
				return;
			}

		}
	}

	
}
