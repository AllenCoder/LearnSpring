package com.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Predicate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Allen on 2017/9/8.
 */
public class RxJavaHelperTest {
    public static void main(String[] args) {
//        RxJavaHelper.background(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("执行 psvm");
//            }
//        });
//        System.out.println("UUID.randomUUID().toString() = " + UUID.fromString("uudi").toString());
        System.out.println("getTimesmorning()+ \"---\"+getTimesnight() = " + getTimesmorning() + "---" + getTimesnight());
//        final int[] a = {0};
        while (true) {
//            Observable.interval(1, TimeUnit.SECONDS).retry(new Predicate<Throwable>() {
//                @Override
//                public boolean test(Throwable throwable) throws Exception {
//                    System.out.println("RxJavaHelperTest.test");
//                    return true;
//                }
//            }).subscribe(new Observer<Long>() {
//                @Override
//                public void onSubscribe(Disposable disposable) {
//
//                }
//
//                @Override
//                public void onNext(Long aLong) {
//
//                }
//
//                @Override
//                public void onError(Throwable throwable) {
//                    a[0]=0;
//                    System.out.println("RxJavaHelperTest.onError");
//                    System.out.println(throwable.getLocalizedMessage()+"----" +System.currentTimeMillis());
//                }
//
//                @Override
//                public void onComplete() {
//                    System.out.println("RxJavaHelperTest.onComplete");
//                }
//            });
            final int[] a = {0};
            Observable.interval(1, TimeUnit.SECONDS).doOnNext(new io.reactivex.functions.Consumer<Long>() {
                @Override
                public void accept(Long aLong) throws Exception {
                    a[0]++;
                    System.out.println(a[0] + "=====" + System.currentTimeMillis());
                    if (a[0] > 5) {
                        /*
                        *  it will throw error  i want to retry
                        * */
                        System.out.println("a[2] = " + a[2]);
                    }
                }
            }).retry(new Predicate<Throwable>() {
                @Override
                public boolean test(Throwable throwable) throws Exception {
                    a[0] = 0;
                    System.out.println(" reset Observable");
                    return true;
                }
            }).doOnError(new io.reactivex.functions.Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    System.out.println("throwable = " + throwable);
                }
            }).subscribe(new io.reactivex.functions.Consumer<Long>() {
                @Override
                public void accept(Long aLong) throws Exception {
                    System.out.println("RxJavaHelperTest.accept");
                }
            }, new io.reactivex.functions.Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    System.out.println("e.getLocalizedMessage() = " + throwable.getLocalizedMessage());
                    a[0] = 0;

                }
            });
//            Observable.create(new ObservableOnSubscribe<String>() {
//                @Override
//                public void subscribe(ObservableEmitter<String> e) throws Exception {
//                    for(int i = 0; i<= 3 ;i++){
//                        if(i == 2){
//                            e.onError(new Exception("出现错误了"));
//                        }else{
//                            e.onNext(i+"");
//                        }
//                        try{
//                            Thread.sleep(1000);
//                        }catch (Exception ex){
//                            ex.printStackTrace();
//                        }
//                    }
//
//                    e.onComplete();
//                }
//            })

//            FlowableNever.interval(1, TimeUnit.SECONDS)
////                .retry(3)    //最多让被观察者重新发射数据3次
//                    .retry(new Predicate<Throwable>() {
//                        @Override
//                        public boolean test(@NonNull Throwable throwable) throws Exception {
//                            System.out.println("RxJavaHelperTest.test");
//                            //最多让被观察者重新发射数据3次，但是这里返回值可以进行处理
//                            //返回假就是不让重新发射数据了，调用观察者的onError就终止了。
//                            //返回真就是让被观察者重新发射请求
//                            return true;
//                        }
//                    })
//                    .subscribe(new io.reactivex.functions.Consumer<Long>() {
//                        @Override
//                        public void accept(Long s) throws Exception {
//                            System.out.println("RxJavaHelperTest.accept" + s);
//                            a[0]++;
//                            System.out.println(a[0] + "=====" + System.currentTimeMillis());
//                            if (a[0] > 5) {
//                                System.out.println("a[2] = " + a[2]);
//                            }
//                        }
//                    }, new io.reactivex.functions.Consumer<Throwable>() {
//                        @Override
//                        public void accept(Throwable throwable) throws Exception {
//                            System.out.println("RxJavaHelperTest.accept" + throwable.getLocalizedMessage());
//                        }
//                    });

//            Observable<Long> longObservable = Observable.interval(1, TimeUnit.SECONDS).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
//                @Override
//                public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
//                    return Observable.interval(1, TimeUnit.SECONDS);
//                }
//            });
//            longObservable.subscribe(new io.reactivex.functions.Consumer<Long>() {
//                @Override
//                public void accept(Long aLong) throws Exception {
//                    System.out.println("RxJavaHelperTest.accept" + aLong);
//                    a[0]++;
//                    System.out.println(a[0] + "=====" + System.currentTimeMillis());
//                    if (a[0] > 5) {
//                        System.out.println("a[2] = " + a[2]);
//                    }
//                }
//            }, new io.reactivex.functions.Consumer<Throwable>() {
//                @Override
//                public void accept(Throwable throwable) throws Exception {
//                    System.out.println("RxJavaHelperTest.accept");
//                }
//            });
            try {
                Thread.sleep(50 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


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
