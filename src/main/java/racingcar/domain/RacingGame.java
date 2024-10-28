package racingcar.domain;

import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int trialCount;

    public RacingGame(String carNamesInput, int trialCount) {
        String[] carNames = carNamesInput.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        this.trialCount = trialCount;
    }

    public void start() {
        OutputView.printResultMessage();
        for (int i = 0; i < trialCount; i++) {
            playRound();
            OutputView.printCarPositions(cars);
        }
        OutputView.printWinners(getWinners());
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generate();
            car.move(randomNumber);
        }
    }

    private List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
