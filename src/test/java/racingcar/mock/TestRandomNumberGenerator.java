package racingcar.mock;

import java.util.List;
import racingcar.utils.RandomGenerator;

public class TestRandomNumberGenerator implements RandomGenerator {
    private final List<Integer> numbers;
    private int index = 0;

    public TestRandomNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.get(index++);
    }
}
