package com.theoldzheng.MyProxy.DAO;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.25 8:40
 */
public class UserDAOImpl implements UserDAO{
    @Override
    public int add(int a, int b) {
        System.out.println("add() executing...");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update executing...");
        return id + ":update";
    }
}
