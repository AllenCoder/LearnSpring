package com.rxjava;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import org.reactivestreams.Subscription;

/**
 * Created by Administrator on 2017/8/26.
 */
public class FlowableTest {
    private static CompositeDisposable compositeDisposable = new CompositeDisposable();

    public static void main(String[] args) {
//        getObserable("1");
//        getObserable("2");
        System.out.println("Flowable测试");
        getFlowable("1");
        getFlowable("2");
        getFlowable("3");
    }

    private static void getFlowable(String s) {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<String> flowableEmitter) throws Exception {
                System.out.println("上游发送事件" + s);
                flowableEmitter.onNext(s);

            }
        }, BackpressureStrategy.BUFFER).map(new Function<String, String>() {
            @Override
            public String apply(@NonNull String s) throws Exception {
                System.out.println("开始转换事件" + s);
                return s;
            }
        }).subscribeWith(new FlowableSubscriber<String>() {
            @Override
            public void onSubscribe(@NonNull Subscription subscription) {
                subscription.request(128);
            }

            @Override
            public void onNext(String s) {
                System.out.println("下游处理事件  s = " + s);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });


    }

    private static void getObserable(String a) {
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext(a);
                System.out.println(">>>>>>");
            }
        });
        observable.safeSubscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {

            }

            @Override
            public void onNext(@NonNull String o) {
                System.out.println("下游收到事件" + o);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
