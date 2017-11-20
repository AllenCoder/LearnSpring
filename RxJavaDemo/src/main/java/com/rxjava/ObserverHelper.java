package com.rxjava;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/11/12.
 */
public class ObserverHelper<T> {
    private volatile static ObserverHelper observerHelper;

    private ObserverHelper() {
    }

    public static ObserverHelper getInstance() {
        if (observerHelper == null) {
            synchronized (ObserverHelper.class) {
                if (observerHelper == null) {
                    observerHelper = new ObserverHelper();
                }
            }

        }
        return observerHelper;
    }

    public  Observer<T> observer = new Observer<T>() {
        @Override
        public void onSubscribe(@NonNull Disposable disposable) {
            System.out.println("disposable = " + disposable);
        }

        @Override
        public void onNext(@NonNull T t) {
            System.out.println("t = " + t);
        }

        @Override
        public void onError(@NonNull Throwable throwable) {
            System.out.println("throwable = " + throwable);
        }

        @Override
        public void onComplete() {
            System.out.println("ObserverHelper.onComplete");
        }
    };
}
