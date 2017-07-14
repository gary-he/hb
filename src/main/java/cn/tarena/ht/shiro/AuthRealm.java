package cn.tarena.ht.shiro;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

public class AuthRealm extends AuthorizingRealm{
	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		Subject subject=SecurityUtils.getSubject();
		User user=(User) subject.getPrincipal();
		String userId=user.getUserId();
		
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		String role=userService.findUserRoleById(userId);
		info.addStringPermission(role);
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//realm获取用户真实信息原材料，提供给安全中心校验
		//获取用户名
		UsernamePasswordToken loginToken=(UsernamePasswordToken) token;
		String userName=loginToken.getUsername();
		//获取用户真实信息
		User user =userService.findUserByUserName(userName);
		//封装用户真实信息
		/*
		 * SimpleAuthenticationInfo(principal, credentials, realmName)
		 *principal		真实对象
		 *credentials	真实密码
		 *realmName		当前的realm 
		 */
		AuthenticationInfo info=new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		return info;
	}
	
	



	
	
	
}
