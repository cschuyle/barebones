package org.example;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Implement the mean, median, mode and range methods of the Calculator class in Java 8 Functional
 * style with the minimum code necessary to pass the tests.
 */
class FunctionalTest {

    @Test
    void range() {
        assertEquals(14, calculator.range(3, 17, 15, 11, 9));
    }

    @Test
    void mean() {
        assertEquals(12.5, calculator.mean(13, 19, null, 14, 16, 5, 8), 0);
    }

    @Test
    void median() {
        assertEquals(6, calculator.median(7, 11, 6, 2, 5), 0);
        assertEquals(13.5, calculator.median(13, 18, 14, 16, 5, 8), 0);
    }

    @Test
    void mode() {
        assertArrayEquals(new int[]{3}, calculator.mode(5, 2, 3, 6, 4, 1, 3));
        assertArrayEquals(new int[]{3, 5}, calculator.mode(4, 5, 3, 1, 3, 2, 5, 6));
        assertArrayEquals(new int[]{5}, calculator.mode(4, 5, 5, 3, 1, 3, 2, 5, 6));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, calculator.mode(1, 3, 2, 4, 5));
    }

    private class Calculator {

        /**
         * range: the difference between min and max values
         */
        int range(int... input) {
            int max = Arrays.stream(input).max().getAsInt();
            int min = Arrays.stream(input).min().getAsInt();
            return max - min;
            // TODO: Use teeing ???
            // reduce
            // statistics
        }

        /**
         * mean: the average of the numbers
         */
        double mean(Integer... input) {
            if(input.length == 0) {
                return 0;
            }
            return Arrays.stream(input)
                    .filter(Objects::nonNull)
                    .mapToInt(Integer::intValue)
                    .average().orElse(0d);
        }

        /**
         * median: the middle number in a sorted list
         * ...if there are two middle values, return the average of the two
         */
        double median(int... input) {
            if (input.length == 0) {
                return 0;
            }
            List<Integer> list = Arrays.stream(input).sorted().boxed().toList();

            if (list.size() % 2 == 1) {
                // 3 --> 1
                // 5 --> 2
                return list.get(list.size() / 2);
            }
            // 2 [0] + [1] / 2
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
        }


        /**
         * mode: the most frequently occurring number
         */
        int[] mode(int... input) {
            Map<Integer, List<Integer>> grouped = Arrays.stream(input).boxed().collect(groupingBy(Integer::intValue));
            int maxval = grouped.values().stream().map(List::size).max(Integer::compare).get();
//            List<Integer> modes = new ArrayList<>();
//            grouped.forEach((k, v) -> {
//                if (v.size() == maxval) {
//                    modes.add(k);
//                }
//            });

            return grouped.entrySet().stream()
                    .filter(e -> e.getValue().size() == maxval)
                    .mapToInt( e-> e.getKey())
                    .toArray();
        }
    }

    private final Calculator calculator = new Calculator();
}
