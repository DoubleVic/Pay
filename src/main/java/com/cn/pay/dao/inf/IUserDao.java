package com.cn.pay.dao.inf;

import com.cn.pay.dao.IBaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


/**
 * 包名称: com.migu.cms.dao.inf
 * 类名称: IUserDao.java
 * 类描述: 用户持久层接口
 * 作者：miao
 * 创建时间：2017年5月9日 上午11:22:17
 */

@Repository
public interface IUserDao<User> extends IBaseDao<User> {

    // 新增用户_角色中间表
    void insertUserRole(HashMap<String, Object> map);

    // 根据id删除 用户_角色中间表
    void deleteRoleUser(Long userId);

    // 用户登录
    User login(HashMap<String, Object> map);

    // 获取用户单一信息,不包含角色
    User getByUserId(Long userId);

    // 批量删除用户
    void deleteByIds(@Param(value = "ids") String[] ids) throws Exception;

    // 批量删除用户角色中间表
    void deleteRoleUsers(@Param(value = "ids") String[] ids) throws Exception;

    // 获取用户仓库权限
    Integer getUsrPerInPro(HashMap<String, Object> map) throws Exception;

    // 获取用户在仓库中的权限
    User getUserProPermissions(HashMap<String, Object> map) throws Exception;

    // 批量删除用户_工作组中间表
    void deleteGroupUsers(@Param(value = "ids") String[] ids) throws Exception;

}
