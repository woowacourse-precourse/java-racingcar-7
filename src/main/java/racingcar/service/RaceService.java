package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RaceService {

    public List<Car> carListOf(String userInput) {
        List<Car> cars = new ArrayList<>();
        for (String carName : userInput.split(",")) {
            cars.add(Car.from(carName));
        }

        return cars;
    }

    public List<String> findWinners(List<Car> cars) {
        int maxStatus = findMaxProgress(cars);
        List<String> winnersName = new ArrayList<>();
        for (Car car : cars) {
            if (maxStatus == car.status()) {
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

    private int findMaxProgress(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.status(), max);
        }
        return max;
    }
}
