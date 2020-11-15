package com.harleyoconnor.javasorts;

import com.harleyoconnor.javasorts.utils.InputUtils;
import com.harleyoconnor.javasorts.utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Harley O'Connor
 */
public final class JavaSorts {

    public static void main (final String[] args) {
        final List<Integer> inputNumberList = new ArrayList<>();

        while (true) {
            final Object input = InputUtils.getIntOrStringInput("\nEnter a number (or 'stop' to finish):", false, false);

            if (input == null) continue;

            if (input instanceof String) {
                if (((String) input).equalsIgnoreCase("stop"))
                    break;
                System.out.println("\nYou must enter a number or 'stop' to finish.");
                continue;
            }

            if (input instanceof Integer) {
                inputNumberList.add((Integer) input);
            }
        }

        final List<ListUtils.SortMethod> sortMethods = Arrays.asList(ListUtils.SortMethod.values());
        final List<String> sortTypeStrings = new ArrayList<>();

        sortMethods.forEach(sortMethod -> sortTypeStrings.add(sortMethod.toString()));

        final ListUtils.SortMethod sortMethod = ListUtils.SortMethod.valueOf(InputUtils.getSelection("\nHow would you like to sort the list?", sortTypeStrings));

        final boolean ascending = InputUtils.getInput("\nWould you like to sort it ascending? (y/n) ", true).equals("y");

        ListUtils.sort(sortMethod, inputNumberList, ascending);

        System.out.println("\nHere is the sorted list:");
        for (int i = 0; i < inputNumberList.size(); i++)
            System.out.print(inputNumberList.get(i) + (i == inputNumberList.size() - 1 ? "" : ", "));

        System.out.println("\n\nList Stats: \nAverage: " + ListUtils.getAverage(inputNumberList) + "\nMinimum: " + ListUtils.getMinNumber(inputNumberList) + "\nMaximum: " + ListUtils.getMaxNumber(inputNumberList));
    }

}
