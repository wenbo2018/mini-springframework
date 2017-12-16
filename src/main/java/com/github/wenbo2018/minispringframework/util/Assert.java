package com.github.wenbo2018.minispringframework.util;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class Assert {

    public static void noNullElements(Object[] array, String message) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    throw new IllegalArgumentException(message);
                }
            }
        }
    }

}
