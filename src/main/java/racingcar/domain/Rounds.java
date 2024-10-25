package racingcar.domain;

public class Rounds {

    private final int rounds;

    public Rounds(String numberInput) {
        validateNumber(numberInput);
        this.rounds = Integer.parseInt(numberInput);
    }

    private void validateNumber(String number) {

    }

    public int rounds() {
        return rounds;
    }
}
