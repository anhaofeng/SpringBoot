package com.imooc.girl.service;

import com.imooc.girl.model.GirlHbm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGirlService extends JpaRepository<GirlHbm,Integer> {
     List<GirlHbm> findByAge(Integer age);
}
