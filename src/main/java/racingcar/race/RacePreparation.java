package racingcar.race;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        validateCarNames(carNames);
    }

    private void validateInput(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
    }

    private void validateCarNames(List<String> carNames) {
        Set<String> checkDuplicatedCarNames = new HashSet<>(carNames);
        if (checkDuplicatedCarNames.size() < carNames.size()) {
            throw new IllegalArgumentException("Duplicated car names: " + checkDuplicatedCarNames);
        }

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("Exceeded characters: " + name);
            }
        }
    }

    private void validateAndParseIntMatchCount(String matchCount) {
        try {
            this.matchCount = Integer.parseInt(matchCount);
        } catch (Exception e) {
            throw new IllegalArgumentException("Character is not number: " + matchCount);
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
