package racingcar.domain;

public class Validator {

    public void validateEmptyRacingCarNames(String racingCarNames) {
        if (racingCarNames == null || racingCarNames.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차의 이름을 입력하지 않았습니다.");
        }
    }

    public void validateEmptyRacingCount(String racingCount) {
        if (racingCount == null || racingCount.isEmpty()) {
            throw new IllegalArgumentException("경주 횟수를 입력하지 않았습니다.");
        }
    }

    public void validateInvalidRacingCount(String racingCount) {
        try {
            Integer.parseInt(racingCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(racingCount + ": 숫자만 입력할 수 있습니다.");
        }
    }
}
