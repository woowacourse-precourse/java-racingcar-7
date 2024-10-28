package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private final List<Integer> numbers;
    private int position;

    public int getNextNumber() {
        position++;
        return numbers.get(position);
    }

    public int size() {
        return numbers.size();
    }

    private RandomNumbers(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        this.position = -1;
    }

    public static RandomNumbers create(List<Integer> numbers) {
        return new RandomNumbers(numbers);
    }
}
