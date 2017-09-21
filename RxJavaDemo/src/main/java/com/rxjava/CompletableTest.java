package com.rxjava;


import io.reactivex.*;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.completable.CompletableFromAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Allen on 2017/8/28.
 */
public class CompletableTest {
    private static int count = 0;

    public static void main(String[] args) {
        final boolean[] isComplete = {false};
//        while (!isComplete[0]){
//
//
//        getUploadData().subscribe(new Subscriber<List<String>>() {
//            private Subscription subscription;
//            @Override
//            public void onSubscribe(Subscription s) {
//                subscription =s;
//                s.request(128);
//            }
//
//            @Override
//            public void onNext(List<String> strings) {
////                System.out.println("strings.toString() = " + strings.toString() +"---"+System.currentTimeMillis());
//                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                subscription.request(1);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println("t.getLocalizedMessage() = " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("subscription = " + subscription);
//                isComplete[0] =true;
//
//            }
//        });
//        }
//
//        System.out.println("\"结束任务\" = " + "结束任务");
//        while (true){
//            upload().subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe(new Consumer<List<String>>() {
//                @Override
//                public void accept(List<String> strings) throws Exception {
//                    System.out.println("strings.toString() = " + strings.toString() +"---"+System.currentTimeMillis());
//                }
//            });
//        }
//        String s =Flowable.zip(getUploadData(), getUploadData(), new BiFunction<List<String>, List<String>,String>() {
//            @Override
//            public String apply(List<String> t1, List<String> t2) throws Exception {
//                return "S";
//            }
//        },false ).blockingFirst();
//            int[] i = new int[1];
//            ObservableRepeat.create(new ObservableOnSubscribe<String>() {
//                @Override
//                public void subscribe(ObservableEmitter<String> e) throws Exception {
//                    i[0]++;
//                    for (int j = 0; j < 100; j++) {
//                        e.onNext(j+"");
//                    }
//
//
//                    System.out.println("i[0] = " + i[0]);
//                }
//            }).repeatUntil(new BooleanSupplier() {
//                @Override
//                public boolean getAsBoolean() throws Exception {
//                    System.out.println("getAsBoolean---");
//                    count++;
//                    if (count == 3)
//                        return true;
//                    else
//                        return false;
//                }
//            }).subscribe(new Consumer<String>() {
//                @Override
//                public void accept(String s) throws Exception {
//                    System.out.println("s = " + s);
//                }
//            });
        double s = 0;
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 100000 * 1000; i++) {
            s += calculateDistance(0.966d, 0.669d, 0.996d, 0.669d);
        }
        System.out.println(System.currentTimeMillis());


    }


    public static double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        /*
            Haversine formula:
            A = sin²(Δlat/2) + cos(lat1).cos(lat2).sin²(Δlong/2)
            C = 2.atan2(√a, √(1−a))
            D = R.c
            R = radius of earth, 6371 km.
            All angles are in radians
            */

        double deltaLatitude = Math.toRadians(Math.abs(latitude1 - latitude2));
        double deltaLongitude = Math.toRadians(Math.abs(longitude1 - longitude2));
        double latitude1Rad = Math.toRadians(latitude1);
        double latitude2Rad = Math.toRadians(latitude2);

        double a = Math.pow(Math.sin(deltaLatitude / 2), 2) +
                (Math.cos(latitude1Rad) * Math.cos(latitude2Rad) * Math.pow(Math.sin(deltaLongitude / 2), 2));

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return 6371 * c * 1000; //Distance in meters

    }

    public static Flowable<List<String>> getUploadData() {
        System.out.println("CompletableTest.getUploadData");
        return Flowable.create(new FlowableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(FlowableEmitter<List<String>> flowableEmitter) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list.add("上游发送数据 " + i);

                }
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                flowableEmitter.onNext(list);
                flowableEmitter.onComplete();
            }
        }, BackpressureStrategy.BUFFER);
    }

    public static String formatDateTime(long dateTime, String format) {
        Date date = new Date(dateTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Observable<List<String>> upload() {
        return Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> observableEmitter) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add("上游发送数据 " + i);
                }

                observableEmitter.onNext(list);
            }
        });
    }


    public static Completable updateActivityModel(final String s) {
        return new CompletableFromAction(new Action() {
            @Override
            public void run() throws Exception {
                if (s == "9") {
                    throw new NullPointerException();
                } else {
                    System.out.println("s = " + s);
                }
            }
        });
    }

    public CompletableFromAction updateUploadStatus(final String startTime) {
        return new CompletableFromAction(new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("startTime = " + startTime);

            }
        });
    }
}
