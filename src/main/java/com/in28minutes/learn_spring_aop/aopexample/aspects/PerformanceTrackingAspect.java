package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Around("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTimeMillis = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long stopTimeMillis = System.currentTimeMillis();

        logger.info("Aspect Around - Method {} execution took {} milliseconds", proceedingJoinPoint, (stopTimeMillis - startTimeMillis));

        return returnValue;
    }
}
