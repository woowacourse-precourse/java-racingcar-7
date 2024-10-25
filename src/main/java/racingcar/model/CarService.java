package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;

public class CarService {
    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return cars;
    }

    public Car moveForward(Car car) {
        if (canMove()) {
            car.totalMovement += 1;
        }
        return car;
    }

    private boolean canMove() {
        int randomNumber = pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
