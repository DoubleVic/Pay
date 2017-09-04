package com.cn.pay.controller;

import com.cn.pay.common.ResultCode;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    @Autowired
    private IUserService<User> iUserService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult createUser(@RequestBody User user) {
        AjaxResult ajaxResult = null;
        try {
            user.setCreateTime(new Date());
            iUserService.createUser(user);
            ajaxResult = new AjaxResult(true, ResultCode.SUCCESS);
            sLogger.info(ResultCode.SUCCESS);
        } catch (Exception e) {
            sLogger.error("createUser：{}", e);
        }
        return ajaxResult;
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getById(@RequestBody User user) {
        AjaxResult ajaxResult = null;
        try {
            User userResult = iUserService.getById(user.getId());
            ajaxResult = new AjaxResult(true, ResultCode.SUCCESS);
            ajaxResult.setResultData(userResult);
        } catch (Exception e) {
            sLogger.error("queryById：{}", e);
        }
        return ajaxResult;
    }

    @RequestMapping(value = "getByWhere", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getByWhere(@RequestBody User user) {
        AjaxResult ajaxResult = null;
        try {
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("userName", user.getUserName());
            params.put("id", user.getId());
            List<User> user1 = iUserService.getByWhere(params);
            ajaxResult = new AjaxResult(true, ResultCode.SUCCESS);
            ajaxResult.setResultData(user1);
        } catch (Exception e) {
            sLogger.error("getByWhere：{}",e);
        }
        return ajaxResult;
    }

}
