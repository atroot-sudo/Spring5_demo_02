package com.theoldzheng.MyProxy.DAO;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:动态代理的实现
 * <p>
 * UserDAOImpl实现UserDAO接口，UserDAOImpl需要增加功能，使用代理对象的方法 <p>
 * 利用Proxy代理类的静态方法newProxyInstance()创建被代理类的对象；
 * 静态方法中的三个参数分别为  类加载器、要实现功能修改的类的接口的数组(可以是多个接口)、InvocationHandler接口的实现类对象(匿名内部类、实现类对象)
 *
 * 在实现类或者匿名内部类中实现重写invoke()方法，在invoke方法中实现对功能的增强代码如下面的实现类中
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.25 9:17
 */
public class MyProxy {
    public static void main(String[] args) {


//        UserDAO userDAO = (UserDAO) Proxy.newProxyInstance(MyProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });

        Class[] interfaces = {UserDAO.class};
        UserDAOImpl userDAOImpl = new UserDAOImpl();

        UserDAO userDAO = (UserDAO) Proxy.newProxyInstance(MyProxy.class.getClassLoader(), interfaces, new UserDAOProxy(userDAOImpl));
        int result = userDAO.add(1, 2);
        System.out.println(result);


        System.out.println(userDAO.update("5"));

    }
}

class UserDAOProxy implements InvocationHandler {
    //利用有参构造的方式，对obj进行初始化(需要那个代理对象被创建，就把哪个对象传进来) 对应上边第三个参数
    private Object obj;

    public UserDAOProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在方法执行之前
        System.out.println("在需要更新的方法之前执行:  " + method.getName());

        //方法调用
        Object res = method.invoke(obj, args);


        //在方法执行之后
        System.out.println("在需要更新的方法之后:  ");


        return res;
    }
}