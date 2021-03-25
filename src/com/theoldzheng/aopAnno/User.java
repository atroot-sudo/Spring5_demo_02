package com.theoldzheng.aopAnno;

import org.springframework.stereotype.Component;

/**
 * Description:被代理类
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.25 11:30
 */
@Component
public class User {
    public void add(){
        System.out.println("add executing......");

    }
}
