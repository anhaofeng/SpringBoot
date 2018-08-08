package com.imooc.girl.service;

import com.imooc.girl.model.EssayHbm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IessayService extends JpaRepository<EssayHbm,Integer> {
}
