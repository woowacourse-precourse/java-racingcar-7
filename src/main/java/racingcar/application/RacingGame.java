package racingcar.application;

import racingcar.domain.Car;

import racingcar.application.util.io.InputReader;
import racingcar.application.util.io.RequestPrinter;
import racingcar.application.util.io.ResultPrinter;
import racingcar.application.util.generator.RandomNumberGenerator;

import java.util.List;

public class RacingGame {

    private static final long MOVE_FORWARD_CRITERIA = 4;

    private final long  trial;
    private final List<Car> cars;

    public RacingGame() {
        RequestPrinter.printRequestNamesInput();
        this.cars = InputReader.readCarNames().stream()
                .map(Car::new)
                .toList();
        
        RequestPrinter.printRequestTrialInput();
        this.trial = InputReader.readTrial();
    }

    public void execute() {
        for (long round = 1; round <= trial; round++) {
            progressRound();
            showRaceStatus();
        }
        showRaceResult();
    }

    private void progressRound() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            if (isAbleToMoveForward(randomNumber)) {
                car.move();
            }
        }
    }

    private boolean isAbleToMoveForward(int number) {
        if (number >= MOVE_FORWARD_CRITERIA) {
            return true;
        }
        return false;
    }

    private void showRaceStatus() {
        List<String> informations = cars.stream().map(Car::getInformation).toList();
        ResultPrinter.printCarInformations(informations);
    }

    private void showRaceResult() {
        long highestDistance = calculateHighestDistance();
        List<String> winnerNames = extractWinnersPositionAt(highestDistance);
        ResultPrinter.printWinners(winnerNames);
    }

    private List<String> extractWinnersPositionAt(long highestDistance) {
        return cars.stream()
                .filter(car -> car.getPosition() == highestDistance)
                .map(Car::getName)
                .toList();
    }

    private long calculateHighestDistance() {
        return cars.stream()
                .mapToLong(Car::getPosition)
                .max().getAsLong();
    }

}
