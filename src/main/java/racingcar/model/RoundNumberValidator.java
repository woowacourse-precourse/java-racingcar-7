package racingcar.model;

public class RoundNumberValidator {
    public final int roundNumber;

    public RoundNumberValidator(String inputNumber) {
        this.roundNumber = isInt(inputNumber);
    }

    public int isInt(String inputRound) {
        try {
            int integerRound = Integer.parseInt(inputRound);
            if (integerRound <= 0) {
                throw new IllegalArgumentException();
            }
            return integerRound;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
