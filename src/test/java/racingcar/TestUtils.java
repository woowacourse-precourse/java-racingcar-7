package racingcar;

import java.util.List;
import racingcar.util.RandomNumberGenerator;

public class TestUtils {
    public static RandomNumberGenerator mockRandomNumberGenerator(List<Integer> preDefinedNumbers) {
        return new RandomNumberGenerator() {
            private int index = 0;

            @Override
            public int pickRandomNumberInRange(int start, int end) {
                int value = preDefinedNumbers.get(index);
                index = (index + 1) % preDefinedNumbers.size();
                return value;
            }
        };
    }

}
