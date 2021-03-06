package com.cn.pay.utils;

import lombok.Data;

/**
 * 包名称: com.cn.pay.utils
 * 类名称: AjaxResult.java
 * 类描述: 统一处理响应ajax请求返回数据
 * 作者：miao
 * 创建时间：2017年9月2日 上午11:18:20
 * 修改备注：一般返回三个值：是否成功、响应消息、错误编码、结果对象
 */
@Data
public class AjaxResult {

    private boolean success = Boolean.TRUE;    //是否成功（默认true）
    private String msg;                        //响应消息
    private Integer errorCode;                    //错误编码
    private Object resultData;                    //结果对象

    public AjaxResult(boolean success, Integer errorCode, String msg, Object resultData) {
        super();
        this.success = success;
        this.resultData = resultData;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public AjaxResult(boolean success, Object resultData) {
        super();
        this.success = success;
        this.resultData = resultData;
    }

    public AjaxResult(boolean success, String msg, Object resultData) {
        super();
        this.success = success;
        this.resultData = resultData;
        this.msg = msg;
    }

    public AjaxResult(boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }

    public AjaxResult(String errorMsg, Integer errorCode) {
        super();
        this.success = false;
        this.msg = errorMsg;
        this.errorCode = errorCode;
    }

    public AjaxResult(boolean success, String msg, Integer errorCode) {
        super();
        this.success = success;
        this.msg = msg;
        this.errorCode = errorCode;
    }

//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public Integer getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(Integer errorCode) {
//        this.errorCode = errorCode;
//    }
//
//    public Object getResultData() {
//        return resultData;
//    }
//
//    public void setResultData(Object resultData) {
//        this.resultData = resultData;
//    }

    @Override
    public String toString() {
        return "AjaxResult [success=" + success + ", msg=" + msg + ", errorCode=" + errorCode + "]";
    }
}
