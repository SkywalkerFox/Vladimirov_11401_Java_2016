package ru.kpfu.itis.PAVEL_VLADIMIROV.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Павел on 24.03.2016.
 */
@Aspect
public class DoNotSetInvalidEmail {
    @Around("execution(* ru.kpfu.itis.PAVEL_VLADIMIROV.models.User.setEmail(..))")
    public Object checkEmail(ProceedingJoinPoint jp) throws Throwable {
        String email = (String) jp.getArgs()[0];
        Pattern pattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            System.out.println("INVALID EMAIL");
            return null;
        }

        System.out.println("TOP");

        return jp.proceed();

    }
}
