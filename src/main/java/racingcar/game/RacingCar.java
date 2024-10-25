package racingcar.game;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.game.controller.io.InputHandler;
import racingcar.game.controller.io.OutputHandler;
import racingcar.game.model.Car;
import racingcar.game.model.util.RandomNumberGenerator;

public class RacingCar {
    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();

    public void race() {
        outputHandler.showCarNamesNavigateMessage();
        List<Car> cars = inputHandler.getCarNamesFromUser();

        outputHandler.showAttemptCountNavigateMessage();
        int attemptCount = inputHandler.getAttemptCountFromUser();

        Map<Car, Integer> moveAccumulator = createCarMoveAccumulator(cars);
        displayAccumulateForEachAttempt(attemptCount, cars, moveAccumulator);

        List<Car> winners = retrieveWinners(moveAccumulator);

        outputHandler.showWinners(winners);
    }

    private Map<Car, Integer> createCarMoveAccumulator(List<Car> carNames) {
        return carNames.stream()
                .collect(Collectors.toMap(car -> car, car -> 0));
    }

    private void displayAccumulateForEachAttempt(int attemptCount, List<Car> cars, Map<Car, Integer> moveAccumulator) {
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            accumulateMoveCount(cars, moveAccumulator);
            outputHandler.showCurrentAccumulation(cars, moveAccumulator);
        }
    }

    private void accumulateMoveCount(List<Car> cars, Map<Car, Integer> moveAccumulator) {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generate();
            accumulateIfCanMove(randomNumber, moveAccumulator, car);
        }
    }

    private void accumulateIfCanMove(int randomNumber, Map<Car, Integer> moveAccumulator, Car car) {
        if (randomNumber < 4) {
            return;
        }

        moveAccumulator.merge(car, 1, Integer::sum);
    }

    private List<Car> retrieveWinners(Map<Car, Integer> moveAccumulator) {
        Integer maxProgressiveCount = findMaxMoveCount(moveAccumulator);
        return getWinners(moveAccumulator, maxProgressiveCount);
    }

    private Integer findMaxMoveCount(Map<Car, Integer> moveAccumulator) {
        return moveAccumulator.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    private List<Car> getWinners(Map<Car, Integer> moveAccumulator, Integer progressiveCount) {
        return moveAccumulator.keySet().stream()
                .filter(carName -> moveAccumulator.get(carName).equals(progressiveCount))
                .toList();
    }
}