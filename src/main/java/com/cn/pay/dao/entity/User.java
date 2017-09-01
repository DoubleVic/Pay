package com.cn.pay.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private Long id; //用户id
    private String userName;//用户名  登录
    private String password;//登录密码
    private String phoneNumber;//手机号码
    private String email;//用户邮箱
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;//修改时间
    private Boolean canCreateGroup;//是否可以创建团队
    private Integer accountType;//0:咪咕用户,1:外协人员
    private Integer accountState;//账号状态  0:正常  1:冻结状态
    private String roleKey; //角色key  如果为超级管理员 那么  返回super
    private String freezeReason;//冻结原因

}