package com.example;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class ControllerAOP {
	

    private Logger logger = LoggerFactory.getLogger(ControllerAOP.class);

    @Pointcut("execution(public * com.example.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        logger.info("=STARTING==: " + df.format(now));
        logger.info("-URL-------: " + request.getRequestURL().toString());
        logger.info("-METHOD----: " + request.getMethod());
        logger.info("-IP--------: " + request.getRemoteAddr());
        logger.info("-CLASS-----: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("-ARGS------: " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
    	if(ret != null){
    		logger.info("-RESPONSE--: " + ret.toString());
    	}else{
    		logger.info("-RESPONSE--: null");
    	}
        logger.info("=ENDING====: " + df.format(now));
        
    }
    
//    @Around("webLog()")
//    public void around(ProceedingJoinPoint pjp) throws Throwable {
//        // 处理完请求，返回内容
//    	try{
//    		pjp.proceed();
//    	}catch(Exception ex){
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date now = new Date();
//            logger.info("TIME_END============: " + df.format(now));
//            throw ex;
//    	}
//    }
    
    
    /**
     *  声明ex时指定的类型会限制目标方法必须抛出指定类型的异常  
     *  此处将ex的类型声明为Throwable，意味着对目标方法抛出的异常不加限制  
     * @param ex
     */
    @AfterThrowing(throwing="ex", pointcut="webLog()")  
    public void doAfterThrowing(Throwable ex)  
    {  
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date now = new Date();
	    logger.info("-Exception-: " + ex.getMessage());
	    logger.info("=ENDING====: " + df.format(now));
    }  
    
    

}
