package com.theoldzheng.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.25 16:05
 */
@Component //创建对象
@Aspect
public class PersonProxy {
    @Pointcut(value = "execution(* com.theoldzheng.config.Person.add(..))")
    public void pointCut(){
    }

    @Before(value = "pointCut()")
    public void add(){
        System.out.println("personProxy...");
    }
}
