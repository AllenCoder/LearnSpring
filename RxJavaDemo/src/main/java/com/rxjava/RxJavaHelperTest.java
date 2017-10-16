package com.rxjava;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Allen on 2017/9/8.
 */
public class RxJavaHelperTest {
    public static void main(String[] args) {
//        final int[] a = {0};
         CompositeDisposable mCompositeDisposable = new CompositeDisposable();
        while (true) {
//            final int[] a = {0};
//            Observable.interval(1, TimeUnit.SECONDS).doOnNext(new Consumer<Long>() {
//                @Override
//                public void accept(Long aLong) throws Exception {
//                    a[0]++;
//                    System.out.println(a[0] + "=====" + System.currentTimeMillis());
//                    if (a[0] > 5) {
//                        /*
//                        *  it will throw error  i want to retry
//                        * */
//                        System.out.println("a[2] = " + a[2]);
//                    }
//                }
//            }).doOnError(new Consumer<Throwable>() {
//                @Override
//                public void accept(Throwable throwable) throws Exception {
//                    System.out.println("捕获到错误 = " + throwable.getLocalizedMessage());
//                }
//            }).doOnNext(new Consumer<Long>() {
//                @Override
//                public void accept(Long aLong) throws Exception {
//                    System.out.println("下一步动作 = " + aLong);
//                }
//            }).retry(new Predicate<Throwable>() {
//                @Override
//                public boolean test(Throwable throwable) throws Exception {
//                    a[0] = 0;
//                    System.out.println(" reset Observable");
//                    return true;
//                }
//            }).doOnError(new Consumer<Throwable>() {
//                @Override
//                public void accept(Throwable throwable) throws Exception {
//                    System.out.println("捕获到错误 = " + throwable);
//                }
//            }).subscribe(new io.reactivex.functions.Consumer<Long>() {
//                @Override
//                public void accept(Long aLong) throws Exception {
//                    System.out.println("RxJavaHelperTest.accept");
//                }
//            }, new io.reactivex.functions.Consumer<Throwable>() {
//                @Override
//                public void accept(Throwable throwable) throws Exception {
//                    System.out.println("e.getLocalizedMessage() = " + throwable.getLocalizedMessage());
//                    a[0] = 0;
//
//                }
//            });

//            Flowable.create(new FlowableOnSubscribe<Integer>() {
//                @Override
//                public void subscribe(FlowableEmitter<Integer> e) throws Exception {
//                    System.out.println("RxJavaHelperTest.onNext");
//                    e.onNext(7);
//                    System.out.println("RxJavaHelperTest.subscribe");
//                    e.onComplete();
//                    System.out.println("RxJavaHelperTest.onComplete");
//                }
//            }, BackpressureStrategy.BUFFER).doOnNext(new Consumer<Integer>() {
//                @Override
//                public void accept(Integer integer) throws Exception {
//                    System.out.println("RxJavaHelperTest.doOnNext 1 accept"+integer);
//                }
//            }).doOnNext(new Consumer<Integer>() {
//                @Override
//                public void accept(Integer integer) throws Exception {
//                    System.out.println("RxJavaHelperTest.doOnNext 2 accept"+integer);
//                }
//            }).doOnComplete(new Action() {
//                @Override
//                public void run() throws Exception {
//                    System.out.println("RxJavaHelperTest.run");
//                }
//            }).map(new Function<Integer, Integer>() {
//                @Override
//                public Integer apply(Integer integer) throws Exception {
//                    System.out.println("RxJavaHelperTest.map 1 accept"+integer);
//                    return 7;
//                }
//            }).subscribe();
//
//            Disposable disposable= Maybe.create(new MaybeOnSubscribe<Integer>() {
//                @Override
//                public void subscribe(MaybeEmitter<Integer> e) throws Exception {
//                    System.out.println("e = " + e);
//                    e.onSuccess(7);
//                    System.out.println("RxJavaHelperTest.subscribe");
//                    e.onComplete();
//                }
//            }).subscribeOn(Schedulers.io()).doOnSuccess(new Consumer<Integer>() {
//                @Override
//                public void accept(Integer integer) throws Exception {
//                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
//                    Thread.sleep(2000);
//                }
//            }).subscribe(new Consumer<Integer>() {
//                @Override
//                public void accept(Integer integer) throws Exception {
//                    System.out.println("integer = " + integer);
//                }
//            });

            mCompositeDisposable.add(Flowable.create(new FlowableOnSubscribe<Integer>() {
                @Override
                public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                    System.out.println("  e.onNext(7) start " );
                    e.onNext(7);
                    e.onComplete();
                }
            }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io()).doOnNext(new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) throws Exception {
                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                    for (int i = 0; i < 10*10000; i++) {

                    }
                }
            }).doOnComplete(new Action() {
                @Override
                public void run() throws Exception {
                    System.out.println("RxJavaHelperTest.run doOnComplete");
                }
            }).subscribe());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mCompositeDisposable.clear();
            System.out.println("取消订阅");
            try {
                Thread.sleep(50 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void testMap(){
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {

            }
        }, BackpressureStrategy.BUFFER).doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return null;
            }
        }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

            }
        }).subscribe();
    }

    // 获得当天0点时间
    public static long getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();


    }

    // 获得当天24点时间
    public static long getTimesnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime().getTime();
    }

    // 获得昨天0点时间
    public static long etYesterdaymorning() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getTimesmorning() - 3600 * 24 * 1000);
        return cal.getTime().getTime();
    }

    public String getTodayData() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
