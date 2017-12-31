package com.wzsport.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wzsport.service.TokenService;
import com.wzsport.service.impl.TokenServiceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
* token拦截器,拦截带有token的请求，对其进行认证.
* 
* @author x1ny
* @date 2017年5月22日
*/
public class TokenInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LogManager.getLogger(TokenInterceptor.class);
	
	String logMsg = "";
	
	/**
	 * jwt加密、解密的密匙
	 */
	private final String KEY;
	
	public TokenInterceptor(@Value("${jwt.key}") String key) {		
		KEY = key;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getMethod().equals("OPTIONS")) {
			
		} else {
			String token = request.getHeader("Authorization");
			System.out.println("token: " + token);
            System.out.println("request.getRequestURI():" + request.getRequestURI() + " request.getMethod(): " + request.getMethod());
			if (token != null) {
	//			SecurityUtils.getSubject().login(new UsernamePasswordToken(token, ""));
				Claims claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
				logger.info(claims.toString());
			} else {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}
	
}
