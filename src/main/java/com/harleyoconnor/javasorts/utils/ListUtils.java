package com.harleyoconnor.javasorts.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Harley O'Connor
 */
public final class ListUtils {

    /**
     * Gets the average of the list by adding up all values and dividing by the size.
     *
     * @param list The relevant integer list.
     * @return The average value.
     */
    public static double getAverage (final List<Integer> list) {
        final AtomicInteger total = new AtomicInteger(0);
        list.forEach(total::addAndGet);
        return ((double) total.get()) / list.size();
    }

    /**
     * Gets the minimum number which appears in the list.
     *
     * @param list The relevant integer list.
     * @return The lowest number in the list.
     */
    public static int getMinNumber (final List<Integer> list) {
        return getMinMax(list, true);
    }

    /**
     * Gets the maximum number which appears in the list.
     *
     * @param list The relevant integer list.
     * @return The highest number in the list.
     */
    public static int getMaxNumber (final List<Integer> list) {
        return getMinMax(list, false);
    }

    /**
     * Gets either the min or max from a list depending on the parameters. Private method only to be used for
     * getMaxNumber and getMinNumber.
     *
     * @param list The relevant integer list.
     * @param min Whether or not to get the minimum or maximum number.
     * @return The minimum or maximum number.
     */
    private static int getMinMax (final List<Integer> list, final boolean min) {
        Integer lowestOrHighestNum = list.get(0);

        for (final Integer num : list) {
            if ((num < lowestOrHighestNum && min) || (num > lowestOrHighestNum && !min))
                lowestOrHighestNum = num;
        }

        return lowestOrHighestNum;
    }

    /**
     * Sorts the list using the 'Bubble Sort' method.
     *
     * @param list The list to be sorted.
     * @param ascending Whether or not to sort it ascending or descending.
     */
    public static void doBubbleSort (final List<Integer> list, final boolean ascending) {
        boolean sorted;

        do {
            sorted = true;

            for (int i = 0; i < list.size(); i++) {
                if (i >= list.size() - 1) break;

                final int currentNum = list.get(i);
                final int nextNum = list.get(i + 1);

                if ((currentNum > nextNum && ascending) || (currentNum < nextNum && !ascending)) {
                    sorted = false;
                    list.set(i, nextNum);
                    list.set(i + 1, currentNum);
                }
            }
        } while (!sorted);
    }

    /**
     * Sorts the list using the 'Merge Sort' method (splits the lists into two, uses bubble sort from above on both, then merges them back into the original list).
     *
     * @param list The list to be sorted.
     * @param ascending Whether or not to sort it ascending or descending.
     */
    public static void doMergeSort (final List<Integer> list, final boolean ascending) {
        final List<Integer> numListSnapshot = new ArrayList<>(list);
        final int middleIndex = (int) Math.floor((double) list.size() / 2);
        final List<Integer> firstHalf = numListSnapshot.subList(0, middleIndex);
        final List<Integer> secondHalf = numListSnapshot.subList(middleIndex, list.size());

        doBubbleSort(firstHalf, ascending);
        doBubbleSort(secondHalf, ascending);

        int firstHalfIndex = 0, secondHalfIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            int newNum;

            final int firstHalfNum = firstHalfIndex < firstHalf.size() ? firstHalf.get(firstHalfIndex) : (ascending ? getMaxNumber(secondHalf) + 1 : getMinNumber(secondHalf) - 1);;
            final int secondHalfNum = secondHalfIndex < secondHalf.size() ? secondHalf.get(secondHalfIndex) : (ascending ? getMaxNumber(firstHalf) + 1 : getMinNumber(firstHalf) - 1);

            if (((firstHalfNum > secondHalfNum && ascending) || (firstHalfNum < secondHalfNum && !ascending))) {
                newNum = secondHalfNum;
                secondHalfIndex++;
            } else {
                newNum = firstHalfNum;
                firstHalfIndex++;
            }

            list.set(i, newNum);
        }
    }

}
