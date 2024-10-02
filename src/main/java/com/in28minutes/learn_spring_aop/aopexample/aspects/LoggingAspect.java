package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
    @Before("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - Method is called - {}", joinPoint);
    }

    @After("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint){
        logger.info("After Aspect - Method is called - {}, Arguments passed - {}", joinPoint, joinPoint.getArgs());
    }
    */
    @AfterReturning("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))")
    public void logMethodCallAfterReturning(JoinPoint joinPoint){
        logger.info("AfterReturning Aspect - Method is called - {}, Arguments passed - {}", joinPoint, joinPoint.getArgs());
    }

    @AfterThrowing(pointcut="execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))", throwing="exception")
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception){
        logger.info("Aspect AfterThrowing - Method called {} - Exception " + exception, joinPoint);
    }
}
