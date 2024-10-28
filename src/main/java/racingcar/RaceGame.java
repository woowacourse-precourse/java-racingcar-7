package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RaceGame {
    private final List<Car> cars;
    private final int attemptCount;

    public RaceGame(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void startRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            raceRound();
            GamePrinter.printRoundResult(cars);
        }
    }

    private void raceRound() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.moveForward();
            }
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
