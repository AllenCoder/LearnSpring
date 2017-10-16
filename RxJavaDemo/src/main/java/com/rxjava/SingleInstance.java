package com.rxjava;

/**
 * Created by Allen on 2017/10/13.
 */
public enum SingleInstance {
    INSTANCE;

    public SingleInstance getInstance() {
        //增加这个方法是让别人明白怎么使用，因为这种实现方式
        //还比较少见，限于java 1.5之后的版本
        return INSTANCE;
    }

    public void print() {
        System.out.println("hello,world");
    }

}
