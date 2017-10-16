package com.rxjava;

import io.reactivex.*;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Allen on 2017/9/21.
 */
public class MaybeRxJava {

    public static void main(String[] args) {
        while (true){
            Observable.create(new ObservableOnSubscribe<Integer>() {
                @Override
                public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                    System.out.println("createe = " );
                    e.onNext(7);
                    System.out.println("onNext = " );
                    e.onComplete();
                    System.out.println("onComplete = " );
                }
            }).subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.newThread()).doOnNext(new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) throws Exception {
                    System.out.println("doOnNext  integer = " + integer+"  =====" +Thread.currentThread().getName());

                }
            }).observeOn(Schedulers.newThread()).map(new Function<Integer, Integer>() {
                @Override
                public Integer apply(Integer integer) throws Exception {
                    System.out.println("map .apply"+"  =====" +Thread.currentThread().getName());
                    return integer*2;
                }
            }).observeOn(Schedulers.newThread()).subscribe(new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) throws Exception {
                    System.out.println("subscribe .accept"+integer+"  =====" +Thread.currentThread().getName());
                }
            });

            try {
                Thread.sleep(50*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
