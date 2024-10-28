package racingcar.domain;

import racingcar.utils.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int attemptCount;

    private RacingGame(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public static RacingGame createFromInput() {
        String[] carNames = InputView.getCarNames();
        InputValidator.validateCarNames(carNames);

        List<Car> cars = createCars(carNames);
        int attemptCount = InputValidator.validateAttemptCount(InputView.getAttemptCount());

        return new RacingGame(cars, attemptCount);
    }

    public void play() {
        OutputView.printExecutionResult();
        for (int i = 0; i < attemptCount; i++) {
            playRound();
        }
        printWinners();
    }

    private static List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void playRound() {
        cars.forEach(car -> {
            int randomValue = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
            OutputView.printCarStatus(car.getName(), car.getPosition());
        });
        System.out.println();
    }

    private void printWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        OutputView.printWinners(winners);
    }
}
