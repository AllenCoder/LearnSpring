package com.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

import java.util.concurrent.TimeUnit;

/** 
 * Simple pass-thru event bus with error handling and reconnect. 
 */ 
public class EventBus { 
 
    public static void main(String[] args) {
        MyEventBus bus = new MyEventBus();
 
        bus.toObservable().filter(EventBus::IS_NUMBER).forEach(n -> System.out.println("Got number: " + n));
        bus.toObservable().filter(EventBus::IS_STRING).forEach(System.out::println);
 
        // something that can fail (it assumes Integer)
        while (true) {
            Observable.interval(1, TimeUnit.SECONDS).doOnError(e -> System.err.println(e.getMessage()))
                    .retry() // reconnects to bus if an error occurs
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(Long s) throws Exception {
                            System.out.println("s = " + s);
                            if (s > 10) {
                                throw new Exception("sssd");
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            System.out.println("throwable = " + throwable);
                        }
                    });

            try {
                Thread.sleep(50*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        bus.send(1);
//        System.out.println("-----------------------");
//        bus.send(11);
//        System.out.println("-----------------------");
//        bus.send(28);
//        System.out.println("-----------------------");
//        bus.send("hello");
//        System.out.println("-----------------------");
//        bus.send(5);
//        System.out.println("-----------------------");
//        bus.send("world");
//        System.out.println("-----------------------");
 
    } 
 
    public static boolean IS_NUMBER(Object o) {
        return o instanceof Number;
    } 
 
    public static boolean IS_STRING(Object o) {
        return o instanceof String;
    } 
 
    public static class MyEventBus { 
        private final PublishSubject<Object> bus = PublishSubject.create();
 
        /** 
         * If multiple threads are going to emit events to this then it must be made thread-safe like this instead: 
         */ 
        //        private final Subject<Object, Object> bus = new SerializedSubject<Object, Object>(PublishSubject.create()); 
 
        public void send(Object o) {
            bus.onNext(o);
        } 
 
        public Observable<Object> toObservable() {
            return bus;
        } 
    } 
} 