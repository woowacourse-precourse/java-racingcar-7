package racingcar;

import java.util.ArrayList;
import java.util.List;

class RacingGameManager implements RacingGame {
    private final List<Car> racingCarsList = new ArrayList<>();

    @Override
    public void ready(List<String> cars) {
        for (String car : cars) {
            InputValidator.nameValidation(car);

            this.racingCarsList.add(Car.create(car));
        }
    }

    @Override
    public void start(int tryNumber) {
    }
}
