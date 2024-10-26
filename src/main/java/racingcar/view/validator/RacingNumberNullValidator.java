package racingcar.view.validator;

public class RacingNumberNullValidator implements RacingNumberValidator{

    @Override
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("경주 횟수는 빈 문자열일 수 없습니다.");
        }
    }
}
