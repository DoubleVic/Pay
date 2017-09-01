package com.cn.pay.srevice.inf;

import com.cn.pay.dao.entity.User;
import com.cn.pay.utils.AjaxResult;

import java.util.HashMap;

/**
 * 包名称: com.cn.pay.srevice.inf
 * 类名称: IUserService.java
 * 类描述: 用户逻辑层接口
 * 作者：miao
 * 创建时间： 2017年9月3日 上午11:19:47
 */
public interface IUserService<User> extends IBaseService<User> {

    AjaxResult login(User user, String password) throws Exception;

    AjaxResult createUser(User user) throws Exception;

    // 根据用户登录时输入的账号 查询用户信息
    User getByname(HashMap<String, Object> map) throws Exception;

    // 获取用户单一信息,不包含角色信息等
    User getByUserId(Long userId) throws Exception;

    // 根据id批量冻结/解冻用户
    AjaxResult freezeOrThawingUsers(String[] ids, Integer accountState, String freezeReason) throws Exception;

    // 根据id批量删除用户
    AjaxResult deleteByIds(String[] ids, Long userId) throws Exception;

    // 更新密码
    void updatePwd(User user) throws Exception;

    // 找回密码 重新设置密码
    AjaxResult resetPwd(User user) throws Exception;

}
