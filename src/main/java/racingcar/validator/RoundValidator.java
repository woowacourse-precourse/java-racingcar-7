package racingcar.validator;

public class RoundValidator {

    public int parseInt(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void positiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
