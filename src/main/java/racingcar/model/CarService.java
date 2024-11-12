package racingcar.model;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarService {
    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return cars;
    }

    public List<String> findWinner(List<Car> cars) {
        Integer maxMovement = cars.stream().mapToInt(Car::getTotalMovement).max().orElse(0);
        List<String> winners = cars.stream().filter(car -> car.getTotalMovement().equals(maxMovement))
            .map(Car::getName).toList();
        return winners;
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
