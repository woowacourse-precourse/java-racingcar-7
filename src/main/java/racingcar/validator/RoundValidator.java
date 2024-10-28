package racingcar.validator;

import racingcar.validator.exception.InvalidRoundException;

public class RoundValidator implements Validator<String> {

    @Override
    public void validate(String roundInput) {
        validateIsNumber(roundInput);
        int roundCount = validateWithinIntRange(roundInput);
        validateGreaterThanZero(roundCount);
    }

    private void validateIsNumber(String roundInput) {
        if (!roundInput.matches("-?\\d+")) {
            throw new InvalidRoundException("진행할 라운드를 정수로 입력해야합니다.");
        }
    }

    private int validateWithinIntRange(String roundInput) {
        try {
            return Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            throw new InvalidRoundException("라운드 횟수가 int의 범위를 초과하였습니다.");
        }
    }

    private void validateGreaterThanZero(int roundCount) {
        if (roundCount < 1) {
            throw new InvalidRoundException("라운드는 최소 1번 이상 진행되어야합니다.");
        }
    }
}