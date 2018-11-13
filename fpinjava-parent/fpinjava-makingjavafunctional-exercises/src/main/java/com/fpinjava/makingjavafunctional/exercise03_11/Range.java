package com.fpinjava.makingjavafunctional.exercise03_11;

import com.fpinjava.common.CollectionUtilities;

import java.util.ArrayList;
import java.util.List;

public class Range {

    public static List<Integer> range(int start, int end) {
        List<Integer> result = new ArrayList<>();
        int temp = start;
        while (temp < end) {
            result = CollectionUtilities.append(result, temp);
            temp++;
        }
        return result;
    }
}
