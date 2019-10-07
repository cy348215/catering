package com.catering.shiro;

import com.catering.pojo.StorePermission;
import com.catering.service.MerchantService_xpy;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 自定义的realm策略
 */
public class MyRealm extends AuthorizingRealm {
//    注入业务实现
    @Autowired
    private MerchantService_xpy merchantService;

//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        if (!StringUtils.isEmpty(primaryPrincipal)){
            Subject subject= SecurityUtils.getSubject();//主体对象
            String username=(String)subject.getPrincipal();//获取用户身份信息
            List<StorePermission> permission = merchantService.findPermissionById(merchantService.findMerchantByName(username).getId());
//          权限去重
            Set<String> perms = new HashSet<>();
            for (StorePermission perm: permission){
                String controller = perm.getUrl();
                perms.add(controller);
            }
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.setStringPermissions(perms);
            return simpleAuthorizationInfo;

        }
        return null;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //  获取用户身份
        Object principal = token.getPrincipal();
        if (!StringUtils.isEmpty(principal)){
            String userName = (String) principal;
            String password = merchantService.findMerchantByName(userName).getPassword();
            ByteSource byteSource = ByteSource.Util.bytes("abc");
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,password,byteSource,getName());
            return info;
        }
        return null;
    }
}
