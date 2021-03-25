package com.theoldzheng.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Description:利用配置类实现完全注解开发
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.25 15:50
 */
@Configuration //设置该类为配置类
@ComponentScan(basePackages = {"com.theoldzheng.config"})  //设置开启扫描 数组形式
@EnableAspectJAutoProxy(proxyTargetClass = true)  //设置代理(默认情况下为true)
public class aopConfig {
}
