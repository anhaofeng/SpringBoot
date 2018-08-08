package com.imooc.girl.service;

import com.imooc.girl.model.GirlHbm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private IGirlService girlService;
    @Transactional
    public  void  insertTwo(){
        GirlHbm girlHbm =new GirlHbm();
        girlHbm.setCupSize("D");
        girlHbm.setAge(22);
        girlService.save(girlHbm);


        GirlHbm girlHbmB =new GirlHbm();
        girlHbmB.setCupSize("Ddasdsad");
        girlHbmB.setAge(90);
        girlService.save(girlHbmB);
    }

    public void  getAge(Integer id) throws  Exception{
    GirlHbm girlHbm=girlService.findOne(id);
     Integer age =girlHbm.getAge();
        System.out.println(age);
        System.out.println(girlHbm.toString());
     if (age<10){
    throw new  GirlException(ResultEnum.PRIMARY_SCHOOL,girlHbm);
     }
     else  if(age>10&&age<16){
         throw new GirlException(ResultEnum.MIDDLE_SCHOOL,girlHbm);
     }
    }
    public GirlHbm findOne(Integer id) {
        return girlService.findOne(id);
    }
}
