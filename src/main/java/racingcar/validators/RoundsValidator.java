package racingcar.validators;

import racingcar.common.Ranges;

public class RoundsValidator {
    private final String rounds;

    public RoundsValidator(String rounds) {
        this.rounds = rounds;
    }

    public void validate() {
        validateEmpty();
        validateNumber();
        validateRange();
    }

    private void validateEmpty() {
        if (rounds.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private void validateNumber() {
        try {
            Integer.parseInt(rounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }

    private void validateRange() {
        if (Integer.parseInt(rounds) < Ranges.MIN_ROUNDS.getValue()) {
            throw new IllegalArgumentException(
                    "시도할 횟수로 " + Ranges.MIN_ROUNDS.getValue() + " 이상의 값을 입력해주세요.");
        } else if (Integer.parseInt(rounds) > Ranges.MAX_ROUNDS.getValue()) {
            throw new IllegalArgumentException(
                    "시도할 횟수가 너무 큽니다. " + Ranges.MAX_ROUNDS.getValue() + " 이하의 값을 입력해주세요.");
        }
    }
}
