package racingcar.validator;

public class RoundValidator {

    private final int round;

    public RoundValidator(String round) {
        this.round = parseInt(round);
    }

    public void verify() {
        positiveNumber(round);
    }

    private int parseInt(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void positiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getRound() {
        return round;
    }
}
