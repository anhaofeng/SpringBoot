package com.springboot.springboot2.config;

import com.springboot.springboot2.model.User;
import com.springboot.springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 路由器函数配置
 */
@Configuration
public class RouterFunctionConfiguration {


@Bean
@Autowired
public RouterFunction<ServerResponse> personFindAll(UserRepository userRepositoryr){

   return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
            request ->{
//       返回所有的用户对象
                Collection <User> users=userRepositoryr.findAll();
//                Mono<ServerResponse> mono=null;
                Flux<User> userFlux=Flux.fromIterable(users);
                return  ServerResponse.ok().body(userFlux,User.class);
           });
}
}
