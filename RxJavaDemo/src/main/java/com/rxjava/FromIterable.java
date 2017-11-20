package com.rxjava;

import io.reactivex.Observable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/12.
 */
public class FromIterable {
    public static void main(String[] args) {
        Map<String,String> list = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            list.put(" key "+String.valueOf(i)," value "+String.valueOf(i));
        }
        Iterator<Map.Entry<String, String>> iterator = list.entrySet().iterator();
        Observable.fromIterable(new Iterable<Map.Entry<String,String>>() {
            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return iterator;
            }
        }).subscribe(ObserverHelper.getInstance().observer);
    }
}
