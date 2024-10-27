package racingcar.domain;

public class Rounds {
    private final int rounds;

    public Rounds(String numberInput) {
        validateNumber(numberInput);
        this.rounds = Integer.parseInt(numberInput);
    }

    private void validateNumber(String number) {
        try {
            int rounds = Integer.parseInt(number);
            if (rounds < 1) {
                throw new IllegalArgumentException("자연수를 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    public int rounds() {
        return rounds;
    }
}
