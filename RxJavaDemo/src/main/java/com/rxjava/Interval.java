package com.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/12.
 */
public class Interval {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS).subscribe(ObserverHelper.getInstance().observer);
        ThreadHelper.sleep(1000*20);
    }
}
