package racingcar.domain;

public class Round {
    private Integer number;

    public Round(String input) {
        Integer number = convertToInteger(input.trim());
        validatePositive(number);
        this.number = number;
    }

    public static Round of(String number) {
        return new Round(number);
    }

    public boolean hasRound() {
        return number > 0;
    }

    public void playRound() {
        number--;
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    private Integer convertToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
