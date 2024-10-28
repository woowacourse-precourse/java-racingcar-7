package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;

    public RacingGame(List<String> carNames, int attempts) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.attempts = attempts;
    }

    public void play() {
        for (int i = 0; i < attempts; i++) {
            playOneRound();
            OutputView.printCurrentState(cars);
        }
        List<String> winners = getWinners();
        OutputView.printWinners(winners);
    }

    private void playOneRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
