package com.rxjava;

/**
 * Created by Allen on 2017/9/8.
 */
public enum ActivityType {
    unknown(0),
    stationary(1),

    walking(2),

    running(3),

    automotive(4),

    cycling(5),

    stay(6);

    ActivityType(int i) {

    }
}