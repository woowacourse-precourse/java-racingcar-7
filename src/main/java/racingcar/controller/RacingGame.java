package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int attemptCount;

    public RacingGame(String[] carNames, int attemptCount) {
        this.cars = createCars(carNames);
        this.attemptCount = attemptCount;
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name.trim()));
        }
        return carList;
    }

    public void start() {
        for (int i = 0; i < attemptCount; i++) {
            playRound();
        }
        announceWinners();
    }

    private void playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
            System.out.println(car.getName() + " : " + car.getProgress());
        }
        System.out.println();
    }

    private void announceWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}