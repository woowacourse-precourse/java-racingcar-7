package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Input {
    private static Input INSTANCE;

    private static final Pattern VALID_CAR_NAMES_PATTERN = Pattern.compile("^[^,]+(,[^,]+)*$");

    private Input() {}

    public static Input getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Input();
        }
        return INSTANCE;
    }

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
