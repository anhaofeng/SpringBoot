package com.imooc.girl.service;

import com.imooc.girl.model.GirlHbm;

public enum ResultEnum  {
UNKNOW_ERROR(-1,"未知错误"),
SUCCESS(0,"成功"),
PRIMARY_SCHOOL(100,"还在上小学吧"),
MIDDLE_SCHOOL(101,"你可能在上中学"),
;
private Integer code;
private  String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
