package racingcar;

import racingcar.model.NumberGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TestNumberGenerator implements NumberGenerator {
    private final Queue<Integer> numbers;

    TestNumberGenerator(List<Integer> numbers) {
        this.numbers = new LinkedList<>(numbers);
    }

    @Override
    public int generate() {
        return numbers.poll();
    }
}
