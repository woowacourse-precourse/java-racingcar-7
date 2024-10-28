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

    public void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.drive();
        }
    }

    public void run() {
        List<Car> cars = initializeCars();  // 자동차 리스트를 한 번만 초기화
        int round = InputView.getInputTime();  // 시도 횟수를 입력받음
        for (int i = 0; i < round; i++) {
            moveCar(cars);  // 기존의 cars 리스트를 사용하여 매 라운드 실행
            OutputView.printRoundResult(cars);
        }
        OutputView.printWinner(cars);
    }

}
