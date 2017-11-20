package com.rxjava;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

/**
 * Created by Administrator on 2017/11/11.
 */
public class Zip {

    public static void main(String[] args) {
        Observable.zip(getObservable(), getObservable2(), new BiFunction<String, String, String>() {
            public String apply(@NonNull String s, @NonNull String s2) throws Exception {
                return s+s2;
            }
        }).subscribe(new Observer<String>() {
            public void onSubscribe(@NonNull Disposable disposable) {

            }

            public void onNext(@NonNull String s) {
                System.out.println("s = " + s);
            }

            public void onError(@NonNull Throwable throwable) {

            }

            public void onComplete() {

            }
        });
    }


    public static Observable<String> getObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(@NonNull ObservableEmitter<String> observableEmitter) throws Exception {
                for (int i = 0; i < 10; i++) {
                    observableEmitter.onNext(String.valueOf(i));
                    Thread.sleep(3000);
                }
            }
        });
    }
    public static Observable<String> getObservable2() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(@NonNull ObservableEmitter<String> observableEmitter) throws Exception {
                for (int i = 0; i < 10; i++) {
                    observableEmitter.onNext(String.valueOf(i));
                    Thread.sleep(1000);
                }
            }
        });
    }
}
