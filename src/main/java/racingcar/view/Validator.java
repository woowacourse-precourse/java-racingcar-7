package racingcar.view;

public class Validator {
    public static void validateCarNames(String[] carNames) { // 레이싱카 이름을 검증한다.
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public static void validateRacingRound(String racingRound) { // 시도할 횟수 입력을 검증한다.
        try {
            Integer.parseInt(racingRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수 형태여야 합니다.");
        }
    }

    public static void handleEmptyInputException() {
        throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 게임을 진행할 수 없습니다.");
    }
}