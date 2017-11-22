package com.cn.pay.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private Long id; //用户id
    private String userName;//用户名
    private String password;//登录密码
    private String phoneNumber;//手机号码
    private String email;//用户邮箱


}