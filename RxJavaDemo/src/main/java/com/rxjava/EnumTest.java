package com.rxjava;

/**
 * Created by Allen on 2017/9/8.
 */
public class EnumTest {
    public static void main(String[] args) {
        ActivityType activityType = ActivityType.unknown;
        ActivityType activityType2 = ActivityType.unknown;
        System.out.println(" = " +activityType.ordinal() );
        System.out.println(" = " +activityType.name());

        System.out.println("(activityType2==activityType = " + (activityType2==activityType));
    }
}
