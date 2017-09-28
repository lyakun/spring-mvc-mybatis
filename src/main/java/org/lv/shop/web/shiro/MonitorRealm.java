package org.lv.shop.web.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.lv.shop.entity.menu.Menu;
import org.lv.shop.entity.user.RoleR;
import org.lv.shop.entity.user.User;
import org.lv.shop.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：MonitorRealm    
 * 类描述：自定义realm    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月13日 上午10:51:41    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月13日 上午10:51:41    
 * 修改备注：       
 * @version
 */
public class MonitorRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取用的id
		String userId = ((User)principals.getPrimaryPrincipal()).getUserId();
		//查询对应用户的角色集合
		List<RoleR> roleList=userService.getRoleList(userId);
		List<Menu> menuList=null;
		List<String> roleAllList = new ArrayList<String>();
		List<String> resourceList = new ArrayList<String>();
		for (RoleR role : roleList) {
			roleAllList.add(role.getRoleId()+"");
			//查询对应角色的对应权限集合
			menuList=userService.getMenuList(role.getRoleId());
			for (Menu menu : menuList) {
				if(StringUtils.isNotBlank(menu.getPermission())){
					resourceList.add(menu.getPermission());
				}
			}
		}
		//赋角色
		info.addRoles(roleAllList);
		//赋权限
		info.addStringPermissions(resourceList);
		return info;
	}
	/**
	 * 认证回调函数, 登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName= (String)token.getPrincipal();
		User user=userService.getUserByUserName(userName);
		if(user==null){
			 throw new AuthenticationException();
		}
		//验证用户
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPassWord(),getName());
		return info;
	}
}
