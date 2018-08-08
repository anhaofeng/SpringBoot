package com.imooc.girl.action;

import com.imooc.girl.model.EssayHbm;
import com.imooc.girl.service.IessayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotControler {
    @Autowired
    private IessayService esseayService;

    @PostMapping(value = "/saveEssay")
    public EssayHbm  essayController(@RequestParam EssayHbm essayHbm){
        EssayHbm my =new EssayHbm();
        my.setTitle(essayHbm.getTitle());
        my.setText(essayHbm.getText());
        my.setType(essayHbm.getType());
        esseayService.save(my);
        return my;
    }
}
