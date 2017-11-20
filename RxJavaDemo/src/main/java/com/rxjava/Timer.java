package com.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/12.
 */
public class Timer {
    public static void main(String[] args) {
        Observable.timer(1, TimeUnit.SECONDS).subscribe(ObserverHelper.getInstance().observer);
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
