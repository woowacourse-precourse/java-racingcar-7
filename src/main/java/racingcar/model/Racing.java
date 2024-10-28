package racingcar.model;

import java.util.List;

import static racingcar.model.RandomNumberGenerator.randomNumber;
import static racingcar.view.OutputView.printRoundResults;

public class Racing {
    private final List<Car> cars;
    private final int rounds;

    public Racing(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    private boolean interpretCommand() {
        return randomNumber() >= 4;
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            raceRound();
            printRoundResults(cars); // 라운드 결과 기록
        }
    }

    private void raceRound() {
        for (Car car : cars) {
            boolean stopOrMove = interpretCommand();
            car.moveForward(stopOrMove);
        }
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .toList();
    }
}
