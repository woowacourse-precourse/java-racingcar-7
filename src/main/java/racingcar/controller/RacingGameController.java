package racingcar.controller;


import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGameController {

    private List<Car> initializeCars() {
        List<Car> cars = new ArrayList<>();
        Set<String> unique = new HashSet<>();
        for (String name : InputView.getInputCar()) {
            if (!unique.add(name)) {
                throw new IllegalArgumentException("이름이 중복됩니다.");
            }
            cars.add(new Car(name));
        }
        return cars;
    }

    public static int maxDistance(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public static List<String> getWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() >= maxDistance(cars)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }


}
