
package com.web.shrio;

import com.web.model.Role;
import com.web.model.User;
import com.web.service.MenuService;
import com.web.service.RoleService;
import com.web.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.config.ReflectionBuilder;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 * @program:product
 * @description:
 * @author:YangXiaoJiao
 * @create:2019-01-16 18:47
 */


public class MyRealm extends AuthorizingRealm{

 /*@Autowired
    private PermissionService permissionService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;*/

    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
/**
     *  授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User u = (User)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        List<Role> roles = roleService.getRoleNameByUserName(u.getUserName());
        Set<String> roleSet = new HashSet<>() ;
        Set<String> theUrls = new HashSet<>();
        for (Role role : roles) {
            roleSet.add(role.getRoleName());
            List<String> theUrl = menuService.getTheUrl(role.getRoleName());
            for (String s : theUrl) {
                theUrls.add(s);
            }
        }
        info.setRoles(roleSet);
        /**根据用户ID查询权限（permission），放入到Authorization里.*/
        info.setStringPermissions(theUrls);
        return info;

    }
    // 认证处理
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        //通过表单接收的用户名
        String username=token.getUsername();
        System.out.println("username:"+username);
        if(username!=null&&!"".equals(username)){
            User user=userService.selectUserByName(username);
            if(user!=null){
                return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
            }
        }
        System.out.println("认证失败");
        return null;
    }
}

