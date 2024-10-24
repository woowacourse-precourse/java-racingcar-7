package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class RacingCarService {
    private List<Car> cars;

    public RacingCarService(List<Car> cars) {
        this.cars = cars;
    }

    public void moveRacingCars() {
        for (Car car : cars) {
            moveRacingCar(car);
        }
    }

    public void moveRacingCar(Car car) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            car.increaseScore();
        }
    }

    public List<Car> choiceWinner() {
        int maxScore = cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(cars -> cars.getScore() == maxScore)
                .collect(Collectors.toList());
    }
}
