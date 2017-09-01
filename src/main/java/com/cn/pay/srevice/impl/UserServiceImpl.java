package com.cn.pay.srevice.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import com.cn.pay.dao.entity.User;
import com.cn.pay.dao.inf.IUserDao;
import com.cn.pay.srevice.inf.IUserService;
import com.cn.pay.utils.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * 项目名称:
 * 包名称: com.migu.cms.service.impl
 * 类名称: UserServiceImpl.java
 * 类描述:  user业务逻辑实现层
 * 作者：  miao
 * 创建时间： 2017年5月9日 上午11:21:16
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService<User> {

	@Resource
	private IUserDao userDao;

	private static Logger sLogger = LoggerFactory.getLogger(UserServiceImpl.class);

	public AjaxResult login(User user, String password) throws Exception {
		return null;
	}

	public AjaxResult createUser(User user) throws Exception {
		return null;
	}

	public User getByname(HashMap<String, Object> map) throws Exception {
		return null;
	}

	public User getByUserId(Long userId) throws Exception {
		return null;
	}

	public AjaxResult freezeOrThawingUsers(String[] ids, Integer accountState, String freezeReason) throws Exception {
		return null;
	}

	public AjaxResult deleteByIds(String[] ids, Long userId) throws Exception {
		return null;
	}

	public void updatePwd(User user) throws Exception {

	}

	public AjaxResult resetPwd(User user) throws Exception {
		return null;
	}
}
