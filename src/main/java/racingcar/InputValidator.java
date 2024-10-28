package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public void checkCarCount(List<String> racingCarNames) {
        if (racingCarNames.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNameLength(List<String> racingCarNames) {
        for (String racingCarName : racingCarNames) {
            checkIndividualNameLength(racingCarName);
        }
    }

    private void checkIndividualNameLength(String racingCarName) {
        if (racingCarName.length() < MIN_NAME_LENGTH || racingCarName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void checkWhitespace(List<String> racingCarNames) {
        for (String racingCarName : racingCarNames) {
            checkContainsWhitespace(racingCarName);
        }
    }

    private void checkContainsWhitespace(String racingCarName) {
        if (racingCarName.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicates(List<String> racingCarNames) {
        Set<String> distinctCarNames = new HashSet<>(racingCarNames);
        checkDuplicatesNames(distinctCarNames, racingCarNames.size());
    }

    private void checkDuplicatesNames(Set<String> distinctCarNames, int totalCarCount) {
        if (distinctCarNames.size() < totalCarCount) {
            throw new IllegalArgumentException();
        }
    }

    public void checkIfValidRaceCount(int raceCount) {
        if (raceCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void checkForEmptyInput(String raceCountInput) {
        if (raceCountInput == null || raceCountInput.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkIfContainsLetters(String raceCountInput) {
        try {
            Integer.parseInt(raceCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
