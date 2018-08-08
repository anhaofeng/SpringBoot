package com.imooc.girl.action;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
   private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.imooc.girl.action.GirlController.*(..))")
    public  void  log(){

    }
    @Before("log()")
    public  void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
          HttpServletRequest request=  attributes.getRequest();
        logger.info("method={}",request.getMethod());
        logger.info("url={}",request.getRequestURL());
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("classMethod={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("arg={}",joinPoint.getArgs());
    }
    @After("log()")
    public  void  doAfer(){
        logger.info("______________");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public  void afterReturn(Object object){
   logger.info("return={}",object.toString());
    }

}
