package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final NumberGenerator numberGenerator;
    private final Integer rounds;
    private final List<Car> cars;

    public Race(final NumberGenerator numberGenerator, final Integer rounds, final List<Car> cars) {
        this.numberGenerator = numberGenerator;
        this.rounds = rounds;
        this.cars = cars;
    }

    // TODO: 함수 분리하기
    public void run() {
        for (int round = 0; round < rounds; round++) {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < cars.size(); i++) {
                numbers.add(numberGenerator.generateNumber());
            }
            Round.play(cars, numbers);
        }
    }
}
