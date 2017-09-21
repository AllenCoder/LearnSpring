package com.rxjava;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Allen on 2017/9/8.
 */
public class RxJavaHelper {
    public static Disposable background(final Runnable runnable){
        return new CompletableFromAction(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("runnable = " + runnable);
                Thread.sleep(3*1000);
                runnable.run();
            }
        }).subscribeOn(Schedulers.trampoline()).subscribe();
    }
}
