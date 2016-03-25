package ru.kpfu.itis.PAVEL_VLADIMIROV.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import ru.kpfu.itis.PAVEL_VLADIMIROV.models.Photo;

/**
 * Created by Павел on 23.03.2016.
 */
@Aspect
public class DoNotAddImageWithEmptyURL {
    @Around("execution(* ru.kpfu.itis.PAVEL_VLADIMIROV.repository.PhotosRepository.addImage(..))")
    public Object stopAddition(ProceedingJoinPoint jp) throws Throwable {
        String url = ((Photo) jp.getArgs()[0]).getURL();
        if ("".equals(url)) {
            System.out.println("You can't add image with empty URL!");
            return null;
        }
        return jp.proceed();
    }
}
