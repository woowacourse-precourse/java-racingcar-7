package racingcar.util;

import racingcar.model.Car;
import java.util.List;

public class Validator {
    public Boolean validBlank(String carNames, String raceRounds) {
        return carNames.isBlank() || raceRounds.isBlank();
    }
    public Boolean validNumber(String raceRounds) {
        return !(raceRounds.matches("\\d+"));
    }

    public Boolean validNameLength(List<Car> carList) {
        for (Car car : carList) {
            if (car.getName().length() > 5) {
                return true;
            }
        }
        return false;
    }
}
