package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.CarRaceView;

import java.util.ArrayList;
import java.util.List;

public class CarRaceController {
    private final CarRaceView view;
    private final List<Car> cars = new ArrayList<>();

    public CarRaceController(CarRaceView view) {
        this.view = view;
    }

    public void startRace() {
        String carNamesInput = view.getCarNames();
        String[] carNames = carNamesInput.split(",");

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name.trim()));
        }

        int tryCount = view.getTryCount();
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            view.printRaceResult(cars);
        }

        List<String> winners = findWinners();
        view.printWinners(winners);
    }

    private List<String> findWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}