package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.validate.CarNameValidation;

public class RacingCarGame {

    List<Car> cars = new ArrayList<>();

    public RacingCarGame(List<String> carNames) {
        for (String carName : carNames) {
            CarNameValidation.validateName(carName);
            cars.add(new Car(carName));
        }
        RacingCarsGroup racingCarsGroup = new RacingCarsGroup(cars);
    }

    public void playCarGame(int inputNumbersOfAttempts) {

    }

}
