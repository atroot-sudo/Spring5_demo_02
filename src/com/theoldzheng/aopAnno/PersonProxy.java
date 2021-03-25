package com.theoldzheng.aopAnno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.25 14:29
 */
@Component
@Aspect
@Order(value = 4)  //当有多个代理类进行功能增强的时候那么就可以涉及到 设置优先级的问题 数字越小 优先级越高
public class PersonProxy {

    @Before(value = "execution(* com.theoldzheng.aopAnno.User.add(..))")
    public void before(){
        System.out.println("personBefore priority!");
    }
}
