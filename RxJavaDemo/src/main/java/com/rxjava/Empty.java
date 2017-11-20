package com.rxjava;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/12.
 */
public class Empty {
    public static void main(String[] args) {

        Observable.empty().subscribe(ObserverHelper.getInstance().observer);
    }

}
