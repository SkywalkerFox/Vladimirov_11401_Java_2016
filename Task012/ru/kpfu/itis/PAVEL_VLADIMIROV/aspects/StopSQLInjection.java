package ru.kpfu.itis.PAVEL_VLADIMIROV.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Павел on 25.03.2016.
 */
@Aspect
public class StopSQLInjection {
    @Around("execution(* ru.kpfu.itis.PAVEL_VLADIMIROV.models.Executor.execute(..)))")
    public Object stopInjection(ProceedingJoinPoint jp) throws Throwable {
        String string = (String) jp.getArgs()[0];
        if (string.matches(".+[+\\-=*]?(.+)?[&;]")){
            System.out.println("INJECTION!!!");
            return null;
        }
        return jp.proceed();
    }

}
