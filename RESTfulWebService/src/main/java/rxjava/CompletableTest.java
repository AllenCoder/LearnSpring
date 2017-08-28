package rxjava;

import hello.Upload;
import io.reactivex.*;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by Allen on 2017/8/28.
 */
public class CompletableTest {
    public static void main(String[] args) {

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
//                System.out.println("strings.toString() = " + strings.toString() +"---"+System.currentTimeMillis());
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
//            }
//        });
//
//        System.out.println("\"结束任务\" = " + "结束任务");
        upload().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) throws Exception {
                System.out.println("strings.toString() = " + strings.toString() +"---"+System.currentTimeMillis());
            }
        });
        

    }
    public static Flowable<List<String>> getUploadData() {
        System.out.println("CompletableTest.getUploadData");
        return Flowable.create(new FlowableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(FlowableEmitter<List<String>> flowableEmitter) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i <5; i++) {
                    list.add("上游发送数据 " + i);
                    flowableEmitter.onNext(list);
                }
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

            }
        }, BackpressureStrategy.BUFFER).observeOn(Schedulers.io()).subscribeOn(Schedulers.io());
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
