package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(List<String> carNames, int rounds) {
        this.cars = createCars(carNames);
        this.rounds = rounds;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            proceedRound();
            OutputView.printRoundResult(cars);
        }
        OutputView.printWinners(getWinners());
    }

    private void proceedRound() {
        for (Car car : cars) {
            if (GameRule.shouldMove()) {
                car.move();
            }
        }
    }

    private List<String> getWinners() {
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
