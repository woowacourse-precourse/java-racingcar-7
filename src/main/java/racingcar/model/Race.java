package racingcar.model;

import racingcar.view.RaceView;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int attempts;

    public Race(List<String> carNames, int attempts) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.attempts = attempts;
    }

    public void startRace() {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
            }
            RaceView.displayRaceStatus(cars);
        }
    }

    public List<String> getWinners() {
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
