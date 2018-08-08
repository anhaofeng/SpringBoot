package com.imooc.girl.utils;

import com.imooc.girl.model.GirlHbm;
import com.imooc.girl.model.Result;

public class ResultUtil {
  public  static Result success(Object object){
      Result result= new Result();
      result.setCode(0);
      result.setMsg("成功");
      result.setData(object);
      return  result;
  }
  public  static  Result error(Integer code, String msg, GirlHbm girlHbm){
      Result result =new Result();
      result.setCode(code);
      result.setMsg(msg);
      result.setData(girlHbm);
      return result;
  }
}
