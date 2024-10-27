package racingcar;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class TestNumberGenerator implements IntegerGenerator {

    private Queue<Integer> integers = new ArrayDeque<>();

    public TestNumberGenerator(List<Integer> integers) {
        this.integers = new ArrayDeque<>(integers);
    }

    @Override
    public int generate() {
        return this.integers.poll();
    }
}
