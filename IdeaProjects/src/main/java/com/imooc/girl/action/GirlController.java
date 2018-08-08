package com.imooc.girl.action;

import com.imooc.girl.model.GirlHbm;
import com.imooc.girl.model.Result;
import com.imooc.girl.service.GirlService;
import com.imooc.girl.service.IGirlService;
import com.imooc.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static Logger logger= LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlService serviceGirl;
    @Autowired
    private IGirlService girlService;
    //获得所有数据
    @RequestMapping(value = "/getGirl")
    public List <GirlHbm> getGirl(){
        return  girlService.findAll();
    }
//    //添加一个girl
//    @PostMapping(value = "addGirl")
//    public  GirlHbm addGirl(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
//        GirlHbm  girlHbm =new GirlHbm();
//        girlHbm.setAge(age);
//        girlHbm.setCupSize(cupSize);
//        return  girlService.save(girlHbm);
//    }
//添加一个girl
@PostMapping(value = "addGirl")
public  Result<GirlHbm> addGirl(@Valid GirlHbm girlHbm , BindingResult bindingResult){
 if (bindingResult.hasErrors()){
     return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage(),null);
 }
    return   ResultUtil.success( girlService.save(girlHbm));
}
    //通过ID查询一个GIRL
    @GetMapping(value="/findOne/{id}")
    public GirlHbm findOne(@PathVariable("id") Integer id){
        return girlService.findOne(id);
    }
//    更改一个girl的信息
    @PutMapping(value="/updateGirl/{id}")
    public GirlHbm updateGirl(@PathVariable("id") Integer id,
                              @RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        GirlHbm  girlHbm =new GirlHbm();
        girlHbm.setAge(age);
        girlHbm.setCupSize(cupSize);
        return  girlService.save(girlHbm);
    }
//    根据id删除girl
    @DeleteMapping(value = "/deleteGirl/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
         girlService.delete(id);
    }
//    根据年龄查询girl
    @GetMapping(value = "/findByAge/{age}")
    public List<GirlHbm> findByAge(@PathVariable("age") Integer age){
        return  girlService.findByAge(age);
    }
//    事物的操作
    @PostMapping(value = "/insertTwo")
    public  void insert(){
        serviceGirl.insertTwo();
    }
    @GetMapping(value = "/getAge/{id}")
    public  void getAge(@PathVariable("id") Integer id ) throws Exception{
     serviceGirl.getAge(id);
    }
}


