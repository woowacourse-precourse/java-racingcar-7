package racingcar.domain;

import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;
    private int currentIndex = 0;

    public FixedNumberGenerator(Integer... numbers) {
        this.numbers = List.of(numbers);
    }

    @Override
    public int generate() {
        return numbers.get(currentIndex++);
    }
}
