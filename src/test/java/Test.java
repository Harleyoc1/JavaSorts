import com.harleyoconnor.javasorts.utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Harley O'Connor
 */
public final class Test {

    @org.junit.Test
    public void test () {
        System.out.println("\n\n === TESTING === \n\n");

        final List<Integer> list = new ArrayList<>();

        list.addAll(Arrays.asList(4, 2, 7, 3, 1, 7, 3));

        ListUtils.doBubbleSort(list, true);
        System.out.println(list);

        System.out.println(ListUtils.getMinNumber(list));
        System.out.println(ListUtils.getMaxNumber(list));
        System.out.println(ListUtils.getAverage(list));

        System.out.println("\n\n === FINISH TESTING ===\n\n");
    }

}
