package racingcar.mock;

import java.util.List;
import racingcar.util.RandomGenerator;

public class MockRandomGenerator implements RandomGenerator {

    private final List<Integer> randomNumbers;
    private int currentIndex = 0;

    public MockRandomGenerator(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    @Override
    public int generate() {
        if (currentIndex >= randomNumbers.size()) {
            throw new IllegalStateException("모든 미리 정의된 값을 사용했습니다.");
        }
        return randomNumbers.get(currentIndex++);
    }
}
