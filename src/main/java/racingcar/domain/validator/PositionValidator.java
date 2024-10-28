package racingcar.domain.validator;

public class PositionValidator {
    public void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다.");
        }
    }
}