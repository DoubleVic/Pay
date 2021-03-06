package com.cn.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.pay.dao.entity.User;
import com.cn.pay.srevice.inf.IUserService;
import com.cn.pay.utils.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * 项目名称:
 * 包名称: com.migu.cms.webapi.controller
 * 类名称: UserController.java
 * 类描述: TODO用户控制层
 * 作者：  ling
 * 创建时间： 2017年5月9日 上午11:13:34
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger sLogger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService iUserService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult createUser(@RequestBody User user) {
        AjaxResult ajaxResult = null;
        sLogger.info("创建用户");
        return new AjaxResult(true,"SUCCESS");
    }


}
