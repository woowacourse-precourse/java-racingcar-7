package racingcar;

import java.util.*;

public class RacePreparation {
    private List<String> carNames;
    private int matchCount;

    public RacePreparation(String input, String matchCount) {
        validateAndParseIntMatchCount(matchCount);
        initializeCarNames(input);
    }

    private void initializeCarNames(String input) {
        validateInput(input);
        carNames = Arrays.stream(input.split(",")).map(String::trim).toList();
        validateCarNamesDuplicated(carNames);
    }

    private void validateInput(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNamesDuplicated(List<String> carNames) {
        Set<String> checkDuplicatedCarNames = new HashSet<>(carNames);
        if (checkDuplicatedCarNames.size() < carNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAndParseIntMatchCount(String matchCount) {
        try {
            this.matchCount = Integer.parseInt(matchCount);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
