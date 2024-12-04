package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    


    @Before("execution(* com.example.service.*.*(..))")
    public void logBeforeMethodExecution() {
        log.info("Method in service is about to be called");
    }

    @After("execution(* com.example.service.*.*(..))")
    public void logAfterMethodExecution() {
        log.info("Method in service has been called");
    }

    @Around("execution(* com.example.service.*.*(..))")
    public Object logAroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info("Method execution start: " + joinPoint.getSignature());
        
        try {
            Object result = joinPoint.proceed();
            long timeTaken = System.currentTimeMillis() - startTime;
            log.info("Method execution end: " + joinPoint.getSignature() + " took " + timeTaken + " ms");
            return result;
        } catch (Exception e) {
            log.error("Method execution encountered an error: " + joinPoint.getSignature(), e);
            throw e;
        }
    }
}