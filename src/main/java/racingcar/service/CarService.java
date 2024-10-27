package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumber;

public class CarService {

    public Cars createCars (String rawCarNames) {
        List<String> carNames = Arrays.asList(rawCarNames.split(","));

        return new Cars(carNames);
    }

    public void movePerCar(Cars cars, RandomNumber randomNumber, int index) {
        if (randomNumber.isMove()) {
            cars.carMove(index);
        }
    }
}
