package com.wzsport.shiro;

import java.util.Date;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

/**
* 根据Token进行Shiro认证的Realm类
* 
* @author x1ny
* @date 2017年5月22日
*/
public class TokenRealm extends AuthorizingRealm{

	/**
	 * jwt加密、解密的密匙
	 */
	private final String KEY;
	
	public TokenRealm(@Value("${jwt.key}") String key) {		
		KEY = key;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Claims claims = (Claims) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		@SuppressWarnings("unchecked")
		//添加角色
		List<String> roles = (List<String>) claims.get("roles");
		for(String role:roles) {
			authorizationInfo.addRole(role);
		}
		
		return authorizationInfo;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//解析token获取Claims
		Claims claims = Jwts.parser()
				.setSigningKey(KEY)
				.parseClaimsJws((String)token.getPrincipal())
				.getBody();
		
		//验证过期时间
		if(claims.getExpiration() == null || claims.getExpiration().before(new Date())){
			throw new ExpiredJwtException(null, claims, "token is expired");
		}
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(claims, token, getName());
		return authenticationInfo;
	}
	
	@Override
	public String getName() {
		return "TokenRealm";
	}
}
