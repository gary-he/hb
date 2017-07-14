package cn.tarena.ht.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.tarena.ht.tool.Md5Password;

public class AuthCredential extends  SimpleCredentialsMatcher{

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//获取用户
		UsernamePasswordToken loginToken=(UsernamePasswordToken) token;
		//获取密码并将密码进行加密
		String userName=loginToken.getUsername();
		String password=String.valueOf(loginToken.getPassword());//返回char数组，利用工具转成string
		//加密密码
		String md5Password=Md5Password.getMd5HashPassword(password, userName);
		//回存密码
		loginToken.setPassword(md5Password.toCharArray());
		return super.doCredentialsMatch(loginToken, info);
	}
	
	
}
