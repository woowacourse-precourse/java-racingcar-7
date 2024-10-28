package racingcar;

public class InputValidator {
    private final String inputNames;
    private final String rounds;

    InputValidator(String inputNames, String rounds) {
        this.inputNames = inputNames;
        this.rounds = rounds;
    }

    public boolean validateName() {
        if (inputNames == null || inputNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] carNames = inputNames.split(",");
        for (String names : carNames) {
            if (!validateNameRules(names)) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public boolean validateNameRules(String names) {
        return !names.isEmpty() && (5 >= names.length());
    }

    public boolean validateRounds() {
        if (rounds == null || rounds.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int rep;
        try {
            rep = Integer.parseInt(rounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (rep <= 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
