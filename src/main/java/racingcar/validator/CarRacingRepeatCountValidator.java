package racingcar.validator;

public class CarRacingRepeatCountValidator {

    public void validateRepeatCountNumberFormat(String inputCarRacingRepeatCount) {
        try {
            int count = Integer.parseInt(inputCarRacingRepeatCount);
            if (count <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 양의 정수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수만 가능합니다.");
        }
    }
}
