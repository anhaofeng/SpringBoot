package com.imooc.girl.action;

import com.imooc.girl.model.GirlModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
//@RequestMapping(value = "/hello")
public class HelloController {
    @Autowired
    private GirlModel girlModel;
//    @RequestMapping(value = "{id}/say",method = RequestMethod.GET)
//    @GetMapping(value = "/say/{id}")
    @GetMapping(value = "/say")
    public  String  say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid){
//        return girlModel.getCupSize();
//        return "index";
 return  "id:"+myid;
    }

}
