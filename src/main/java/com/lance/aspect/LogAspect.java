package com.lance.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {
//    private static final log log = logFactory.getlog(LogAspect.class);

    @Before("execution(* com.lance.web.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering method: {}", joinPoint.getSignature());
    }

    @Around("@annotation(com.lance.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("ready to log execution time");
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startTime;
        log.info("{} executed in {}ms", joinPoint.getSignature(), executionTime);

        return proceed;
    }



    @AfterReturning(pointcut = "execution(* com.lance.web.*.*(..)))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Leaving method: {}. Return value: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.lance.web.*.*(..)))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception thrown in method: {}", joinPoint.getSignature(), e);
    }

    @After("execution(* com.lance.web.*.*(..)))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("Method {} finished execution", joinPoint.getSignature());
    }
}
