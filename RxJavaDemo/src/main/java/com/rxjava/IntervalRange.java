package com.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/12.
 */
public class IntervalRange {
    public static void main(String[] args) {
        Observable.intervalRange(1,20,1,1, TimeUnit.SECONDS).subscribe(ObserverHelper.getInstance().observer);
        ThreadHelper.sleep(50*1000);
    }
}
