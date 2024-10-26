package racingcar.utils;

import java.util.LinkedList;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {
    private Integer number;
    private final List<Integer> queue = new LinkedList<>();

    public FixedNumberGenerator(Integer number) {
        this.number = number;
    }

    public FixedNumberGenerator(List<Integer> queue) {
        this.queue.addAll(queue);
        number = queue.getFirst();
    }

    @Override
    public int getNumber() {
        if (!queue.isEmpty()) {
            number = queue.removeFirst();
        }
        return number;
    }
}
