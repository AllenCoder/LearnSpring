package com.rxjava;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/12.
 */
public class Error {
    public static void main(String[] args) {
        Observable.error(new Throwable("测试异常")).subscribe(ObserverHelper.getInstance().observer);
    }
}
