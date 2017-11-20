package com.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/11/12.
 */
public class Just {
    public static void main(String[] args) {
        Observable.just(1,2,3).subscribe(consumer);
    }

    public static Consumer<Integer> consumer = o -> System.out.println("o = " + o);
}
