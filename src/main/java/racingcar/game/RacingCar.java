package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.game.controller.io.InputHandler;
import racingcar.game.controller.io.OutputHandler;

public class RacingCar {
    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();

    public void race() {
        outputHandler.showCarNamesNavigateMessage();
        List<String> carNames = inputHandler.getCarNamesFromUser();

        outputHandler.showAttemptCountNavigateMessage();
        int attemptCount = inputHandler.getAttemptCountFromUser();

        Map<String, Integer> moveAccumulator = createCarMoveAccumulator(carNames);
        displayAccumulateForEachAttempt(attemptCount, carNames, moveAccumulator);

        List<String> winners = retrieveWinners(moveAccumulator);

        outputHandler.showWinners(winners);
    }

    private Map<String, Integer> createCarMoveAccumulator(List<String> carNames) {
        return carNames.stream()
                .collect(Collectors.toMap(carName -> carName, carName -> 0));
    }

    private void displayAccumulateForEachAttempt(int attemptCount, List<String> carNames,
                                                 Map<String, Integer> moveAccumulator) {
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            accumulateMoveCount(carNames, moveAccumulator);
            outputHandler.showCurrentAccumulation(carNames, moveAccumulator);
        }
    }

    private void accumulateMoveCount(List<String> carNames, Map<String, Integer> moveAccumulator) {
        for (String carName : carNames) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            accumulateIfCanMove(randomNumber, moveAccumulator, carName);
        }
    }

    private void accumulateIfCanMove(int randomNumber, Map<String, Integer> moveAccumulator, String carName) {
        if (randomNumber < 4) {
            return;
        }

        moveAccumulator.merge(carName, 1, Integer::sum);
    }

    private List<String> retrieveWinners(Map<String, Integer> moveAccumulator) {
        Integer maxProgressiveCount = findMaxMoveCount(moveAccumulator);
        return getWinners(moveAccumulator, maxProgressiveCount);
    }

    private Integer findMaxMoveCount(Map<String, Integer> moveAccumulator) {
        return moveAccumulator.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    private List<String> getWinners(Map<String, Integer> moveAccumulator, Integer progressiveCount) {
        return moveAccumulator.keySet().stream()
                .filter(carName -> moveAccumulator.get(carName).equals(progressiveCount))
                .toList();
    }
}