package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCar {

    public void race() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = getCarNamesFromUser();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = getAttemptCountFromUser();

        Map<String, Integer> moveAccumulator = createCarMoveAccumulator(carNames);
        displayAccumulateForEachAttempt(attemptCount, carNames, moveAccumulator);

        String winners = retrieveWinners(moveAccumulator);
    }

    private List<String> getCarNamesFromUser() {
        String carNames = Console.readLine();
        return Arrays.stream(carNames.split(","))
                .peek(this::validateCarNameLength)
                .toList();
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5를 넘을 수 없습니다.");
        }
    }

    private int getAttemptCountFromUser() {
        String attemptCount = Console.readLine();
        return parseAttemptCountAsInteger(attemptCount);
    }

    private int parseAttemptCountAsInteger(String attemptCount) {
        try {
            return Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 문자일 수 없습니다.");
        }
    }

    private Map<String, Integer> createCarMoveAccumulator(List<String> carNames) {
        return carNames.stream()
                .collect(Collectors.toMap(carName -> carName, carName -> 0));
    }

    private void displayAccumulateForEachAttempt(int attemptCount, List<String> carNames,
                                                 Map<String, Integer> moveAccumulator) {
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            accumulateMoveCount(carNames, moveAccumulator);
            displayCurrentAccumulation(carNames, moveAccumulator);
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

    private void displayCurrentAccumulation(List<String> carNames, Map<String, Integer> moveAccumulator) {
        for (String carName : carNames) {
            int progressiveSum = moveAccumulator.get(carName);
            String formattedEachResult = String.format("%s : %s", carName, "-".repeat(progressiveSum));
            System.out.println(formattedEachResult);
        }
        System.out.println();
    }

    private String retrieveWinners(Map<String, Integer> moveAccumulator) {
        Integer maxProgressiveCount = findMaxMoveCount(moveAccumulator);
        List<String> winners = getWinners(moveAccumulator, maxProgressiveCount);
        return formatWinners(winners);
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

    private String formatWinners(List<String> winners) {
        return String.join(", ", winners);
    }
}