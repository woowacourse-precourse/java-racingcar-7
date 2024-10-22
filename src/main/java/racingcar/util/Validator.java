package racingcar.util;

public class Validator {
    private static final String CAR_REGEX = "^([^,]{1,5},)+[^,]{1,5}+$"; // 차 이름에는 구분자(반점)가 포함될 수 없다. 5자 이하여야 한다.
    private static final String ROUND_REGEX = "^[1-9][0-9]*$"; // 라운드 수는 0이거나, 비어있을 수 없다.

    public void checkAboutCars(String input) {
        if (!input.matches(CAR_REGEX)) {
            throw new IllegalArgumentException("경주할 자동차 이름을 잘 못 입력하셨습니다.");
        }
    }

    public void checkAboutRound(String input) {
        if (!input.matches(ROUND_REGEX)) {
            throw new IllegalArgumentException("시도할 횟수는 0이거나 비어있을 수 없습니다.");
        }
    }
}
