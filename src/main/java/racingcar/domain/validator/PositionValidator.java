package racingcar.domain.validator;

public class PositionValidator {
    public void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이상의 정수여야 합니다.");
        }
    }
}