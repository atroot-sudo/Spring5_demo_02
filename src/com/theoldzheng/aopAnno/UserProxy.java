package com.theoldzheng.aopAnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description:代理类
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.25 12:23
 */

@Component //创建对象
@Aspect  //生成代理对象
@Order(value = 5)
public class UserProxy {
    //共同切入点的抽取  声明为Pointcut其他注解的值可以直接进行调用
    @Pointcut(value = "execution(* com.theoldzheng.aopAnno.User.add(..))")
    public void pointcutDemo() {
    }

    //五个通知类型
    //前置通知
    @Before(value = "pointcutDemo()")
    public void before() {
        System.out.println("before executing...");

    }

    //后置通知
    @AfterReturning(value = "execution(* com.theoldzheng.aopAnno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning executing...");
    }

    //最终通知
    @After(value = "execution(* com.theoldzheng.aopAnno.User.add(..))")
    public void after() {
        System.out.println("after executing...");
    }

    //环绕通知
    @Around(value = "execution(* com.theoldzheng.aopAnno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("环绕之前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");

    }

    //异常通知
    @AfterThrowing(value = "execution(* com.theoldzheng.aopAnno.User.add(..))")
    public void exception() {
        System.out.println("afterThrow executing...");
    }
}
