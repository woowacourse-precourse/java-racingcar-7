package racingcar.presentation.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Input {
    private static final Pattern VALID_CAR_NAMES_PATTERN = Pattern.compile("^[^,]+(,[^,]+)*$");

    public  String carNames() {
        String carNames = Console.readLine().trim();
        validateCarNames(carNames);
        return carNames;
    }

    public String rounds() {
        String rounds = Console.readLine();
        validateRoundNumber(rounds);
        return rounds;
    }

    public void closeConsole() {
        Console.close();
    }

    private void validateRoundNumber(String rounds) {
        try {
            int numberOfRounds = Integer.parseInt(rounds);
            if (numberOfRounds <= 0) {
                throw new IllegalArgumentException("Round number must be positive");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Round number must be numeric");
        }
    }

    private void validateCarNames(String carNames) {
        if (carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is Blank");
        }
        if (!VALID_CAR_NAMES_PATTERN.matcher(carNames).matches()) {
            throw new IllegalArgumentException("Write valid comma between names");
        }
    }
}
