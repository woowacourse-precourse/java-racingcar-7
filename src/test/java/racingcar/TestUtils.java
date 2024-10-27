package racingcar;

import java.util.List;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputProvider;

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

    public static InputProvider mockInputProviderGenerator(List<String> preDefinedInputs) {
        return new InputProvider() {
            private int index = 0;

            @Override
            public String readLine() {
                String value = preDefinedInputs.get(index);
                index = (index + 1) % preDefinedInputs.size();
                return value;
            }

            @Override
            public void close() {

            }
        };
    }

}
