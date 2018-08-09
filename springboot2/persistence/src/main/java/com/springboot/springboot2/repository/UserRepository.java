package com.springboot.springboot2.repository;

import com.springboot.springboot2.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link  Repository}
 */
//类似于Dao 的存储仓库
@Repository
public class UserRepository {
    //采用内存型的存储方式

    private final ConcurrentMap<Integer ,User> repository= new ConcurrentHashMap<>() ;
    private  final  static AtomicInteger idGenerator= new AtomicInteger();

    public boolean  save(User user){
    boolean success=false;
    Integer id =idGenerator.incrementAndGet();
        user.setId(id);
        return  repository.put(id,user)==null;
    }
    public Collection<User> findAll(){
        return  repository.values();
    }
}
