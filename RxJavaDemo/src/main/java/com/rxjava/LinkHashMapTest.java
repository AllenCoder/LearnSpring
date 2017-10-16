package com.rxjava;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Created by Allen on 2017/10/10.
 */
public class LinkHashMapTest {
   static class A {
        int a = 0;

        A(int a) {
            this.a = a;
        }
    }


    public static void main(String[] args) {
        LinkedHashMap<String, A> linkedHashMap = new LinkedHashMap<>();
        List<A> list = new ArrayList<>();
        A a1 = new A(2);
        A a2 = new A(1);
        list.add(a1);
        list.add(a2);
        linkedHashMap.put("1",a1);
        linkedHashMap.put("2",a2);

        linkedHashMap.forEach(new BiConsumer<String, A>() {
            @Override
            public void accept(String s, A a) {
                System.out.println("s = " + s);
            }
        });

    }
}
