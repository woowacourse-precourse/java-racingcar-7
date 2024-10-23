package racingcar.model;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.Constant;

public class RacingGameModel {

    public List<Car> generateCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, Constant.CAR_SCORE_DEFAULT_VALUE))
                .toList();
    }
}
