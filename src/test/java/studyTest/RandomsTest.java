package studyTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class RandomsTest {

    @Test
    void 범위_내의_숫자가_반환되는지_확인() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int result = Randoms.pickNumberInList(numbers);

        assertTrue(numbers.contains(result));
    }

    @Test
    void 결과가_고유한_값인지_확인() {
        int startInclusive = 1;
        int endInclusive = 10;
        int count = 5;
        List<Integer> result = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);

        assertEquals(count, result.stream().distinct().count());
    }

    @Test
    void 양끝값을_포함하는지_확인() {
        int startInclusive = 10;
        int endInclusive = 20;
        Set<Integer> results = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            int result = Randoms.pickNumberInRange(startInclusive, endInclusive);
            results.add(result);
        }

        assertTrue(results.contains(startInclusive));
        assertTrue(results.contains(endInclusive));
    }
}
