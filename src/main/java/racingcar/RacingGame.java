package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.tryCount = tryCount;
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void start() {
        OutputView.StartRace();
        for (int i = 0; i < tryCount; i++) {
            raceOneRound();
        }
        OutputView.RaceWinner(getWinners());
    }

    private void raceOneRound() {
        for (Car car : cars) {
            car.move();
            OutputView.CurrentPosition(car.getName() + " : " + car.getTrack());
        }
        System.out.println();
    }

    private String getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return String.join(",", winners);
    }
}