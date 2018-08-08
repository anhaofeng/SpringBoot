package com.imooc.girl.service;

import com.imooc.girl.model.GirlHbm;

public class GirlException extends  RuntimeException {
private  Integer code;
private GirlHbm girlHbm;

    public GirlException(ResultEnum resultEnum,GirlHbm girlHbm) {
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
        this.girlHbm=girlHbm;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public GirlHbm getGirlHbm() {
        return girlHbm;
    }

    public void setGirlHbm(GirlHbm girlHbm) {
        this.girlHbm = girlHbm;
    }
}
