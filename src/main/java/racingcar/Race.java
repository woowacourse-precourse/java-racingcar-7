package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final NumberGenerator numberGenerator;

    public Race(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    // TODO: 함수 분리하기
    public void run(final int rounds, final List<Car> cars) {
        for (int round = 0; round < rounds; round++) {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < cars.size(); i++) {
                numbers.add(numberGenerator.generateNumber(4));
            }
            Round.play(cars, numbers);
        }
    }
}
