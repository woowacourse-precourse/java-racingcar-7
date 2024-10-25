package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static Input INSTANCE;
    private Input() {}

    public static Input getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Input();
        }
        return INSTANCE;
    }

    public  String carNames() {
        String carNames = Console.readLine().trim();
        Console.close();
        validateCarNames(carNames);
        return carNames;
    }

    public String rounds() {
        String rounds = Console.readLine();
        Console.close();
        validateRoundNumber(rounds);
        return rounds;
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
        validateCarNameInputBlank(carNames);
        validateNotEndingWithComma(carNames);
        validateCommaSeparated(carNames);
    }

    private void validateCarNameInputBlank(String carNames) {
        if(carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is Blank");
        }
    }

    private void validateNotEndingWithComma(String carNames) {
        if(carNames.endsWith(",")){
            throw new IllegalArgumentException("Write valid comma between names");
        }
    }

    private void validateCommaSeparated(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            if(name.isEmpty()){
                throw new IllegalArgumentException("Write valid comma between names");
            }
        }
    }
}
