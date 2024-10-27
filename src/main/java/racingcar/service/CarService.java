package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumbers;

public class CarService {

    public Cars createCars (String rawCarNames) {
        List<String> carNames = Arrays.asList(rawCarNames.split(","));

        return new Cars(carNames);
    }

    public void playingPerGame (Cars cars, RandomNumbers randomNumbers) {
        for (int i = 0; i < cars.size(); i ++) {
            movePerCar(cars, randomNumbers, i);
        }
    }

    private void movePerCar(Cars cars, RandomNumbers randomNumbers, int index) {
        if (randomNumbers.isMove(index)) {
            cars.carMove(index);
        }
    }
}
