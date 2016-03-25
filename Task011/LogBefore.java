package ru.kpfu.itis.PAVEL_VLADIMIROV.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Павел on 22.03.2016.
 */
@Aspect
public class LogBefore {
    @Before("execution(* ru.kpfu.itis.PAVEL_VLADIMIROV.repository.ArticlesRepository.*(..))")
    public void loggingArticles(JoinPoint joinPoint) {
        System.out.println("method " + joinPoint.getSignature().getName() + " is running");
    }
}
