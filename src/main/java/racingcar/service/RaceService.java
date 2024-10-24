package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RaceService {

    public List<Car> carListOf(String userInput) {
        List<Car> cars = new ArrayList<>();
        for (String carName : userInput.split(",")) {
            if (!cars.isEmpty()) {
                validateSameNameIn(cars, carName);
            }

            cars.add(Car.from(carName));
        }

        return cars;
    }

    public List<String> findWinners(List<Car> cars) {
        int maxLocation = findMaxLocation(cars);
        List<String> winnersName = new ArrayList<>();
        for (Car car : cars) {
            if (maxLocation == car.location()) {
                winnersName.add(car.name());
            }
        }
        return winnersName;
    }

    public void forwardWithRandomCondition(List<Car> cars) {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                car.forward();
            }
        }
    }

    private int findMaxLocation(List<Car> cars) {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(car.location(), maxLocation);
        }
        return maxLocation;
    }

    private void validateSameNameIn(List<Car> cars, String carName) {
        for (Car car : cars) {
            if (car.name().equals(carName)) {
                throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
            }
        }
    }
}
