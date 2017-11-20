package com.rxjava;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/12.
 */
public class Never {
    public static void main(String[] args) {
        Observable.never().subscribe(ObserverHelper.getInstance().observer);
    }
}
