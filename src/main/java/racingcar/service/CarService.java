package racingcar.service;

import racingcar.domain.Car;

public class CarService {
    public static void forwardByRandomNumber(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.go();
        }
    }
}
