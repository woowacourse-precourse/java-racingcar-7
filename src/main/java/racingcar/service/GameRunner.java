package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.model.GameResult;

public class GameRunner {

    public GameResult runGame(Set<String> carNames, int finalAttemptCount) {
        Map<String, Integer> carState = initializeCarState(carNames);
        StringBuilder allRoundResults = new StringBuilder();

        for (int attemptCount = 0; attemptCount < finalAttemptCount; attemptCount++) {
            updateCarState(carState);
            allRoundResults.append(formatRoundResult(carState));
        }

        return new GameResult(carState, allRoundResults.toString());
    }

    private Map<String, Integer> initializeCarState(Set<String> carNames) {
        Map<String, Integer> carState = new HashMap<>();
        for (String car : carNames) {
            carState.put(car, 0);
        }
        return carState;
    }

    public void updateCarState(Map<String, Integer> carState){
        carState.forEach((car, position) -> {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (isMoved(randomNumber)) {
                carState.put(car, position + 1);
            }
        });
    }

    public boolean isMoved(int randomNumber){
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public String getWinner(Map<String, Integer> carState) {
        int maxPosition = carState.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        List<String> winners = carState.entrySet().stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .toList();

        return String.join(",", winners);
    }

    public String formatRoundResult(Map<String, Integer> carPositions) {
        StringBuilder result = new StringBuilder();
        carPositions.forEach((carName, position) -> {
            result.append(carName)
                    .append(" : ")
                    .append("-".repeat(Math.max(0, position)))
                    .append("\n");
        });
        return result.toString();
    }
}
