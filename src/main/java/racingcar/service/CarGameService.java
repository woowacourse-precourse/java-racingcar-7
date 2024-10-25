package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarGameService {

    public Cars processRound(Cars cars) {
        for (Car car : cars.getCarList()) {
            checkAndMove(car, Randoms.pickNumberInRange(0, 9));
        }
        return cars;
    }

    public void checkAndMove(Car car, int number) {
        if (number >= 4) {
            car.move();
        }
    }

}
