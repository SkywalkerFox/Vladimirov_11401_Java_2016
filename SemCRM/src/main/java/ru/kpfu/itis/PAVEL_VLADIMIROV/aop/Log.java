package ru.kpfu.itis.PAVEL_VLADIMIROV.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Павел on 26.05.2016.
 */
public class Log {
    private final static Logger logger = Logger.getLogger(Log.class);

    @Before("execution(* ru.kpfu.itis.PAVEL_VLADIMIROV.*.*.*(..))")
    public void logMethodInvocationInService(JoinPoint joinPoint) {
        logger.info(new Date()
                + " Start invocation of method"
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with parameters:\n"
                + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("execution(* ru.kpfu.itis.PAVEL_VLADIMIROV.*.*.*(..))")
    public Object logToInfoTimeService(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object method = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long result = end - start;
        logger.info("End invocation of method: " + result + "ms");
        return method;
    }
}
